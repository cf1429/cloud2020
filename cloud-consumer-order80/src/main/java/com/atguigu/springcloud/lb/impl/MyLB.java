package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cf
 * @create 2020\6\7 0007
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
           current = this.atomicInteger.get();
           next = current >= 2147483647 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第"+current+"方位======"+next);
        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> instanceList) {
        int index = getAndIncrement() % instanceList.size();

        return instanceList.get(index);
    }
}
