package com.gaop.test;

import com.gaop.SpringBeanConfig;
import com.gaop.state.constant.OrderStatusEnum;
import com.gaop.state.core.OrderStateManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gaopeng@doctorwork.com
 * @description
 * @date 2018-12-08 16:08
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBeanConfig.class)
public class StateMachineTest {

    @Autowired
    private OrderStateManager orderStateManager;

    @Test
    public void createTest() {
        Assert.assertEquals(2, orderStateManager.handleEvent("123", OrderStatusEnum.CREATE_EVENT, 1));
    }

//    @Test
//    public void cancelTest() {
//        Assert.assertEquals(6, orderStateManager.handleEvent("123", OrderStatusEnum.ORDER_CANCEL, 1));
//    }
}
