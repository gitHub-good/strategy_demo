package com.xll.pattern.strategy.service;

import com.xll.pattern.entity.OrderPO;
import com.xll.pattern.entity.ResultResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @Author：xuliangliang
 * @Description：模拟订单业务逻辑处理
 * @Date 2020/8/28
 */
@Service
public class TestOrderBizService {

    /**
     * 业务逻辑1
     * @param order
     * @return
     */
    public ResultResponse bizOne(OrderPO order) {
        //业务逻辑处理
        ResultResponse<OrderPO> resultEntity = new ResultResponse(order.getId()+"业务逻辑1");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(order);
        return resultEntity;
    }

    /**
     * 业务逻辑2
     * @param order
     * @return
     */
    public ResultResponse bizTwo(OrderPO order) {
        ResultResponse<OrderPO> resultEntity = new ResultResponse(order.getId()+"业务逻辑2");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(order);
        return resultEntity;
    }

    /**
     * 业务逻辑3
     * @param order
     * @return
     */
    public ResultResponse bizThree(OrderPO order) {
        ResultResponse<OrderPO> resultEntity = new ResultResponse(order.getId()+"业务逻辑3");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(order);
        return resultEntity;
    }
}
