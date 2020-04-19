package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResult<T> {
    private String code;   // 成功返回0000  失败0001
    private String message;
    private T data;
    private Boolean flag;   // 成功返回true 失败返回false

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.code = "0001";
        this.flag = false;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.flag = true;
        this.code = "0000";
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
