package com.cf.springcloud.alibaba.entity;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * 自定义流控异常
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(4444,"按客户自定义，global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(4444,"按客户自定义，global handlerException---2");
    }
}
