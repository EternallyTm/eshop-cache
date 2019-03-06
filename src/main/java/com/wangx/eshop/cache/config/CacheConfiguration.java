package com.wangx.eshop.cache.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * EhCache配置文件
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/6 0006
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */

@Configuration
@EnableCaching
public class CacheConfiguration {

    /**
     * 配置EhCache工厂bean
     * @return
     */
    @Bean
    @ConditionalOnClass(EhCacheManagerFactoryBean.class)
    public EhCacheManagerFactoryBean EhCacheManagerFactoryBean  () {
        EhCacheManagerFactoryBean  ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

    /**
     * 初始化EhCacheCacheManagerBean
     * @param ehCacheManagerFactoryBean
     * @return
     */

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean) {
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }
}
