package com.gaop.state.core;

import com.gaop.state.constant.OrderStatusEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单状态流转管理器--状态机核心组件
 * @author carpeng.gao@qunar.com
 * @date 2018/10/29 19:21
 **/
@Component
public class OrderStateManager {

    Map<Integer, AbstractOrderOperator> orderOperatorMaps = new HashMap<Integer, AbstractOrderOperator>();

    Map<Integer, AbstractOrderProcessor> orderProcessorMaps = new HashMap<Integer, AbstractOrderProcessor>();

    public OrderStateManager() { }

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
        AbstractOrderOperator abstractOrderOperator = this.getStateOperator(event);
        int resState = abstractOrderOperator.handleEvent(status, event);
        // 得到结果状态，在对应的processor中处理订单数据及其相关信息
        AbstractOrderProcessor orderProcessor = this.getOrderProcessor(event);
        if (!orderProcessor.process(orderId, resState)) {
            throw new IllegalStateException(String.format("订单状态流转失败，订单id:%s", orderId));
        }
        return resState;
    }

    /**
     * 根据入参状态枚举实例获取对应的状态处理器
     * @param event event
     * @return
     */
    private AbstractOrderOperator getStateOperator(OrderStatusEnum event) {
        AbstractOrderOperator operator = null;
        for (Map.Entry<Integer, AbstractOrderOperator> entry: orderOperatorMaps.entrySet()) {
            if (event.status == entry.getKey()) {
                operator = entry.getValue();
            }
        }
        if (null == operator) {
            throw new IllegalArgumentException(String.format("can't find proper operator. The parameter state :%s", event.toString()));
        }
        return operator;
    }

    /**
     * 根据入参状态枚举实例获取对应的状态后处理器
     * @param event event
     * @return
     */
    private AbstractOrderProcessor getOrderProcessor(OrderStatusEnum event) {
        AbstractOrderProcessor processor = null;
        for (Map.Entry<Integer, AbstractOrderProcessor> entry : orderProcessorMaps.entrySet()) {
            if (event.status == entry.getKey()) {
                processor = entry.getValue();
            }
        }
        if (null == processor) {
            throw new IllegalArgumentException(String.format("can't find proper processor. The parameter state :%s", event.toString()));
        }
        return processor;
    }


    /**
     * 判断是不是已完成订单
     * @param status 订单状态码
     * @return
     */
    private boolean isFinalStatus(int status) {
        return OrderStatusEnum.ORDER_FINISHED.status == status;
    }

}
