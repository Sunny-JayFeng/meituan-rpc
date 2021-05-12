package jayfeng.com.meituan.rpc.orderserver.bean;

import lombok.Data;

/**
 * 红包实体类
 * @author JayFeng
 * @date 2021/5/10
 */
@Data
public class LuckyMoney {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户 id
     */
    private Integer userId;

    /**
     * 优惠券名字
     */
    private String name;

    /**
     * 有效时间(多长时间)
     */
    private Long validTime;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 满多少可用
     * 0 为无门槛
     */
    private Integer fullMoney;

    /**
     * 单次可用几张
     */
    private Byte canUseCount;

    /**
     * 使用后是否可以到店自取
     * 0 -- 否
     * 1 -- 是
     */
    private Byte canInStore;

    /**
     * 限登录和收餐手机号
     */
    private String phone;

    /**
     * 是否有效
     * 0 -- 否
     * 1 -- 是
     */
    private Byte isValid;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;


}
