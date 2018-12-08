package com.gaop.state.core;

import com.gaop.state.constant.OrderStatusEnum;
import lombok.Data;

/**
 * @author carpeng.gao@qunar.com
 * @date 2018/10/29 17:47
 **/
@Data
public abstract class AbstractOrderOperator {

    int status;

    public abstract int handleEvent(int orderStatus, OrderStatusEnum orderStatusEnum);
}
