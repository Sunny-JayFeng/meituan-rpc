package jayfeng.com.meituan.rpc.orderserver.dao.discount;

import jayfeng.com.meituan.rpc.orderserver.bean.UserCoupon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户有效优惠券持久层
 * @author JayFeng
 * @date 2021/5/11
 */
@Repository
public interface UserCouponDao {

    /**
     * 根据用户优惠券 id 查出用户有效优惠券
     * @param userCouponIds 用户优惠券 id
     * @return 返回
     */
    @Select("SELECT * FROM `user_coupon` WHERE `status` = 0 AND `id` in (${userCouponIds})")
    List<UserCoupon> selectByUserIdAndCouponIds(@Param("userCouponIds") String userCouponIds);

    /**
     * 设置用户优惠券为已使用
     * @param userCouponIds 用户优惠券 id
     * @param status 状态
     * @param updateTime 更新时间
     */
    @Update("UPDATE `user_coupon` SET `status` = #{status}, `update_time` = #{updateTime} WHERE `id` in (${userCouponIds}) ")
    void updateUserCouponsStatus(@Param("userCouponIds") String userCouponIds, @Param("status") Byte status, @Param("updateTime") Long updateTime);
}
