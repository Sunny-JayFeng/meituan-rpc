package jayfeng.com.meituan.rpc.orderserver.bean;

import lombok.Data;

/**
 * 用户津贴实体类
 * @author JayFeng
 * @date 2021/5/10
 */
@Data
public class Allowance {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户 id
     */
    private Integer userId;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 有效期至
     */
    private Long validDate;

    /**
     * 说明
     * 津贴可与满减、折扣商品、红包叠加使用
     */
    private String explain;

}
