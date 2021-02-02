package com.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq 入门程序
 */
public class Producer01 {
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) {
        // 通过工厂代理访问mq
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672); // 端口
        factory.setUsername("guest");
        factory.setPassword("guest");

        factory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            // 新建连接
            connection = factory.newConnection();
            // 新建会话通道，所有的通信都在channel通道中完成
            channel = connection.createChannel();
            // 申明一个队列
            /**
             * 参数明细：
             * 1、队列名称
             * 2、是否持久化，如果持久化，mq重启还在
             * 3、是否独占连接，队列只允许在连接中
             */
             channel.queueDeclare(QUEUE,true,false,false,null);
             String messge = "小米 你好，";
             channel.basicPublish("",QUEUE,null,messge.getBytes());
             System.out.println("发送记录----"+messge);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            try {
                try {
                    channel.close();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                if(connection != null ){
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
