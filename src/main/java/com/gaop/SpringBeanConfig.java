package com.gaop;

import com.gaop.state.core.Initialization;
import com.gaop.state.core.OrderStateManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaopeng@doctorwork.com
 * @description
 * @date 2018-12-08 16:09
 **/
@ComponentScan
@Configuration
public class SpringBeanConfig {

    @Bean
    public Initialization initialization() {
        return new Initialization();
    }

    @Bean
    public OrderStateManager orderStateManager() {
        return new OrderStateManager();
    }
}
