package com.cf.dubbo.controller;

import com.cf.dubbo.bean.UserAddress;
import com.cf.dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId){
       return orderService.initOrder(userId);

    }
}
