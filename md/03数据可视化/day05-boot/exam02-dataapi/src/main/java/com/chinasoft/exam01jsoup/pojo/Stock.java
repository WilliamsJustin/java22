package com.chinasoft.exam01jsoup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 中软zhang
 * @create 2022-12-07 15:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    Integer id;
    String code;
    String date;
    String name;
    Float open;
    Float close;
    Float high;
    Float low;
    Long vol;
    Float money;
}
