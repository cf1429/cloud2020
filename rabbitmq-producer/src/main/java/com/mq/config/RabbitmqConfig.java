package com.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String QUEUE_INFORM_SMS = "queue_sms";
    public static final String EXCHAGE_TOPICS_INFORM = "exchage_topics_springboot";
    public static final String INFORM_SMS_ROUTING = "inform.#.sms.#";
    public static final String QUEUE_INFORM_EMAIL = "queue_email";
    public static final String INFORM_EMAIL_ROUTING = "inform.#.email.#";

    @Bean(EXCHAGE_TOPICS_INFORM)
    public Exchange EXCHAGE_TOPICS_INFORM(){
        return ExchangeBuilder.topicExchange(EXCHAGE_TOPICS_INFORM).durable(true).build();
    }

    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS(){
        return new Queue(QUEUE_INFORM_SMS);
    }

    @Bean(QUEUE_INFORM_EMAIL)
    public  Queue QUEUE_INFORM_EMAIL(){
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue, @Qualifier(EXCHAGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(INFORM_EMAIL_ROUTING).noargs();
    }

    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,@Qualifier(EXCHAGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(INFORM_SMS_ROUTING).noargs();
    }

}
