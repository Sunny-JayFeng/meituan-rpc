package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.bean.UserCoupon;
import jayfeng.com.meituan.rpc.orderserver.dao.discount.UserCouponDao;
import jayfeng.com.meituan.rpc.orderserver.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券扣除业务层
 * @author JayFeng
 * @date 2021/5/10
 */
@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private UserCouponDao userCouponDao;

    private static final Byte VALID = 0; // 优惠券有效状态
    private static final Byte USED = 1; // 优惠券已使用状态
    private static final Byte EXPIRED = 2; // 优惠券已过期状态

    /**
     * 扣除优惠券
     * @param user 用户
     * @param userCouponIds 用户优惠券 id
     * @return 返回扣除是否成功
     */
    @Override
    public Boolean deductionUserCoupon(User user, String userCouponIds) {
        log.info("deductionUserCoupon 扣除用户优惠券 user: {}, couponIds: {}", user, userCouponIds);
        List<UserCoupon> userCouponList = userCouponDao.selectByUserIdAndCouponIds(userCouponIds);
        for (UserCoupon userCoupon : userCouponList) {
            log.info("deductionUserCoupon 扣除优惠券, 状态更改为失效 userCoupon: {}", userCoupon);
        }
        userCouponDao.updateUserCouponsStatus(userCouponIds, USED, System.currentTimeMillis());
        log.info("deductionUserCoupon 优惠券扣除成功 userCouponIds: {}", userCouponIds);
        return true;
    }


}
