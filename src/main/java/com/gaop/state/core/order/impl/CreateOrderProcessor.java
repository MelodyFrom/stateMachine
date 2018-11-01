package com.gaop.state.core.order.impl;

import com.gaop.state.core.AbstractOrderProcessor;

/**
 * @author carpeng.gao@qunar.com
 * @date 2018/10/31 14:59
 **/
public class CreateOrderProcessor extends AbstractOrderProcessor{

    @Override
    public boolean process(String orderId, Object... params) {
        // TODO 创建/取消订单对应的数据库修改，mq发送等操作，可以在此处process方法中完成
        return true;
    }
}
