package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cf
 * @create 2020\6\4 0004
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myIRule(){
        return new RandomRule();  //自定义为随机
    }
}
