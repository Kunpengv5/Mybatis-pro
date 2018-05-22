package com.imooc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 主要用于实现SqlSession的初始化及获取SqlSessionFactory
 * @author dukunpeng
 * @date 2018/5/17 17:20
 */
public class SqlSessionFactoryUtils {

    private static String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 创建一个初始化sqlSessionFactory的方法
     * @return
     */
    public static void initSqlSessionFactory(){
        try {
            InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSessionFactory工厂对象的方法
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * 关闭SqlSession的方法
     */
    public static void closeSession(){
        SqlSession session = threadLocal.get();
        if (session != null){
            session.close();
            threadLocal.set(null);
        }
    }
}
