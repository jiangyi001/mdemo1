package com.newer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    //负责生产SqlSession,与数据库建立连接,并生产接口的实现对象
    private static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            //读取mybatis主配置文件
            Reader  reader = Resources.getResourceAsReader("mybatis-config.xml");
            //加载主配置文件，得到工厂对象
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
     *获取连接对象
     */
    public static SqlSession getSqlSession(){
       return  sqlSessionFactory.openSession();
    }
/*
 关闭连接
 */
    public static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
    }
}
