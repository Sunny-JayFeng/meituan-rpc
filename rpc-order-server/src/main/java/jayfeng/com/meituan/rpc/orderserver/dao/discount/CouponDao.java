package jayfeng.com.meituan.rpc.orderserver.dao.discount;

import jayfeng.com.meituan.rpc.orderserver.bean.Coupon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户优惠券持久层
 * @author JayFeng
 * @date 2021/5/10
 */
@Repository
public interface CouponDao {

    /**
     * 根据优惠券 id 列表查出优惠券
     * @param couponIds 优惠券 id 列表
     * @return 返回
     */
    @Select("SELECT `id`, `user_id`, `money`, `coupon_name`, `use_rule`, `valid_time`, `is_valid` FROM `coupon` " +
            " WHERE `id` in (${couponIds})")
    List<Coupon> selectByCouponIds(@Param("couponIds") String couponIds);


}
