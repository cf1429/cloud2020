package com.cf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cf.entity.Product;
import com.cf.mapper.ProductMapper;
import com.cf.service.ProductService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:27
 * @describe
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedissonClient redissonClient;
    @Override
    /**
     * 通过redisson解决缓存并发问题
     */
    public Product getProductInfo(String id) {
        //查询是先从redis查找商品信息，如果不为空，则直接返回
        // 通过redis缓存解决的磁盘io的问题，因为从数据库中获取数据的性能相对于从缓存中获取数据的性能低，
        // 所以通过缓存来解决磁盘io
        Product product = (Product) redisTemplate.opsForValue().get("product_key_" + id);
        if(product != null ){
            return product;
        }
        //通过redisson并发安全的控制
        RLock lock = redissonClient.getLock("product_redisson_key" + id);
        try{
            if(lock.tryLock(0,5, TimeUnit.SECONDS)){
                // 上锁则代表要从数据库中获取数据,并且将数据从存放到redis中
                product = this.baseMapper.selectById(id);
                redisTemplate.opsForValue().set("product_key_"+id,product,360, TimeUnit.MINUTES);
                // 否则不需要
            }else{
                //product = (Product) redisTemplate.opsForValue().get("product_key_" + id);
                // 给线程续命
                Thread.sleep(50);
                // 等待之后，回调此方法，为了等持有所得线程释放所之后，获取数据
                getProductInfo(id);
            }
        }catch (InterruptedException e){
            e.printStackTrace();

        } finally {
            if(lock.isLocked()){
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
        return product;
    }
}
