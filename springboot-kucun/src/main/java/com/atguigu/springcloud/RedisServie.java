package com.atguigu.springcloud;

/**
 * @author cf
 * @create 2020\4\28 0028
 */
public interface RedisServie {
    public void set(String key, Object value);

    public Object get(String key);

    public Boolean delete(String key);
}
