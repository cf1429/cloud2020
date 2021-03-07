//package com.cf.springcloud.alibaba.service;

//import com.atguigu.springcloud.entities.CommonResult;
//import com.atguigu.springcloud.entities.Payment;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * feign接口调用
// */
//@FeignClient(value = "nacos-payment-provider",fallback=PaymentFallbackService.class)
//public interface PaymentService {
//    @GetMapping(value = "/paymentSQL/{id}")
//    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id",required = true) Long id );
//
//}
