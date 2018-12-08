package com.gaop.state.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 订单状态流传操作后处理器标识注解，用于初始化操作
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface OrderProcessor {
}
