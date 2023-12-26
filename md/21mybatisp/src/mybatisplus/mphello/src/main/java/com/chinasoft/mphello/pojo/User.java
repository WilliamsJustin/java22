package com.chinasoft.mphello.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 中软zhang
 * @create 2023-01-17 15:54
 */

@Data
public class User implements Serializable {
    Long id;
    String username;
    Date birthday;
    Integer sex;
    String address;
}
