package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.dao.CouponDao;
import jayfeng.com.meituan.rpc.orderserver.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    /**
     * 扣除优惠券
     * @param user 用户
     * @param couponIds 优惠券 id
     * @return 返回扣除是否成功
     */
    @Override
    public Boolean deductionUserCoupon(User user, String couponIds) {
        log.info("deductionUserCoupon 扣除用户优惠券 user: {}, couponIds: {}", user, couponIds);
        return null;
    }

}
