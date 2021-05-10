package jayfeng.com.meituan.rpc.orderserver.bean;

import lombok.Data;

/**
 * 用户优惠券实体类
 * @author JayFeng
 * @date 2021/5/10
 */
@Data
public class Coupon {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户 id
     */
    private Integer userId;

    /**
     * 优惠金额
     */
    private Integer money;

    /**
     * 优惠券名字
     */
    private String couponName;

    /**
     * 使用规则
     */
    private String useRule;

    /**
     * 有效时间
     */
    private Long validTime;

    /**
     * 状态
     * 0 -- 失效
     * 1 -- 有效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

}
