package com.cf.dubbo.service.impl;

import java.util.Arrays;

public class TestArray {
    private static void methode1(Integer array[], int number){
        int count =0;
        for(int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length-1;j++){
                if(array[i]+array[j] == number){
                    count++;
                    System.out.println("第"+count+"种"+array[i]+" "+array[j]+"="+number);
                }
            }

        }

    }

    private static void methode2(Integer array[],int number){
        Arrays.sort(array);
        int begin=0;
        int end = array.length-1;
        int count=0;
        while (begin != end && begin>=0 && end>=0){
            if(array[begin]+array[end]<number){
                begin++;
            }else if(array[begin]+array[end]>number){
                end--;
            }else{
                count++;
                System.out.println("第"+count+"种"+array[begin]+" "+array[end]+"="+number);
                begin++;
            }
        }


    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        methode1(arr,9);
        System.out.println("============");
        methode2(arr,9);
    }
}
