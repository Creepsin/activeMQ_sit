package com.zh.boot_acctivemq_consumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class comsumerTopic {

  /*  @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage){
        try {
            System.out.println("消费者收到订阅的主题：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }*/
}
