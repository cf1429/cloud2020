package com.cf.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cf.dubbo.bean.UserAddress;
import com.cf.dubbo.service.OrderService;
import com.cf.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id："+userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : userAddressList){
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }
}
