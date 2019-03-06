package com.wangx.eshop.cache.model;

/**
 * 电商详情页商品实体类
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/6 0006
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class ProductInfo {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品价格
     */
    private Double price;

    public ProductInfo() {

    }
    public ProductInfo(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
