package com.cf.dubbo.service;

import com.cf.dubbo.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressList(String userId);
}
