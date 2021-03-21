package com.cf.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cf.dubbo.bean.UserAddress;
import com.cf.dubbo.service.OrderService;
import com.cf.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService{
    @Reference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id："+userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : userAddressList){
            System.out.println(userAddress.getUserAddress());
        }
        return userAddressList;
    }


}

//class test{
//    public static void main(String[] args) {
////        String temp ="xyz";
////        String res = "";
////        for(int i=temp.length()-1;i>=0;i--){
////            res=temp.charAt(i)+res;
////        }
////        System.out.println(res);
////        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,4, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
//
////        List<String> list = new ArrayList<>();
////        list.add("aa");
////        list.add("bb");
////        System.out.println(list);
////        list.add("cc");
////        list.add(2,"666");
////        System.out.println(list);
////        list.add(list.size(),"99");
////        System.out.println(list);
////        list.iterator();
////        Iterator iter =  list.iterator();
////        while (iter.hasNext()){
////         Object o =    iter.next();
////         if(o.equals("99") || o.equals("666")){
////             list.remove(o);
////         }
//
//
//
//
//
//    }
//
//    private  static String fun(String s){
//        s  =s+"word";
//        return s;
//    }


//}
