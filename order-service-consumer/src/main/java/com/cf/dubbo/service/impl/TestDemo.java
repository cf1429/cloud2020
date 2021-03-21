package com.cf.dubbo.service.impl;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        Test[] arr1 = {
                new Test(1,"david"), new Test(2,"alin"), new Test(3,"ming"),
                new Test(4,"lili"), new Test(5,"amy")
        };
        System.out.println(Arrays.asList(arr1).toString());
        Integer[] arr2 = {5, 1, 4, 3, 2};
        for(int i=0;i<arr2.length;i++){
            int a = arr2[i];
            for (int j =0;j<arr1.length;j++){
                if(arr1[j].getId()==a){
                    Test t = arr1[j];
                    Test t1 = arr1[i];
                    arr1[i] =t;
                    arr1[j] = t1;
                }
            }
        }
        System.out.println("=============");
        System.out.println(Arrays.asList(arr1).toString());
    }
}
