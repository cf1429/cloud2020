package com.cf.spring.cloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.spring.cloud.alibaba.domain.TStorage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cf
 * @since 2021-03-13
 */
@Repository
public interface StorageMapper extends BaseMapper<TStorage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
