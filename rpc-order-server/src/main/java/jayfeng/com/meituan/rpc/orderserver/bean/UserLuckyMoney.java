package jayfeng.com.meituan.rpc.orderserver.bean;

import lombok.Data;

/**
 * 用户有效红包
 * @author JayFeng
 * @date 2021/5/11
 */
@Data
public class UserLuckyMoney {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户 id
     */
    private Integer userId;

    /**
     * 红包 id
     */
    private Integer luckyMoneyId;

    /**
     * 状态
     * 0 -- 有效
     * 1 -- 已使用
     * 2 -- 已过期
     */
    private Byte status;

    /**
     * 有效期至
     */
    private Long validTime;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

}
