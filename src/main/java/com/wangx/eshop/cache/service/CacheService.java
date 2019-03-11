package com.wangx.eshop.cache.service;

import com.wangx.eshop.cache.model.ProductInfo;
import com.wangx.eshop.cache.model.ShopInfo;

/**
 *
 * 本地缓存Service服务
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/6 0006
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */
public interface CacheService {

    /**
     * 将商品信息保存到缓存中
     * @param productInfo
     * @return
     */
   ProductInfo saveProductInfo2LocalCache(ProductInfo productInfo);

    /**
     * 将商品信息保存到redis中
     * @param productInfo
     */
   void saveProductInfo2RedisCache(ProductInfo productInfo);

    /**
     * 将店铺信息保存到本地ehcache缓存中
     * @param shopInfo
     * @return
     */
    ShopInfo saveShopInfo2LocalCache(ShopInfo shopInfo);
    /**
     * 将店铺信息保存到本地ehcache缓存中
     * @param shopInfo
     * @return
     */
    void saveShopInfo2RedisCache(ShopInfo shopInfo);

    /**
     * 根据ID从缓存中获取商品信息
     * @param id
     * @return
     */
    ProductInfo getProductInfoFromLocalCache(Long id);

    /**
     * 根据店铺id从本地缓存中拿到店铺信息
     * @param id
     * @return
     */
    ShopInfo getShopInfoFromLocalCache(Long id);
}
