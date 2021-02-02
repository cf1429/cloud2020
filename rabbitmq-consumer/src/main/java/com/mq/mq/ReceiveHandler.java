package com.mq.mq;

import com.mq.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class ReceiveHandler {
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void receiveEmailMessage(String msg , Message message, Channel channel){
        System.out.println("receive message is："+msg);
        System.out.println(message.getBody().toString());

    }
}
