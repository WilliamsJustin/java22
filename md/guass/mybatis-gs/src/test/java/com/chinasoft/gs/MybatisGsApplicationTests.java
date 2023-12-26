package com.chinasoft.gs;

import com.chinasoft.gs.mapper.AccountMapper;
import com.chinasoft.gs.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisGsApplicationTests {

    @Autowired
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
        List<Account> list = accountMapper.getAll();
        for (Account account : list) {
            System.out.println(account);
        }

    }

}
