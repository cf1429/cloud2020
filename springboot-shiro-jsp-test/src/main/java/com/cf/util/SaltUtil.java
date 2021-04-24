package com.cf.util;

import java.util.Random;

/**
 * @Author:chenf
 * @Date:2021/4/24 23:33
 * @describe
 */
public class SaltUtil {
    /**
     * 生成随机盐
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char acher = chars[new Random().nextInt(chars.length)];
            sb.append(acher);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(4);
        System.out.println(salt);
    }

}
