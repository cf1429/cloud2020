package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author cf
 * @create 2020\6\27 0027
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardMain9001 {
    public static void main(String [] args){
        SpringApplication.run(ConsumerHystrixDashboardMain9001.class,args);

    }
}
