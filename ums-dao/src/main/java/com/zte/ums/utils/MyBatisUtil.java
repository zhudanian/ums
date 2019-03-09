package com.zte.ums.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author:hellboy
 * Date:2018-10-29 15:02
 * Description:<描述>
 * mybatis工具类，该类用于获取和关闭数据库连接
 * 使用ThreadLocal,懒汉式单例设计模式，用于缓存
 * 使用static静态块初始化我的工厂对象
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory;

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();



    static {
        factory = new SqlSessionFactoryBuilder()
                .build(MyBatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));

    }

    //获取连接
    public static SqlSession getSession(){

        //从缓存中获取该连接
        SqlSession sqlSession = local.get();
        if(sqlSession==null){
             sqlSession = factory.openSession();
            //放入缓存
            local.set(sqlSession);
        }
        return  sqlSession;



    }

    //关闭连接
    public static  void closeSession(){
        SqlSession sqlSession = local.get();
        local.set(null);
        if(sqlSession!=null){
            sqlSession.close();
        }


    }



}







