package jayfeng.com.meituan.rpc.orderserver.dao.discount;

import jayfeng.com.meituan.rpc.orderserver.bean.Allowance;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 用户津贴持久层
 * @author JayFeng
 * @date 2021/5/10
 */
@Repository
public interface AllowanceDao {

    /**
     * 根据 id 查出津贴信息
     * @param allowanceId id
     * @return 返回
     */
    @Select("SELECT `id`, `user_id`, `money`, `valid_time`, `is_valid`, `explain` FROM `allowance` WHERE `id` = #{allowanceId}")
    Allowance findAllowanceById(@Param("allowanceId") Integer allowanceId);

    /**
     * 扣除津贴后更新越
     * @param allowanceId 津贴 id
     * @param money 余额
     * @param updateTime 更新时间
     */
    @Update("UPDATE `allowance` SET `money` = #{money}, `update_time` = #{updateTime} WHERE `id` = #{allowanceId} ")
    void updateAllowanceMoney(@Param("allowanceId") Integer allowanceId, @Param("money") Float money, Long updateTime);

}
