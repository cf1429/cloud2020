package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cf
 * @create 2020\5\31 0031
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain80 {
    public static void main(String[] args){
        SpringApplication.run(ConsumerConsulMain80.class,args);

    }
}
