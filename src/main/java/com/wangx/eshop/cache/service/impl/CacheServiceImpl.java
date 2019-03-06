package com.wangx.eshop.cache.service.impl;

import com.wangx.eshop.cache.model.ProductInfo;
import com.wangx.eshop.cache.service.CacheService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * CacheService实现类
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/6 0006
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    private final static String CACHE_NAME = "local";
    @Override
    @CachePut(key = "'key_'+#productInfo.getId()", value = CACHE_NAME)
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        return productInfo;
    }

    @Override
    @Cacheable(key = "'key_'+#id", value = CACHE_NAME)
    public ProductInfo findById(Long id) {
        return null;
    }
}
