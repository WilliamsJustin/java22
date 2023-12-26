package com.chinasoft.mphello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chinasoft.mphello.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 中软zhang
 * @create 2023-01-17 15:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
