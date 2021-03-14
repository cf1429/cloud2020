package com.cf.springcloud.alibaba.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cf.springcloud.alibaba.domain.TOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cf
 * @since 2021-03-09
 */
public interface OrderService extends IService<TOrder> {
    public void create(TOrder order);


}
