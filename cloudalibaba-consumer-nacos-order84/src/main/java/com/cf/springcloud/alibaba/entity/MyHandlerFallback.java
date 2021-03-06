package com.cf.springcloud.alibaba.entity;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 全局异常回调配置
 */
public class MyHandlerFallback {
    public static CommonResult handlerFallback(@PathVariable Long id ,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult(444,"兜底异常handlerFallback，Exception 内容"+e.getMessage(),payment);

    }
}
