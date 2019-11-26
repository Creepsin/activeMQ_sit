package com.zh.boot_acctivemq_consumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class consumerQueue {
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage){
        try {
            System.out.println("****收到队列中的消息" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
