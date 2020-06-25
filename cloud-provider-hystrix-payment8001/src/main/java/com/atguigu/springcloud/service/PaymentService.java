package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author cf
 * @create 2020\6\21 0021
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_ok"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeOut(Integer id) {
        int num = 3;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut"+id+"\t"+"O(∩_∩)O哈哈~耗时"+num+"秒钟";

    }
}
