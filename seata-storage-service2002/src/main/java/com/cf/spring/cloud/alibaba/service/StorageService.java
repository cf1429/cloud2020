package com.cf.spring.cloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cf.spring.cloud.alibaba.domain.TStorage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cf
 * @since 2021-03-13
 */
public interface StorageService extends IService<TStorage> {
    public void decrease(Long productId,Integer count);

}
