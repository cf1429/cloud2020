package com.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * email消费着
 */
public class Cosumer04_topics_eamil {
    private static final String QUEUE_INFORM_EMAIL = "queue_email";
    private static final String EXCHAGE_TOPICS_INFORM = "exchage_topics_info";
    private static final String INFORM_EMAIL_ROUTING = "inform.#.email.#";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            /**
             * 参数明细：
             * 1、队列名称
             * 2、是否持久化，如果持久化，mq重启还在
             * 3、是否独占连接，队列只允许在连接中
             */
            channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
            // 申明一个交换机
            /**
             * 交换机名称
             * 交换机类型
             * fanout  对应工作模式发布订阅
             * direct 对应路由模式
             * topic 对应统配符
             * headers 对应headers转发器
             *
             *
             */
            channel.exchangeDeclare(EXCHAGE_TOPICS_INFORM,BuiltinExchangeType.TOPIC);
            // 交换机和队列绑定
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHAGE_TOPICS_INFORM,INFORM_EMAIL_ROUTING);

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
                // 接收到消息后才方法被调用
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    envelope.getExchange();
                    envelope.getDeliveryTag();
                    String message = new String(body,"utf-8");
                    System.out.println("receive message:" + message);
                }
            };

            channel.basicConsume(QUEUE_INFORM_EMAIL,true,defaultConsumer);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}
