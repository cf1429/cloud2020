package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cf
 * @create 2020\5\30 0030
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderConsluMain8005 {
    public static void main(String[] args){
        SpringApplication.run(ProviderConsluMain8005.class,args);

    }
}
