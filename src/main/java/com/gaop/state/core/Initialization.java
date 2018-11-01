package com.gaop.state.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * 状态机前置激活类
 * @author carpeng.gao@qunar.com
 * @date 2018/10/31 15:30
 **/
public class Initialization implements BeanPostProcessor {

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
