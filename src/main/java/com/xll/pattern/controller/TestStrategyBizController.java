package com.xll.pattern.controller;

import com.xll.pattern.entity.ItemPO;
import com.xll.pattern.entity.OrderPO;
import com.xll.pattern.entity.ResultResponse;
import com.xll.pattern.strategy.context.ItemBizContext;
import com.xll.pattern.strategy.context.OrderBizContext;
import com.xll.pattern.strategy.proxy.ServiceContextProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author：xuliangliang
 * @Description：测试策略模式
 * @Date 2020/8/28
 */
@RestController
public class TestStrategyBizController {
    @Autowired
    private ServiceContextProxy serviceContextProxy;

    @PostMapping(value = "/v1/biz/test/order", produces="application/json")
    public ResultResponse orderTest(OrderPO orderEntity) {
        if(StringUtils.isEmpty(orderEntity.getMark())){
            return new ResultResponse("没有Mark标识", false);
        }
        ResultResponse resultEntity = serviceContextProxy.execute(orderEntity, OrderBizContext.class);
        return resultEntity;
    }

    @PostMapping(value = "/v1/biz/test/item", produces="application/json")
    public ResultResponse itemTest(ItemPO itemEntity) {
        if(StringUtils.isEmpty(itemEntity.getMark())){
            return new ResultResponse("没有Mark标识", false);
        }
        ResultResponse resultEntity = serviceContextProxy.execute(itemEntity, ItemBizContext.class);
        return resultEntity;
    }
}
