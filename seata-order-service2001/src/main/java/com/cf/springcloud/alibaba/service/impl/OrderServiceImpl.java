package com.cf.springcloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cf.springcloud.alibaba.mapper.OrderMapper;
import com.cf.springcloud.alibaba.domain.TOrder;
import com.cf.springcloud.alibaba.service.AccountService;
import com.cf.springcloud.alibaba.service.OrderService;
import com.cf.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  创建订单——》调用库存服务扣减库存-》调用账户服务扣减账户余额-》修改订单状态
 * </p>
 *
 * @author cf
 * @since 2021-03-09
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TOrder> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    public void create(TOrder order) {
        log.info("----->开始创建订单");
        orderMapper.insert(order);

        log.info("----->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        log.info("----->订单微服务开始调用账号，做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账号，做扣减end");

        // 修改订单状态，从零到1,1代表已完成
        order.setStatus(1);
        orderMapper.updateById(order);
        log.info("--->修改订单状态结束");

        log.info("----->下订单结束了，----00000");

    }
}
