package com.chinasoft.service.impl;

import com.chinasoft.mapper.BrandMapper;
import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.Brand;
import com.chinasoft.pojo.User;
import com.chinasoft.service.BrandService;
import com.chinasoft.service.UserService;
import com.chinasoft.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-07 13:50
 */
public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = MybatisUtils.getSqlSessionFactory();

    @Override
    public boolean login(User user) {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询用户名称 密码是否符合
        User userDb = mapper.selectByNameandPass(user);
        if (userDb != null) {
            return true;
        } else  {
            return false;
        }
    }

    /**
     * 进行用户的注册
     * @param user
     * @return   1: 注册成功  2： 用户名称重复  3： 插入失败
     */
    @Override
    public int register(User user) {
        // 对数据库进行查询
        // 2.1 获取 sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.2 获取 mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 首先进行用户名称查询
        User user2 = mapper.selectByName(user.getUsername());

        if (user2 != null) {
            // 用户名称重复
            return 2;
        }

        int insert = mapper.insert(user);
        if (insert != 1) {
            // insert 失败
            return 3;
        }
        // 进行数据提交
        sqlSession.commit();

        // 用户注册成功
        return 1;
    }

    @Override
    public User getOneUser(String name) {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询用户名称查询记录
        User user = mapper.selectByName(name);

        return user;
    }

}
