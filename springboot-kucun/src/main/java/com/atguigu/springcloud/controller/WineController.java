package com.atguigu.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.Wine;
import com.atguigu.springcloud.entities.res.WineRes;
import com.atguigu.springcloud.service.WineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = {"/","/api/wine"})
public class WineController {
    @Autowired
    private WineService wineService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @PostMapping(value = "/findWineList")
    public CommonResult<PageResult> findWineList(@RequestParam(value = "pageSize",required = true) Integer pageSize,
                                                 @RequestParam(value = "pageIndex",required = true) Integer pageIndex,
                                                 @RequestParam(value = "name",required = false) String name,
                                                 @RequestParam(value = "expiredDateStart", required = false) String expiredDateStart,
                                                 @RequestParam(value = "expiredDateEnd",required = false) String expiredDateEnd ){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageSize",pageSize);
        map.put("pageIndex",pageIndex);
        if(!StrUtil.isBlank(expiredDateStart)){
            map.put("expiredDateStart",expiredDateStart);
        }
        if(!StrUtil.isBlank(expiredDateEnd)){
            map.put("expiredDateEnd", expiredDateEnd);
        }
        if(!StrUtil.isBlank(name)){
            map.put("name", name);

        }
        PageResult<List<WineRes>> wineList = wineService.findWineList(map);
        CommonResult<PageResult> commonResult = new CommonResult<>();
        commonResult.setData(wineList);
        return commonResult;
    }

    @PostMapping(value = "/addWine")
    public CommonResult<String> addWine(@RequestParam(value = "name",required = true) String name,
                                        @RequestParam(value = "number",required = true) Integer number,
                                        @RequestParam(value = "price",required = true) double price,
                                        @RequestParam(value = "costPrice",required = true) double costPrice,
                                        @RequestParam(value = "picture",required = false) String picture,
                                        @RequestParam(value = "purchaseDate",required = true) String purchaseDate,
                                        @RequestParam(value = "productionDate",required = true) String productionDate,
                                        @RequestParam(value = "validNum",required = true) Integer validNum) throws ParseException {
        Wine wine = new Wine();
        wine.setName(name);
        wine.setNumber(number);
        if(!StrUtil.isBlank(picture)){
            wine.setPicture(picture);
        }
        wine.setPrice(price);
        wine.setCostPrice(costPrice);
        wine.setPurchaseDate(sdf.parse(purchaseDate));
        wine.setProductionDate(sdf.parse(productionDate));
        wine.setValidNum(validNum);
        log.info("调用酒水添加接口输入参数"+wine.toString());
        CommonResult<String> commonResult1 = wineService.create(wine);
        return commonResult1;
    }

    @DeleteMapping(value = "/deleteWine/{id}")
    public CommonResult<String> deleteWine(@PathVariable(value = "id") Integer id){
        log.info("调用删除酒水信息接口-----输入参数：id="+id);
        CommonResult<String> commonResult = wineService.deleteWine(id);
        return commonResult;
    }

    @GetMapping(value = "/findWineById/{id}")
    public CommonResult<Wine> findWineById(@PathVariable(value = "id") Integer id){
        log.info("调用查找酒水信息接口-----输入参数：id="+id);
        CommonResult<Wine> wine = wineService.findWineById(id);
        return wine;
    }

    @PostMapping(value = "/updateWine")
    public CommonResult<String> updateWine(@RequestParam(value = "id",required = true) Integer id,
                                           @RequestParam(value = "name",required = true) String name,
                                           @RequestParam(value = "number",required = true) Integer number,
                                           @RequestParam(value = "price",required = true) double price,
                                           @RequestParam(value = "costPrice",required = true) double costPrice,
                                           @RequestParam(value = "picture",required = false) String picture,
                                           @RequestParam(value = "purchaseDate",required = true) String purchaseDate,
                                           @RequestParam(value = "productionDate",required = true) String productionDate,
                                           @RequestParam(value = "validNum",required = true) Integer validNum
                                           ) throws ParseException {

        Wine wine = new Wine();
        wine.setId(id);
        wine.setName(name);
        wine.setNumber(number);
        if(!StrUtil.isBlank(picture)){
            wine.setPicture(picture);
        }
        wine.setPrice(price);
        wine.setCostPrice(costPrice);
        wine.setPurchaseDate(sdf.parse(purchaseDate));
        wine.setProductionDate(sdf.parse(productionDate));
        wine.setValidNum(validNum);
        log.info("调用修改酒水信息接口--------输入参数：wine="+wine.toString());
        CommonResult<String> commonResult = wineService.updateWine(wine);
        return commonResult;
    }








}
