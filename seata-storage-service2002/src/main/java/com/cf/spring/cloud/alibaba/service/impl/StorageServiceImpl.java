package com.cf.spring.cloud.alibaba.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.spring.cloud.alibaba.domain.TStorage;
import com.cf.spring.cloud.alibaba.mapper.StorageMapper;
import com.cf.spring.cloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("================storage-service 中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("===========storage-service 中扣减库存结束");

    }

    @Override
    public boolean saveBatch(Collection<TStorage> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TStorage> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TStorage> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TStorage entity) {
        return false;
    }

    @Override
    public TStorage getOne(Wrapper<TStorage> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TStorage> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<TStorage> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<TStorage> getBaseMapper() {
        return null;
    }

    @Override
    public Class<TStorage> getEntityClass() {
        return null;
    }
}
