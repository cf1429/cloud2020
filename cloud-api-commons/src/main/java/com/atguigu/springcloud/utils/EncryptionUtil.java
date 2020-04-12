package com.atguigu.springcloud.utils;

import java.security.MessageDigest;

public class EncryptionUtil {
    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String getMd5(String plainPassword) {
        char hexDigits[] = { '5', '0', '5', '6', '2', '9', '6', '2', '5', 'q', 'b', 'l', 'e', 's', 's', 'y' };
        try {
            char str[];
            // 将传入的字符串转换成byte数组
            byte strTemp[] = plainPassword.getBytes();
            // 获取MD5加密对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            // 传入需要加密的目标数组
            mdTemp.update(strTemp);
            // 获取加密后的数组
            byte md[] = mdTemp.digest();
            int j = md.length;
            str = new char[j * 2];
            int k = 0;
            // 将数组做位移
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            // 转换成String并返回
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args){
        System.out.println(getMd5("admin"));
        System.out.println(getMd5("1429043932@qq.com"));

    }


}
