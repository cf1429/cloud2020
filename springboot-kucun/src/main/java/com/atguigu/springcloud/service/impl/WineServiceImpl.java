package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.dao.WineDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.Wine;
import com.atguigu.springcloud.entities.res.WineRes;
import com.atguigu.springcloud.service.WineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Transactional
@Service
public class WineServiceImpl implements WineService {
    @Autowired
    private WineDao wineDao;

    @Override
    public CommonResult<String> create(Wine wine) {
        log.info("调用添加酒水接口-----");
        CommonResult<String> commonResult = new CommonResult<String>();
        if(wine == null || StrUtil.isBlank(wine.getName()) || wine.getPrice()<=0 || wine.getNumber() <=0 ){
           commonResult.setMessage("参数异常");
           return commonResult;
        }
        Wine findWine = wineDao.findWineByWineName(wine.getName());
        if(findWine != null){
            commonResult.setMessage("该酒水已存在，请更新信息");
            return commonResult;
        }else{
            // 根据生产日期和有效期设置过期时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(wine.getProductionDate());
            calendar.add(Calendar.DATE,wine.getValidNum());
            wine.setExpiredDate(calendar.getTime());
            wine.setCreateTime(new Date());
            wine.setUpdateTime(new Date());
            log.info("过期时间为----"+wine.getExpiredDateStr());
            int num = wineDao.create(wine);
            if(num >0 ){
                commonResult.setData(wine.getName()+"添加成功");
            }else{
                commonResult.setMessage(wine.getName()+"添加失败");
            }
        }
        return commonResult;
    }

    @Override
    public CommonResult<String> updateWine(Wine wine) {
        log.info("调用酒水信息修改接口");
        CommonResult<String> commonResult = new CommonResult<>();
        if(wine == null || wine.getNumber() <= 0 || wine.getPrice() <= 0 ){
            commonResult.setMessage("参数异常");
            return commonResult;
        }
        // 根据生产日期和有效期设置过期时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(wine.getProductionDate());
        calendar.add(Calendar.DATE,wine.getValidNum());
        wine.setExpiredDate(calendar.getTime());
        wine.setUpdateTime(new Date());
        int num = wineDao.updateWine(wine);
        if(num >0){
            commonResult.setData("修改成功");
        }else{
            commonResult.setMessage("修改失败");
        }
        return commonResult;
    }

    @Override
    public PageResult<List<WineRes>> findWineList(Map<String, Object> map) {
        log.info("调用酒水列表查询接口");
        PageResult<List<WineRes>> pageResult = new PageResult<>();
        List<WineRes> list = wineDao.findWineList(map);
        if(list == null && list.size()<0){
            pageResult.setData(list);
            pageResult.setTotal(0);
            return pageResult;
        }else{
            pageResult.setData(list);
            int num = wineDao.findWineListCount(map);
            pageResult.setTotal(num);
        }
        pageResult.setPageSize(Integer.valueOf(map.get("pageSize").toString()));
        pageResult.setPageIndex(Integer.valueOf(map.get("pageIndex").toString()));
        return pageResult;
    }

    @Override
    public CommonResult<String> deleteWine(Integer id) {
        log.info("调用删除酒水接口");
        Wine wine = wineDao.findWineById(id);
        CommonResult<String> commonResult = new CommonResult<String>();
        if(wine != null ){
            Wine wine1 = new Wine();
            wine1.setId(id);
            wine1.setState(1);
            wine1.setUpdateTime(new Date());
            int num = wineDao.updateWine(wine1);
            if(num > 0){
                commonResult.setData("删除成功");
            }else{
                commonResult.setMessage("删除失败");
            }
        }
        return commonResult;
    }

    @Override
    public CommonResult<Wine> findWineById(Integer id) {
        CommonResult<Wine> commonResult = new CommonResult<>();
        Wine wine = wineDao.findWineById(id);
        commonResult.setData(wine);
        return commonResult;
    }

}
