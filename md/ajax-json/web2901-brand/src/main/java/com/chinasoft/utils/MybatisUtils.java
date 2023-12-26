package com.chinasoft.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author 中软zhang
 * @create 2023-08-04 16:01
 */
public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory;

    static {
        // 获取 sqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 sqlSessionFactory 实例化对象
     * @return，就是我们的对象
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return  sqlSessionFactory;
    }

    /**
     * 获取 sqlSession对象
     * @return : SqlSession 对象
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
