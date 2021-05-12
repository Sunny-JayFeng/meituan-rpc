package jayfeng.com.meituan.rpc.orderserver.dao.discount;

import jayfeng.com.meituan.rpc.orderserver.bean.UserLuckyMoney;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 用户有效红包持久层
 * @author JayFeng
 * @date 2021/5/11
 */
@Repository
public interface UserLuckyMoneyDao {

    /**
     * 根据 id 查出用户有效的红包
     * @param userLuckyMoneyId 用户红包id
     * @return 返回
     */
    @Select("SELECT * FROM `user_lucky_money` WHERE `id` = #{userLuckyMoneyId} AND `status` = 0 ")
    UserLuckyMoney selectById(@Param("userLuckyMoneyId") Integer userLuckyMoneyId);

    @Update("UPDATE `user_lucky_money` SET `status` = #{status}, `update_time` = #{updateTime} WHERE `id` = #{userLuckyMoneyId} ")
    void updateUserLuckyStatus(@Param("userLuckyMoneyId") Integer userLuckyMoneyId, @Param("status") Byte status, @Param("updateTime") Long updateTime);
}
