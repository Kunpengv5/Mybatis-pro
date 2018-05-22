package com.imooc.listener;

import com.imooc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 使用Weblistener将监听器注册到容器中
 * @author dukunpeng
 * @date 2018/5/17 17:43
 */
@WebListener
public class InitSqlSessionListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        初始化我们的sqlSessionFactory对象
        SqlSessionFactoryUtils.initSqlSessionFactory();
        System.out.println("容器启动中...");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("容器销毁中...");
        SqlSessionFactoryUtils.closeSession();
    }
}
