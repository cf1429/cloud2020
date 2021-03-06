package com.cf.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.cf.springcloud.alibaba.entity.CustomerBlockHandler;
import com.cf.springcloud.alibaba.entity.MyHandlerFallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallbackClass = {MyHandlerFallback.class}, fallback = "handlerFallback")  //fallback只负责业务异常

    public CommonResult<Payment> fallback(@PathVariable Long id ){
        CommonResult<Payment> forObject = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常----");
        }else if(forObject.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return forObject;
    }




}
