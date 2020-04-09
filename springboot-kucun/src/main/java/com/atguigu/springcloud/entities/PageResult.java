package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private int pageSize;
    private int pageIndex;
    private int total;
    private T data;
}
