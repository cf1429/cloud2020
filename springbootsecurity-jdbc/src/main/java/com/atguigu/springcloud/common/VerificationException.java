package com.atguigu.springcloud.common;

/**
 * @Author:chenf
 * @Date:2021/6/27 15:57
 * @describe
 */


import org.springframework.security.core.AuthenticationException;

/**
 * 定义异常类
 */
public class VerificationException extends AuthenticationException {
    public VerificationException(String msg, Throwable t) {
        super(msg, t);
    }

    public VerificationException(String msg) {
        super(msg);
    }

    public VerificationException() {
        super("验证错误，请重新输入");
    }
}
