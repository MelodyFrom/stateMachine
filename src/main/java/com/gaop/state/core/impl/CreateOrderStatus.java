package com.gaop.state.core.impl;

import com.gaop.state.constant.OrderStatusEnum;
import com.gaop.state.core.AbstractOrderState;

/**
 * 创建订单操作状态流转
 * @author carpeng.gao@qunar.com
 * @date 2018/10/29 17:50
 **/
public class CreateOrderStatus extends AbstractOrderState{

    @Override
    public int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum) {
        if (orderStatus != OrderStatusEnum.CREATE_EVENT.status && orderStatus != OrderStatusEnum.ORDER_CANCEL.status) {
            throw new IllegalArgumentException(String.format("create operation can't handle the status: %s", orderStatus));
        }
        switch (orderStatusEnum) {
            case CREATE_EVENT:
                return OrderStatusEnum.CREATE_EVENT.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.ORDER_CANCEL.status;
            default:
                return getStatus();
        }
    }
}
