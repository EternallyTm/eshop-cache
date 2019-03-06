package com.wangx.eshop.cache.service;

import com.wangx.eshop.cache.model.ProductInfo;

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
   ProductInfo saveProductInfo(ProductInfo productInfo);

    /**
     * 根据ID从缓存中获取商品信息
     * @param id
     * @return
     */
   ProductInfo findById(Long id);
}
