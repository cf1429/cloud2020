package com.atguigu.cloud.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataUnit;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("添加数据时，自动添加创建时间，和更新时间");
        this.strictInsertFill(metaObject,"createTime", Date.class, new Date());
        this.strictUpdateFill(metaObject,"updateTime", Date.class, new Date());
//        this.fillStrategy(metaObject,"createTime", new Date());
//        this.fillStrategy(metaObject,"updateTime",new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时自动填充更新时间字段值");
        this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());

    }
}
