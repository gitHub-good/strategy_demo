package com.xll.pattern.strategy.context;

import com.xll.pattern.entity.OrderPO;
import com.xll.pattern.entity.ResultResponse;
import com.xll.pattern.enums.ServiceFlagEnum;
import com.xll.pattern.strategy.ContextProxyInterface;
import com.xll.pattern.strategy.service.TestOrderBizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 *
 * @Author：xuLiangLiang
 * @Description：订单上下文
 * @Date 2020/9/9
 */
@AllArgsConstructor
@Component
public class OrderBizContext implements ContextProxyInterface<OrderPO, ResultResponse> {

    private final TestOrderBizService testOrderBizService;
    /**
     *存储策略方法 测试订单业务逻辑
     */
    private Map<ServiceFlagEnum, Function<OrderPO, ResultResponse>> checkResultDispatcherOrderComX = new ConcurrentHashMap<>();


    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    private void checkResultDispatcherComXInit() {
        //订单业务
        checkResultDispatcherOrderComX.put(ServiceFlagEnum.ORDER_MARK001, order -> testOrderBizService.bizOne(order));
        checkResultDispatcherOrderComX.put(ServiceFlagEnum.ORDER_MARK002, order -> testOrderBizService.bizTwo(order));
        checkResultDispatcherOrderComX.put(ServiceFlagEnum.ORDER_MARK003, order -> testOrderBizService.bizThree(order));
    }

    /**
     * 获取策略逻辑
     * @param order
     * @param mark
     * @return
     */
    private ResultResponse getCheckResultOrderComX(OrderPO order, String mark) {

        ServiceFlagEnum flagStrategy = ServiceFlagEnum.getFlagStrategy(mark);
        if(flagStrategy == null){
            return new ResultResponse("没有["+mark+"]标识业务");
        }

        Function<OrderPO, ResultResponse> result = checkResultDispatcherOrderComX.get(flagStrategy);
        if (result != null) {
            //执行这段表达式获得的结果
            return result.apply(order);
        }

        return new ResultResponse("不在处理的逻辑中返回业务错误");
    }

    @Override
    public ResultResponse doExecute(OrderPO orderEntity) {
        return getCheckResultOrderComX(orderEntity, orderEntity.getMark());
    }
}
