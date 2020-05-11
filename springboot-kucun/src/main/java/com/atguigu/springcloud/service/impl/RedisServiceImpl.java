package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.RedisServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @author cf
 * @create 2020\4\28 0028
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisServie {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void set(String key, Object value) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        long seconds = (getMiol()-System.currentTimeMillis())/1000;
        log.info("登录key剩余过期时间----"+seconds);
        vo.set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String,Object> vo =  redisTemplate.opsForValue();
        return vo.get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public static Long getMiol(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        long timeM = calendar.getTimeInMillis();
        return timeM;
    }
}
