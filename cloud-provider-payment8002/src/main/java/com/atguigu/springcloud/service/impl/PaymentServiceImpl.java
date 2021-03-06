package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.PaymentService;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findPaymentById(long id) {
        return paymentDao.findPaymentById(id);
    }
}
