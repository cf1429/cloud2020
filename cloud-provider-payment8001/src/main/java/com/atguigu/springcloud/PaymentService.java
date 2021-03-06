package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);

    public Payment findPaymentById(@Param("id") long id);
}
