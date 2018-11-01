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
     * @return 扭转后的订单状态
     */
    public int handleEvent(final String orderId, OrderStatusEnum event, final int status) {
        if (this.isFinalStatus(status)) {
            throw new IllegalArgumentException("handle event can't process final state order.");
        }
        // 获取对应处理器,根据入参状态和时间获取订单流转的结果状态
        AbstractOrderState abstractOrderState = this.getStateProcessor(event);
        int resState = abstractOrderState.handleEvent(status, event);
        // 得到结果状态，在对应的processor中处理订单数据及其相关信息
        AbstractOrderProcessor orderProcessor = this.getOrderProcessor(event);
        if (!orderProcessor.process(orderId, resState)) {
            throw new IllegalStateException(String.format("订单状态流转失败，订单id:%s", orderId));
        }
        return resState;
    }

    private AbstractOrderState getStateProcessor(OrderStatusEnum event) {

        return null;
    }

    private AbstractOrderProcessor getOrderProcessor(OrderStatusEnum event) {
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
