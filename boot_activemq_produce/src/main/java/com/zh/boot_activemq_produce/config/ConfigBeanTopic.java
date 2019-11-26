package com.zh.boot_activemq_produce.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
public class ConfigBeanTopic {
    @Value("${myTopic}")
    private String topicName;

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }
}
