package com.gaop.state.core;

import lombok.Data;

/**
 * 订单处理器
 * @author carpeng.gao@qunar.com
 * @date 2018/10/31 14:57
 **/
@Data
public abstract class AbstractOrderProcessor {

    int status;

    public abstract boolean process(String orderId, Object... params);
}
