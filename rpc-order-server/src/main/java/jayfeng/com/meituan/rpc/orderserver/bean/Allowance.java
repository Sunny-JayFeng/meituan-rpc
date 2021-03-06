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
    private Float money;

    /**
     * 有效时间(多长时间)
     */
    private Long validTime;

    /**
     * 说明
     * 津贴可与满减、折扣商品、红包叠加使用
     */
    private String explain;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

}
