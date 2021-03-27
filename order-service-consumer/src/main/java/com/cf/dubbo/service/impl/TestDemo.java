package com.cf.dubbo.service.impl;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        String str = "https://mobile.yangkeduo.com/goods2.html?goods_id=51631469611&page_from=0&pxq_secret_key=UIMFEZ7E3D65SM67VLVMZKAKYBSZXY23WRC7XCXTK4YMFVZ5MQPQ&share_uin=AKAWCCYF2YISJLKDZ4MPHHAM3I_GEXDA&refer_share_id=60671eea5e1c483fa12d3e9e49ac0e60&refer_share_uid=9704648630&refer_share_channel=copy_link&refer_share_form=text";
        String[] split = str.split("&");
        String str1 = split[0];
        System.out.println(str1);
        System.out.println("-----");
        String[] split1 = str1.split("=");
        System.out.println(split1[1]);



//        Test[] arr1 = {
//                new Test(1,"david"), new Test(2,"alin"), new Test(3,"ming"),
//                new Test(4,"lili"), new Test(5,"amy")
//        };
//        System.out.println(Arrays.asList(arr1).toString());
//        Integer[] arr2 = {5, 1, 4, 3, 2};
//        for(int i=0;i<arr2.length;i++){
//            int a = arr2[i];
//            for (int j =0;j<arr1.length;j++){
//                if(arr1[j].getId()==a){
//                    Test t = arr1[j];
//                    Test t1 = arr1[i];
//                    arr1[i] =t;
//                    arr1[j] = t1;
//                }
//            }
//        }
//        System.out.println("=============");
//        System.out.println(Arrays.asList(arr1).toString());
    }
}
