package com.chinasoft.mphello;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chinasoft.mphello.mapper.UserMapper;
import com.chinasoft.mphello.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MphelloApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectPage() {
        Page<User> page = new Page<>(2, 3);

        userMapper.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        for (User u : page.getRecords()) {
            System.out.println(u);
        }
        System.out.println(page.getRecords().size());

    }

}
