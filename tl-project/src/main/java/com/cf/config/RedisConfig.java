package com.cf.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:11
 * @describe
 */
@Configuration
public class RedisConfig {
    //
    @Value("${spring.redis.host}")
    private String address;

    @Value("${spring.redis.port}")
    private String port;


    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+address+":"+port)
                .setDatabase(1);
        return Redisson.create(config);
    }

}
