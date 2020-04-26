package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.entities.Wine;
import com.atguigu.springcloud.entities.res.WineRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface WineDao {
    // 添加酒水记录
    int create(Wine wine);
    // 修改酒水记录
    int updateWine(Wine wine);
    // 酒水记录列表查询
    List<WineRes> findWineList(Map<String,Object> map);
    int findWineListCount(Map<String,Object> map);
    // 删除酒水记录信息
    int deleteWine(Integer id);
    // 根据id查找酒水信息
    Wine findWineById(Integer id);
    // 根据名称查找酒水信息
    Wine findWineByWineName(String name);

}
