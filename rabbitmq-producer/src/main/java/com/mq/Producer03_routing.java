package com.mq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 */
public class Producer03_routing {
    private static final String QUEUE_INFORM_EMAIL = "queue_email";
    private static final String QUEUE_INFORM_SMS = "queue_sms";
    private static final String EXCHAGE_FANOUT_INFORM = "exchage_info";
    private static final String INFORM_EMAIL_ROUTING = "email_info";
    private static final String INFORM_SMS_ROUTING = "sms_info";
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
            channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
            channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);
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
            channel.exchangeDeclare(EXCHAGE_FANOUT_INFORM,BuiltinExchangeType.DIRECT);
            // 交换机和队列绑定
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHAGE_FANOUT_INFORM,INFORM_EMAIL_ROUTING);
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHAGE_FANOUT_INFORM,"info");
            channel.queueBind(QUEUE_INFORM_SMS,EXCHAGE_FANOUT_INFORM,INFORM_SMS_ROUTING);
            channel.queueBind(QUEUE_INFORM_SMS,EXCHAGE_FANOUT_INFORM,"info");

           /* for(int i=0;i<5;i++){
                String message = "send email inform message to user";
                channel.basicPublish(EXCHAGE_FANOUT_INFORM,INFORM_EMAIL_ROUTING,null,message.getBytes()   );
                System.out.println("发送记录----"+message);
            }

            for(int i=0;i<5;i++){
                String message = "send sms inform message to user";
                channel.basicPublish(EXCHAGE_FANOUT_INFORM,INFORM_SMS_ROUTING,null,message.getBytes()   );
                System.out.println("发送记录----"+message);
            }*/

            for(int i=0;i<5;i++){
                String message = "send inform message to user";
                channel.basicPublish(EXCHAGE_FANOUT_INFORM,"info",null,message.getBytes()   );
                System.out.println("发送记录----"+message);
            }

//
//
//
//             String messge = "小米 你好，";
//             channel.basicPublish("",QUEUE,null,messge.getBytes());
//             System.out.println("发送记录----"+messge);

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
