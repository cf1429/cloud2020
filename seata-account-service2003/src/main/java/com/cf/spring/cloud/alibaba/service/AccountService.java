package com.cf.spring.cloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cf.spring.cloud.alibaba.domain.TAccount;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cf
 * @since 2021-03-13
 */
public interface AccountService extends IService<TAccount> {
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);

}
