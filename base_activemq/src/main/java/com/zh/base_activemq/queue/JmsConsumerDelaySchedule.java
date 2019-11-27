package com.zh.base_activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumerDelaySchedule {
    public static final String ACTIVEMQ_URL = "tcp://39.106.85.90:61616";
    public static final String ACTIVEMQ_USERNAME = "admin";
    public static final String ACTIVEMQ_PASSWORD = "admin";
    public static final String QUEUE_NAME = "delaySchedule";

    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_USERNAME, ACTIVEMQ_PASSWORD, ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);

        //同步阻塞
        while (true){
            //如果receive方法不带时间参数，那么就代表一直监听
            TextMessage textMessage = (TextMessage) messageConsumer.receive(4000L);
            if (null != textMessage){
                System.out.println("******消费者接收到消息" + textMessage.getText());
            }else {
                break;
            }
        }

        messageConsumer.close();
        session.close();
        connection.close();

      /*  //异步非阻塞（通过监听的方式来消费消息）
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("*******消费者接收到消息：" + textMessage.getText());
                    } catch (JMSException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        System.in.read();//保证控制台不灭
        messageConsumer.close();
        session.close();
        connection.close();*/
    }
}
