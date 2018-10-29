package com.gaop.state.core;

import com.gaop.state.constant.OrderStatusEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 订单状态流转管理器--状态机核心组件
 * @author carpeng.gao@qunar.com
 * @date 2018/10/29 19:21
 **/
public class OrderStateManager {

    Map<Integer, AbstractOrderState> maps = new ConcurrentHashMap<Integer, AbstractOrderState>();

    public OrderStateManager() {
        this.initializeStatesMgr();
    }

    /**
     * 状态流转方法
     * @param orderId 订单id
     * @param event 流转的订单操作事件
     * @param status 当前订单状态
     * @return
     */
    public int handleEvent(final String orderId, OrderStatusEnum event, final int status) {
        if (this.isFinalStatus(status)) {
            throw new IllegalArgumentException("handle event can't process final state order.");
        }

        return 0;
    }

    private AbstractOrderState getStateProcessor(OrderStatusEnum event) {

        return null;
    }

    /**
     * 判断是不是已完成订单
     * @param status 订单状态码
     * @return
     */
    private boolean isFinalStatus(int status) {
        return OrderStatusEnum.ORDER_FINISHED.status == status;
    }

    private void initializeStatesMgr() {
        for (OrderStatusEnum item : OrderStatusEnum.values()) {
//            maps.put(item.status, item);
        }
    }
}
