package com.wangx.eshop.cache.controller;

import com.wangx.eshop.cache.model.ProductInfo;
import com.wangx.eshop.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/6 0006
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */

@RestController
@RequestMapping("/cacheTest")
public class CacheTestController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/saveProductInfo")
    public String saveProductInfo(ProductInfo productInfo){
        cacheService.saveProductInfo(productInfo);
        return "success";
    }

    @RequestMapping("/getProductInfo")
    public ProductInfo getProductInfo(Long id) {
        return cacheService.findById(id);
    }
}
