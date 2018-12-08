package com.gaop.policy;

import com.gaop.state.model.Order;

/**
 * @author gaopeng@doctorwork.com
 * @description
 * @date 2018-10-29 22:16
 **/
public abstract class AbstractPolicy {

    public abstract boolean updateBaseInfo(Order order);

    public boolean complateOtherInfo(Object... args) {
        return false;
    }
}
