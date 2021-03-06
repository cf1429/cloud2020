package com.cf.springcloud.alibaba.entity;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 自定义流控降级异常
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(@PathVariable Long id, BlockException throwable){
        return new CommonResult(4444,"按客户自定义，global handlerException---1"+id+"异常信息："+throwable);
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(4444,"按客户自定义，global handlerException---2");
    }
}
