package com.chinasoft.mphello.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinasoft.mphello.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 中软zhang
 * @create 2023-01-28 14:33
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void  testSelect1() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lt("id", 18);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    @Test
    void  testSelect2() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().ge(User::getId, 18);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    @Test
    void  testSelect3() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(User::getUsername, "小明");
        List<User> users = userMapper.selectList(lqw);
        users.forEach(System.out::println);
//        System.out.println(users);
    }

}