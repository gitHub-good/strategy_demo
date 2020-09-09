package com.xll.pattern.strategy;
/**
 *
 * @Author：xuliangliang
 * @Description：上下文代理接口  T：入参实体， R：出参实体
 * @Date 2020/9/9
 */
@FunctionalInterface
public interface ContextProxyInterface<T, R> {

    /**
     * 业务执行器
     * @param t
     * @return
     */
    R doExecute(T t);

}
