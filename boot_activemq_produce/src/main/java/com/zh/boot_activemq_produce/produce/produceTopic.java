package com.zh.boot_activemq_produce.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
public class produceTopic {
    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Scheduled(fixedDelay = 3000)
    public void produceMsg(){
        messagingTemplate.convertAndSend(topic, "****发送主题：" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("the task for topic is sending!");
    }
}
