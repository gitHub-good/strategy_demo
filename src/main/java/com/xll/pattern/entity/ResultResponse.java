package com.xll.pattern.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author：xuliangliang
 * @Description：测试返回实体
 * @Date 2020/8/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {

    /**
     * 业务操作是否成功
     */
    private Boolean isSuccess;

    /**
     * 操作编号
     */
    private String errorCode;

    /**
     * 返回描述
     */
    private String msg;

    /**
     * 业务对应的实体数据
     */
    private T data;


    public ResultResponse(String msg){
        this.msg = msg;
    }

    public ResultResponse(String msg, Boolean isSuccess){
        this.msg = msg;
        this.isSuccess = isSuccess;
    }


}
