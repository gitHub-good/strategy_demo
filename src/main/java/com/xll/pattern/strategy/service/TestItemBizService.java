package com.xll.pattern.strategy.service;

import com.xll.pattern.entity.ItemPO;
import com.xll.pattern.entity.ResultResponse;
import org.springframework.stereotype.Service;
/**
 *
 * @Author：xuliangliang
 * @Description：模拟商品业务逻辑处理单元
 * @Date 2020/8/28
 */
@Service
public class TestItemBizService {

    /**
     * 业务逻辑1
     * @param item
     * @return
     */
    public ResultResponse bizOne(ItemPO item) {
        //业务逻辑处理
        ResultResponse<ItemPO> resultEntity = new ResultResponse(item.getId()+"业务逻辑1");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(item);
        return resultEntity;
    }

    /**
     * 业务逻辑2
     * @param item
     * @return
     */
    public ResultResponse bizTwo(ItemPO item) {
        ResultResponse<ItemPO> resultEntity = new ResultResponse(item.getId()+"业务逻辑2");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(item);
        return resultEntity;
    }

    /**
     * 业务逻辑3
     * @param item
     * @return
     */
    public ResultResponse bizThree(ItemPO item) {
        ResultResponse<ItemPO> resultEntity = new ResultResponse(item.getId()+"业务逻辑3");
        resultEntity.setIsSuccess(Boolean.TRUE);
        resultEntity.setErrorCode("200");
        resultEntity.setData(item);
        return resultEntity;
    }
}
