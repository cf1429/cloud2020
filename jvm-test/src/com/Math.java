package com;

/**
 * @Author:chenf
 * @Date:2021/7/16 14:47
 * @describe
 */
public class Math {

    private static int initData = 666;

    private static User user = new User();

    public int compate(){
        int a =1;
        int b =2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compate();
    }
}
