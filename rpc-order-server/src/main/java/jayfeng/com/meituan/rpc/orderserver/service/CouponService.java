package jayfeng.com.meituan.rpc.orderserver.service;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface CouponService {

    /**
     * 扣除优惠券
     * @param user 用户
     * @param couponIds 优惠券 id
     * @return 返回扣除是否成功
     */
    Boolean deductionUserCoupon(User user, String couponIds);

}
