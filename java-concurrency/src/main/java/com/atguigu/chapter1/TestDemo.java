package com.atguigu.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();




        //new TestMe();
//        String s0 = "5",s1="52",s2="5"+"2",s3="5"+2,s4=s0+2;
//        System.out.println(s1==s2);
//        System.out.println(s1==s3);
//        System.out.println(s1==s4);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,5, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(i+"线程");
                }
            }
        });
//        ExecutorService executorService = Executors.newCachedThreadPool();   //可变尺寸的线程池
//        ExecutorService executorService1 = Executors.newFixedThreadPool(12);   //固定大小的线程池
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);   //延迟线程池
//        ExecutorService executorService3 = Executors.newSingleThreadExecutor();    //单任务线程池

    }

}

