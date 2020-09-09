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
public class OrderPO extends BaseEntity {

    /**
     * 订单ID
     */
    private String id;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 订单数量
     */
    private Integer orderQty;

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
    private List<String> orderStatusList;

}
