package com.xll.pattern.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @Author：xuliangliang
 * @Description：业务处理策略标识
 * @Date 2020/8/29
 */
@Getter
@AllArgsConstructor
public enum ServiceFlagEnum {

    //订单标识
    ORDER_MARK001("order_001", "订单业务001"),
    ORDER_MARK002("order_002", "订单业务002"),
    ORDER_MARK003("order_003", "订单业务003"),

    //商品标识
    ITEM_MARK001("item_001", "商品业务001"),
    ITEM_MARK002("item_002", "商品业务002"),
    ITEM_MARK003("item_003", "商品业务003");

    private static Map<String, ServiceFlagEnum> flagStrategyMap = new ConcurrentHashMap<>();
    static {
        for (ServiceFlagEnum strategy : ServiceFlagEnum.values()) {
            flagStrategyMap.put(strategy.mark, strategy);
        }
    }

    private String mark;
    private String msg;

    /**
     * 获取枚举
     * @param mark
     * @return
     */
    public static ServiceFlagEnum getFlagStrategy(String mark){
        return flagStrategyMap.get(mark);
    }

}
