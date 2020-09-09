package com.xll.pattern.strategy.proxy;

import com.xll.pattern.entity.ResultResponse;
import com.xll.pattern.strategy.ContextProxyInterface;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @Author：xuLiangLiang
 * @Description：业务上下文代理
 * @Date 2020/9/9
 */
@AllArgsConstructor
@Component
public class ServiceContextProxy<T>{

    private ApplicationContext applicationContext;
    /**
     * 执行业务域
     * @param t
     * @param classBiz
     * @return
     */
    public ResultResponse execute(T t, Class<? extends ContextProxyInterface> classBiz) {

        ContextProxyInterface<T, ResultResponse> contextProxyInterface = applicationContext.getBean(classBiz);

        return contextProxyInterface.doExecute(t);
    }
}
