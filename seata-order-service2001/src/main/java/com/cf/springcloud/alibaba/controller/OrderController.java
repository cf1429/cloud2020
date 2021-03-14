package com.cf.springcloud.alibaba.controller;


import com.cf.springcloud.alibaba.domain.CommonResult;
import com.cf.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import com.cf.springcloud.alibaba.domain.TOrder;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cf
 * @since 2021-03-09
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @GetMapping(value = "/order/create")
    public CommonResult create(TOrder order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");

    }
    @GetMapping("/test")
    public String testSnowflake(){
        return orderService.getIdBySnowFlake();
    }

}

