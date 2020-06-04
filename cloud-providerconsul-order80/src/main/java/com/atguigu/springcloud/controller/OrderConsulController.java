package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author cf
 * @create 2020\5\31 0031
 */
@RestController
@Slf4j
public class OrderConsulController {
    @Resource
    private RestTemplate restTemplate;

    public static final String  baseUrl = "http://cloud-provider-payment";
    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(baseUrl+"/payment/consul",String.class);
        return result;

    }


}
