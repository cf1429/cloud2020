package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果。。。。"+result);
        if(result >0){
            return new CommonResult(200,"插入数据库成功serverPort="+serverPort,result);
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
            return new CommonResult(200,"查询成功serverPort="+serverPort,payment);
        }else{
            return new CommonResult(404,"没有相应记录",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance : instances){
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getInstanceId()+"\t"+serviceInstance.getPort());

        }
        return this.discoveryClient;


    }
}
