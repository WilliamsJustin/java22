package com.chinasoft.service;

import com.chinasoft.pojo.User;

/**
 * @author 中软zhang
 * @create 2023-08-08 13:48
 */
public interface UserService {

    boolean login(User user);
    int register(User user);
    User getOneUser(String name);
}
