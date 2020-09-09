//package com.xll.pattern.strategy;
//
//import com.xll.pattern.entity.strategy.TestItemEntity;
//import com.xll.pattern.entity.strategy.TestOrderEntity;
//import com.xll.pattern.entity.strategy.TestServiceResultEntity;
//import com.xll.pattern.enums.ServiceFlagStrategy;
//import com.xll.pattern.strategy.service.TestItemBizService;
//import com.xll.pattern.strategy.service.TestOrderBizService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Function;
//
///**
// *
// * @Author：xuliangliang
// * @Description：策略模式 业务上下文配置接口 第一版
// * @Date 2020/8/28
// */
//@Service
//public class TestBizService{
//
//    @Autowired
//    private TestOrderBizService testOrderBizService;
//
//    @Autowired
//    private TestItemBizService testItemBizService;
//
//    /**
//     *存储策略方法 测试订单业务逻辑
//     */
//    private Map<ServiceFlagStrategy, Function<TestOrderEntity, TestServiceResultEntity>> checkResultDispatcherOrderComX = new ConcurrentHashMap<>();
//
//    /**
//     * 存储策略方法 商品业务逻辑
//     */
//    private Map<ServiceFlagStrategy, ServiceStrategyInterface<TestItemEntity, TestServiceResultEntity>> checkResultDispatcherItemComX = new ConcurrentHashMap<>();
//
//    /**
//     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
//     */
//    @PostConstruct
//    public void checkResultDispatcherComXInit() {
//        //订单业务
//        checkResultDispatcherOrderComX.put(ServiceFlagStrategy.ORDER_MARK001, order -> testOrderBizService.bizOne(order));
//        checkResultDispatcherOrderComX.put(ServiceFlagStrategy.ORDER_MARK002, order -> testOrderBizService.bizTwo(order));
//        checkResultDispatcherOrderComX.put(ServiceFlagStrategy.ORDER_MARK003, order -> testOrderBizService.bizThree(order));
//
//        //商品业务
//        checkResultDispatcherItemComX.put(ServiceFlagStrategy.ITEM_MARK001, item-> testItemBizService.bizOne(item));
//        checkResultDispatcherItemComX.put(ServiceFlagStrategy.ITEM_MARK002, item-> testItemBizService.bizTwo(item));
//        checkResultDispatcherItemComX.put(ServiceFlagStrategy.ITEM_MARK003, item-> testItemBizService.bizThree(item));
//    }
//
//    /**
//     * 获取策略逻辑
//     * @param order
//     * @param mark
//     * @return
//     */
//    public TestServiceResultEntity getCheckResultOrderComX(TestOrderEntity order, String mark) {
//
//        ServiceFlagStrategy flagStrategy = ServiceFlagStrategy.getFlagStrategy(mark);
//        if(flagStrategy == null){
//            return new TestServiceResultEntity("没有["+mark+"]标识业务");
//        }
//
//        Function<TestOrderEntity, TestServiceResultEntity> result = checkResultDispatcherOrderComX.get(flagStrategy);
//        if (result != null) {
//            //执行这段表达式获得的结果
//            return result.apply(order);
//        }
//
//        return new TestServiceResultEntity("不在处理的逻辑中返回业务错误");
//    }
//
//
//    /**
//     * 获取策略逻辑
//     * @param order
//     * @param mark
//     * @return
//     */
//    public TestServiceResultEntity getCheckResultItemComX(TestItemEntity order, String mark) {
//
//        ServiceStrategyInterface<TestItemEntity, TestServiceResultEntity> result = checkResultDispatcherItemComX.get(ServiceFlagStrategy.getFlagStrategy(mark));
//        if (result != null) {
//            //执行这段表达式获得的结果
//            return result.doExecute(order);
//        }
//
//        return new TestServiceResultEntity("不在处理的逻辑中返回业务错误");
//    }
//
//}
