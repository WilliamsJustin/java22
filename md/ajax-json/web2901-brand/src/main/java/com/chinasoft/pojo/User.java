package com.chinasoft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 中软zhang
 * @create 2023-08-04 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String username;
    String password;
}
