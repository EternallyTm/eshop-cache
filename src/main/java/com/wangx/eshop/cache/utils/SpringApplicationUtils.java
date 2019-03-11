package com.wangx.eshop.cache.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/8 0008
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class SpringApplicationUtils {

    private static ApplicationContext applicationContext;
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationUtils.applicationContext = applicationContext;
    }

    /**
     * 获取ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据字节码获取Bean
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }

    /**
     * 通过名字获取bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
