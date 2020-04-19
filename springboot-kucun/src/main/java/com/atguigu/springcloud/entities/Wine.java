package com.atguigu.springcloud.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 酒水实体类
 */
public class Wine implements Serializable {
    private Integer id;
    private String name;          // 名称
    private Integer number;       // 数量
    private double price;         // 售价
    private double costPrice;     // 进价
    private String picture;       // 图片
    private Date purchaseDate;    //进货日期
    private Date productionDate;  // 生产日期
    private Integer validNum;     // 有效期，多少天
    private Date expiredDate;     // 过期时间
    private Integer userId;       // 账户
    private Date createTime;      // 创建时间
    private int state;            // 状态
    private Date updateTime;      // 更新时间

    // 返回带格式的日期，供前台页面使用
    private String purchaseDateStr;
    private String productionDateStr;
    private String expiredDateStr;
    private String updateTimeStr;
    private String createTimeStr;
    private double priceTotal;      // 毛利润
    private double costPriceTotal;  // 成本
    private double netProfit;


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getValidNum() {
        return validNum;
    }

    public void setValidNum(Integer validNum) {
        this.validNum = validNum;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPurchaseDateStr() {
        if (purchaseDate != null) {
            this.purchaseDateStr = sdf.format(purchaseDate);
        }
        return purchaseDateStr;
    }

    public void setPurchaseDateStr(String purchaseDateStr) {
        this.purchaseDateStr = purchaseDateStr;
    }

    public String getProductionDateStr() {
        if(productionDate != null){
            this.productionDateStr = sdf.format(productionDate);
        }
        return productionDateStr;
    }

    public void setProductionDateStr(String productionDateStr) {
        this.productionDateStr = productionDateStr;
    }

    public String getExpiredDateStr() {
        if(expiredDate != null ){
            this.expiredDateStr = sdf.format(expiredDate);
        }
        return expiredDateStr;
    }

    public void setExpiredDateStr(String expiredDateStr) {
        this.expiredDateStr = expiredDateStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTimeStr() {
        if(updateTime != null){
            this.updateTimeStr = sdf.format(updateTime);
        }
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getCreateTimeStr() {
        if(createTime != null ){
            this.createTimeStr = sdf.format(createTime);
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public double getCostPriceTotal() {
        return costPriceTotal;
    }

    public void setCostPriceTotal(double costPriceTotal) {
        this.costPriceTotal = costPriceTotal;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", costPrice=" + costPrice +
                ", picture='" + picture + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", productionDate=" + productionDate +
                ", validNum=" + validNum +
                ", expiredDate=" + expiredDate +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", state=" + state +
                ", updateTime=" + updateTime +
                ", purchaseDateStr='" + purchaseDateStr + '\'' +
                ", productionDateStr='" + productionDateStr + '\'' +
                ", expiredDateStr='" + expiredDateStr + '\'' +
                ", updateTimeStr='" + updateTimeStr + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", priceTotal=" + priceTotal +
                ", costPriceTotal=" + costPriceTotal +
                ", netProfit=" + netProfit +
                '}';
    }
}


