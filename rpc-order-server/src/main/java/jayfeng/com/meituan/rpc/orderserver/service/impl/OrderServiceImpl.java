package jayfeng.com.meituan.rpc.orderserver.service.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jayfeng.com.meituan.rpc.orderserver.bean.Allowance;
import jayfeng.com.meituan.rpc.orderserver.bean.Order;
import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.exception.ServerBusyException;
import jayfeng.com.meituan.rpc.orderserver.service.AllowanceService;
import jayfeng.com.meituan.rpc.orderserver.service.CouponService;
import jayfeng.com.meituan.rpc.orderserver.service.LuckyMoneyService;
import jayfeng.com.meituan.rpc.orderserver.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.threadpool.support.fixed.FixedThreadPool;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.concurrent.*;

@Slf4j
@DubboService(version = "1.0.0")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private AllowanceService allowanceService;
    @Autowired
    private LuckyMoneyService luckyMoneyService;
    @Autowired
    private CouponService couponService;

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 30, 30L, TimeUnit.SECONDS,
                                                    new ArrayBlockingQueue<Runnable>(128),
                                                    new ThreadFactoryBuilder().build(),
                                                    new ThreadPoolExecutor.CallerRunsPolicy() {
                                                        @Override
                                                        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                                                            throw new ServerBusyException("系统繁忙, 请稍后再试");
                                                        }
                                                    });

    /**
     * 创建订单
     * todo 一个线程去扣除津贴(远程调用)、一个线程去扣除美团红包(若有)(远程调用)、一个线程去更新优惠券信息(远程调用)
     * todo 通知商家接单(一对一消息通知)
     * todo 通知骑手抢单(一对多消息广播，区域性广播？)
     * @param order 订单
     * @param user 用户
     * @return 返回创建是否成功
     */
    @Override
    public Boolean createOrder(Order order, User user) throws ExecutionException, InterruptedException {
        log.info("createOrder 创建订单 order: {}, user: {}", order, user);

        Future<Boolean> deductAllowanceResult = null;
        Future<Boolean> deductLuckyMoneyResult = null;
        Future<Boolean> deductCouponResult = null;
        // 提交扣除津贴任务
        if (order.getAllowanceDiscount() != 0) {
            deductAllowanceResult = threadPoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return allowanceService.deductionUserAllowance(user, order.getAllowanceId(), order.getAllowanceDiscount());
                }
            });
        }

        // 提交扣除红包任务
        if (order.getLuckyMoneyId() != -1) {
            deductLuckyMoneyResult = threadPoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return luckyMoneyService.deductionUserLuckyMoney(user, order.getLuckyMoneyId());
                }
            });
        }

        // 提交扣除优惠券任务
        if (!"".equals(order.getCouponIds())) {
            deductCouponResult = threadPoolExecutor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return couponService.deductionUserCoupon(user, order.getCouponIds());
                }
            });
        }

        // 扣除结果
        if ((deductAllowanceResult == null || deductAllowanceResult.get()) &&
            (deductLuckyMoneyResult == null || deductLuckyMoneyResult.get()) &&
            (deductCouponResult == null || deductCouponResult.get())) {
            // todo 均扣除成功, 通知商家接单、通知骑手抢单
        }
        return true;
    }

}
