package com.xll.pattern.enums;
/**
 *
 * @Author：xuLiangLiang
 * @Description 业务上下文域标识
 * @Date 2020/9/9
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum  DomainMarkEnum {

    ORDER_DOMAIN("order", "订单业务域"),
    ITEM_DOMAIN("item", "商品业务域")
    ;
    private String mark;

    private String msg;

    static Map<String, DomainMarkEnum> domainMarkEnumMap = new HashMap<>();

    static {
        DomainMarkEnum[] values = DomainMarkEnum.values();
        for (DomainMarkEnum value : values) {
            domainMarkEnumMap.put(value.getMark(), value);
        }
    }

    /**
     * 获取枚举
     * @param mark
     * @return
     */
    public DomainMarkEnum getDomainMark(String mark){
        return domainMarkEnumMap.get(mark);
    }

}
