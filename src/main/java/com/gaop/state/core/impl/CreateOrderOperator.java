package com.gaop.state.core.impl;

import com.gaop.state.constant.OrderStatusEnum;
import com.gaop.state.core.AbstractOrderOperator;
import com.gaop.state.core.annotation.OrderOperator;
import org.springframework.stereotype.Component;

/**
 * 创建订单操作状态流转
 * @author carpeng.gao@qunar.com
 * @date 2018/10/29 17:50
 **/
@Component
@OrderOperator
public class CreateOrderOperator extends AbstractOrderOperator {

    public CreateOrderOperator() {
        super.setStatus(1);
    }

    @Override
    public int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum) {
        if (orderStatus != OrderStatusEnum.CREATE_EVENT.status && orderStatus != OrderStatusEnum.ORDER_CANCEL.status) {
            throw new IllegalArgumentException(String.format("create operation can't handle the status: %s", orderStatus));
        }
        System.out.println("进入创建订单状态扭转处理器...");
        switch (orderStatusEnum) {
            case CREATE_EVENT:
                return OrderStatusEnum.FORMAL_EVENT.status;
            case ORDER_CANCEL:
                return OrderStatusEnum.ORDER_CANCEL.status;
            default:
                return getStatus();
        }
    }
}
