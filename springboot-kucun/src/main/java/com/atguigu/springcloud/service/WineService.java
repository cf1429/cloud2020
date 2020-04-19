package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.Wine;

import java.util.List;
import java.util.Map;

public interface WineService {
    // 添加酒水记录
    CommonResult<String> create(Wine wine);
    // 修改酒水记录
    CommonResult<String> updateWine(Wine wine);
    // 酒水记录列表查询
    PageResult<List<Wine>> findWineList(Map<String,Object> map);
    // 删除酒水记录信息
    CommonResult<String> deleteWine(Integer id);
    // 根据id查找酒水信息
    CommonResult<Wine> findWineById(Integer id);
}
