package com.wangx.eshop.cache.listener;

import com.wangx.eshop.cache.kafka.KafkaConsumer;
import com.wangx.eshop.cache.utils.SpringApplicationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统初始化类
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/8 0008
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        SpringApplicationUtils.setApplicationContext(context);
        new Thread(new KafkaConsumer("eshop-message")).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
