package com.cf.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.cf.springcloud.alibaba.entity.CustomerBlockHandler;
import com.cf.springcloud.alibaba.entity.MyHandlerFallback;
import com.cf.springcloud.alibaba.service.PaymentService;
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


    /**
     * blockHandlerClass sentinel控制台服务限流的自定义全局配置类 blockHandler 此方法限流降级调用的方法
     * fallbackClass 用户异常服务降级兜底自定义全局配置类  fallback 此方法异常兜底方法
     * exceptionsToIgnore 忽略fallback兜底，也不走sentinel 限流降级控制
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback",fallbackClass = {MyHandlerFallback.class}, fallback = "handlerFallback")  //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException") //blockHandler只负责sentinel控制台的配置违规
    @SentinelResource(value = "fallback",
            blockHandlerClass = {CustomerBlockHandler.class}, blockHandler = "handlerException",
            fallbackClass = {MyHandlerFallback.class},fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})   //在即配置sentinel限流和fallback兜底的情况下，如果发生错误，首先是sentinel限流起作用
    public CommonResult<Payment> fallback(@PathVariable Long id ){
        CommonResult<Payment> forObject = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常----");
        }else if(forObject.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return forObject;
    }


    //========= OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id",required = true) Long id){
        return paymentService.paymentSQL(id);
    }



}
