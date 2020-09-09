package com.xll.pattern.strategy.context;

import com.xll.pattern.entity.ItemPO;
import com.xll.pattern.entity.ResultResponse;
import com.xll.pattern.enums.ServiceFlagEnum;
import com.xll.pattern.strategy.ContextProxyInterface;
import com.xll.pattern.strategy.ServiceStrategyInterface;
import com.xll.pattern.strategy.service.TestItemBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @Author：xuliangliang
 * @Description：商品上下文
 * @Date 2020/8/28
 */
@Component
public class ItemBizContext implements ContextProxyInterface<ItemPO, ResultResponse> {

    @Autowired
    private TestItemBizService testItemBizService;

    /**
     * 存储策略方法 商品业务逻辑
     */
    private Map<ServiceFlagEnum, ServiceStrategyInterface<ItemPO, ResultResponse>> checkResultDispatcherItemComX = new ConcurrentHashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    private void checkResultDispatcherComXInit() {
        //商品业务
        checkResultDispatcherItemComX.put(ServiceFlagEnum.ITEM_MARK001, item-> testItemBizService.bizOne(item));
        checkResultDispatcherItemComX.put(ServiceFlagEnum.ITEM_MARK002, item-> testItemBizService.bizTwo(item));
        checkResultDispatcherItemComX.put(ServiceFlagEnum.ITEM_MARK003, item-> testItemBizService.bizThree(item));
    }

    /**
     * 获取策略逻辑
     * @param order
     * @param mark
     * @return
     */
    private ResultResponse getCheckResultItemComX(ItemPO order, String mark) {

        ServiceStrategyInterface<ItemPO, ResultResponse> result = checkResultDispatcherItemComX.get(ServiceFlagEnum.getFlagStrategy(mark));
        if (result != null) {
            //执行这段表达式获得的结果
            return result.doExecute(order);
        }

        return new ResultResponse("不在处理的逻辑中返回业务错误");
    }

    @Override
    public ResultResponse doExecute(ItemPO itemEntity) {
        return getCheckResultItemComX(itemEntity, itemEntity.getMark());
    }
}
