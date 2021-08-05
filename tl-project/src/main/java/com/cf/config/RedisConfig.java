package com.cf.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:11
 * @describe
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://8.133.170.159:6379")
                .setDatabase(1);
        return Redisson.create(config);
    }

}
