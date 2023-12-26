package com.itchinasoft.mapper;

import com.itchinasoft.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
     */
    @Select("SELECT * FROM user WHERE name LIKE CONCAT('%',#{username},'%') ORDER BY search_count DESC LIMIT 0,4")
    public abstract List<User> selectLike(String username);
}
