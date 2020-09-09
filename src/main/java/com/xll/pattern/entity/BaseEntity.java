package com.xll.pattern.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @Author：xuliangliang
 * @Description：实体父类
 * @Date 2020/8/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    /**
     * 业务标识
     */
    private String mark;

    /**
     * 业务域标识
     */
    private String markDoMain;
}
