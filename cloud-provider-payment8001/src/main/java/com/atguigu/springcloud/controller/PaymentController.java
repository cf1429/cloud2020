package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果。。。。"+result);
        if(result >0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(404,"插入数据库失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult findPaymentById(@PathVariable(value = "id") long id){
        Payment payment = paymentService.findPaymentById(id);
        log.info("获取结果。。。。"+payment);
        int age = 0;
        if(payment != null ){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(404,"没有相应记录",null);
        }
    }
}
