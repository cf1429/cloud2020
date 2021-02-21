package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entiy.UserOrder;
import com.atguigu.cloud.mapper.UserOrderMapper;
import com.atguigu.cloud.service.UserOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cf
 * @since 2021-02-21
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

}
