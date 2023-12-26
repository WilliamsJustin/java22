package com.chinasoft.mapper;

import com.chinasoft.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author 中软zhang
 * @create 2023-08-04 14:51
 */
public interface UserMapper {

    /**
     * 判断用户名称和密码是否符合
     * @param user
     * @return： null， 找不到
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User selectByNameandPass(User user);


    @Select("select * from tb_user where username = #{username} ")
    User selectByName(String username);

    @Insert(" insert into tb_user values(null, #{username}, #{password})")
    int insert(User user);
}
