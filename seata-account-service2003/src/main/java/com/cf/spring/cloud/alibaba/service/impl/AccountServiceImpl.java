package com.cf.spring.cloud.alibaba.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.spring.cloud.alibaba.domain.TAccount;
import com.cf.spring.cloud.alibaba.mapper.AccountMapper;
import com.cf.spring.cloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("--------account-service中扣减账户余额开始");
        accountMapper.decrease(userId,money);
        log.info("--------account-service中扣减账户余额结束");
    }

    @Override
    public boolean saveBatch(Collection<TAccount> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TAccount> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TAccount> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TAccount entity) {
        return false;
    }

    @Override
    public TAccount getOne(Wrapper<TAccount> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TAccount> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<TAccount> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<TAccount> getBaseMapper() {
        return null;
    }

    @Override
    public Class<TAccount> getEntityClass() {
        return null;
    }
}
