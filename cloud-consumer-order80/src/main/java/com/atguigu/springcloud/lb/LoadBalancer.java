package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author cf
 * @create 2020\6\7 0007
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> instanceList);

}
