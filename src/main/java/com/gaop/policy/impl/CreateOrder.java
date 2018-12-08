package com.gaop.policy.impl;

import com.gaop.policy.AbstractPolicy;
import com.gaop.state.model.Order;

/**
 * @author gaopeng@doctorwork.com
 * @description
 * @date 2018-10-29 22:20
 **/
public class CreateOrder extends AbstractPolicy{

    @Override
    public boolean updateBaseInfo(Order order) {
        return false;
    }

}
