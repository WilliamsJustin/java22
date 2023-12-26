package com.itchinasoft.service;

import com.itchinasoft.bean.User;

import java.util.List;

public interface UserService {
    /*
        模糊查询
     */
    public abstract List<User> selectLike(String username);
}
