package com.mq;

import com.mq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqTest {

    // 使用rabbitTamplate 发送消息
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void test1(){
        System.out.println("skjk");
    }

    @Test
    public void TestEmail(){
        String message = "send email message to user";

        /**
         * 参数：
         * 1.交换机
         * 2.routingKey
         * 3.消息内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHAGE_TOPICS_INFORM,"inform.email",message);

    }
}
