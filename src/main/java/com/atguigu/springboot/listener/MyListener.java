package com.atguigu.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener 启动！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener 销毁！");
    }
}
