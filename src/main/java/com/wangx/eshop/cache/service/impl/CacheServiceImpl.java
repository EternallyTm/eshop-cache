package com.wangx.eshop.cache.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wangx.eshop.cache.model.ProductInfo;
import com.wangx.eshop.cache.model.ShopInfo;
import com.wangx.eshop.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

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

    @Autowired
    private JedisCluster jedisCluster;
    private final static String CACHE_NAME = "local";
    @Override
    @CachePut(key = "'product_info_'+#productInfo.getId()", value = CACHE_NAME)
    public ProductInfo saveProductInfo2LocalCache(ProductInfo productInfo) {
        return productInfo;
    }

    @Override
    public void saveProductInfo2RedisCache(ProductInfo productInfo) {

        String key = "product_info_" + productInfo.getId();
        jedisCluster.set(key, JSONObject.toJSONString(productInfo));
    }

    @Override
    @CachePut(key = "'shop_info_'+#shopInfo.getId()", value = CACHE_NAME)
    public ShopInfo saveShopInfo2LocalCache(ShopInfo shopInfo) {
        return shopInfo;
    }

    @Override
    public void saveShopInfo2RedisCache(ShopInfo shopInfo) {
        String key = "shop_info_" + shopInfo.getId();
        jedisCluster.set(key, JSONObject.toJSONString(shopInfo));
    }

    @Override
    @Cacheable(key = "'product_info_'+#id", value = CACHE_NAME)
    public ProductInfo getProductInfoFromLocalCache(Long id) {
        return null;
    }

    @Override
    @Cacheable(key = "'shop_info_'+#id", value = CACHE_NAME)
    public ShopInfo getShopInfoFromLocalCache(Long id) {
        return null;
    }
}
