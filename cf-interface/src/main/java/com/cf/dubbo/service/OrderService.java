package com.cf.dubbo.service;

import com.cf.dubbo.bean.UserAddress;

import java.util.List;

public interface OrderService {
    public List<UserAddress> initOrder(String userId);
}
