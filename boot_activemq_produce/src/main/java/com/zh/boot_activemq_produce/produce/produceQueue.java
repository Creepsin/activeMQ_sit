package com.zh.boot_activemq_produce.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class produceQueue {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    public void produceMsg(){
        messagingTemplate.convertAndSend(queue, "****:" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("this task is sending!");
    }
}
