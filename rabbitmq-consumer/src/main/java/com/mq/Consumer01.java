package com.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer01 {
    private static final String QUEUE = "helloworld";
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
            channel.queueDeclare(QUEUE,true,false,false,null);
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

            channel.basicConsume(QUEUE,true,defaultConsumer);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
