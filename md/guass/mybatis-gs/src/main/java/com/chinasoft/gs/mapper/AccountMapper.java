package com.chinasoft.gs.mapper;

import com.chinasoft.gs.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("select * from account")
    List<Account> getAll();
}
