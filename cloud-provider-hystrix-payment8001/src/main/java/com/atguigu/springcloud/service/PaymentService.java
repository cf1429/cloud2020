package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    @HystrixCommand(fallbackMethod = "paymentCircultBreaker_fallback",commandProperties = {
             @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启短路器
             @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 当请求达到这个数量之后，才进行错误占比的计算。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 半打开休眠时间，熔断之后过了这段休眠时间，就会半打开，尝试接口是否恢复，如果恢复就完全打开熔断器。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 错误占比，当错误次数超过这个百分比，就会熔断。


    })
    public String paymentCircultBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("*******id 不能负数");
        }
        String  num = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+num;
    }

    public String paymentCircultBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，id="+id;
    }
}
