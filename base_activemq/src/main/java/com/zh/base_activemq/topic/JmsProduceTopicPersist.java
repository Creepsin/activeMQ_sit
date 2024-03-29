package com.zh.base_activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduceTopicPersist {
    public static final String ACTIVEMQ_URL = "tcp://39.106.85.90:61616";
    public static final String ACTIVEMQ_USERNAME = "admin";
    public static final String ACTIVEMQ_PASSWORD = "admin";
    public static final String TOPIC_NAME = "topic-persist-jdbc";

    public static void main(String[] args) throws Exception{
        //1.创建连接工厂，按照给定的URL地址，采用默认的用户名个密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_USERNAME, ACTIVEMQ_PASSWORD, ACTIVEMQ_URL);

        //2.通过连接工厂，获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();

        //3.创建会话session,第一个参数是事物，第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //4.创建目的地（具体是队列还是主题）
        Topic topic = session.createTopic(TOPIC_NAME);

        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        //6.通过使用MessageProducer生产3条消息发送到MQ的队列中
        for (int i = 0; i < 3; i++){
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("TOPIC_NAME----" + i);
            //设置消息属性，增加识别度
            textMessage.setStringProperty("c01", "message--vip1");
            //8.通过MessageProducer发送到MQ
            messageProducer.send(textMessage);
        }
        //9.逆序关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("****TOPIC_NAME消息已发送到MQ");
    }
}
