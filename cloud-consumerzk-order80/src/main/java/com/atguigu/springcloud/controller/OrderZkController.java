package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author cf
 * @create 2020\5\24 0024
 */
@RestController
public class OrderZkController  {
    public static final String BASE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getZookeeperInfo(){
        String result = restTemplate.getForObject(BASE_URL+"/payment/zk",String.class);
        return result;

    }
}
