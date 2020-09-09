package com.xll.pattern.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 *
 * @Author：xuliangliang
 * @Description：测试实体
 * @Date 2020/8/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPO extends BaseEntity{

    /**
     * 订单ID
     */
    private String id;

    /**
     * 订单编码
     */
    private String itemCode;

    /**
     * 订单数量
     */
    private Integer itemQty;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 订单状态
     */
    private List<String> itemParams;

}
