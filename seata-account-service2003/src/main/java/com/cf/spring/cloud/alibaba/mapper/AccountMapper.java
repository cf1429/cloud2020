package com.cf.spring.cloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.spring.cloud.alibaba.domain.TAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cf
 * @since 2021-03-13
 */
@Repository
public interface AccountMapper extends BaseMapper<TAccount> {
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
