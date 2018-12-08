package com.gaop.state.core;

import com.gaop.state.core.annotation.OrderOperator;
import com.gaop.state.core.annotation.OrderProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 状态机前置激活类,在spring中扫描配置此类 <br/>
 * 使用自定义注解标记对应的状态处理器和后置处理器并在初始化操作中完成对应处理器的初始化。
 * @author carpeng.gao@qunar.com
 * @date 2018/10/31 15:30
 **/
@Component
public class Initialization implements BeanPostProcessor {

    @Resource
    OrderStateManager manager;

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AbstractOrderOperator && bean.getClass().isAnnotationPresent(OrderOperator.class) ) {
            AbstractOrderOperator orderState = (AbstractOrderOperator) bean;
            manager.orderOperatorMaps.put(orderState.getStatus(), orderState);
        }
        if (bean instanceof AbstractOrderProcessor && bean.getClass().isAnnotationPresent(OrderProcessor.class) ) {
            AbstractOrderProcessor orderProcessor = (AbstractOrderProcessor) bean;
            manager.orderProcessorMaps.put(orderProcessor.getStatus(), orderProcessor);
        }
        return bean;
    }
}
