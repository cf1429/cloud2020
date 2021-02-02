package com.atguigu.springcloud.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static int number =1;
    private static Lock lock = new ReentrantLock();
    private static Condition condA = lock.newCondition();
    private static Condition condB = lock.newCondition();
    private static Condition condC = lock.newCondition();


    public static void printA(){
        lock.lock();
        try {
            if(number != 1){
                condA.await();
            }
            for(int i=0;i<5;i++){
                System.out.println("线程A"+"    "+i);
            }
            number=2;
            condB.signal();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();

        }

    }

    public static void printB(){
        lock.lock();
        try {
            if(number != 2){
                condB.await();
            }
            for(int i=0;i<4;i++){
                System.out.println("线程B"+"    "+i);
            }
            number = 3;
            condC.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();

        }

    }

    public static void printC(){
        lock.lock();
        try {
            if(number != 3){
                condC.await();
            }
            for(int i=0;i<15;i++){
                System.out.println("线程C"+"    "+i);
            }
            number = 1;
            condA.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    public static void main(String [] args){
        new Thread(()->{
            for (int i=0;i<10;i++){
                printA();
            }
        },"A").start();


        new Thread(()->{
            for(int i=0;i<10;i++){
                printB();
            }
        },"B").start();


        new Thread(()->{
            for(int i =0;i<10;i++){
                printC();
            }
        },"C").start();
    }


}
