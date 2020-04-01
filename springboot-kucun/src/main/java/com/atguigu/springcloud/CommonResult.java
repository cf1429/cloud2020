package com.atguigu.springcloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    // 自定义的返回类型
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
