package com.gaop.state.core;

/**
 * 订单处理器
 * @author carpeng.gao@qunar.com
 * @date 2018/10/31 14:57
 **/
public abstract class AbstractOrderProcessor {

    public abstract boolean process(String orderId, Object... params);
}
