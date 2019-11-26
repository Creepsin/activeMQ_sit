package com.zh.boot_activemq_produce.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class ConfigBeanQueue {
    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }
}
