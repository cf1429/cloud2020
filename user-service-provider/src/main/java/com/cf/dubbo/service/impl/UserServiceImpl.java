package com.cf.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cf.dubbo.bean.UserAddress;
import com.cf.dubbo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service  //暴露服务
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress = new UserAddress(1,"北京","1","李老师","010-1251","0");
        UserAddress userAddress2 = new UserAddress(1,"天津","1","李老师","010-1251","0");
        return Arrays.asList(userAddress,userAddress2);
    }
}
