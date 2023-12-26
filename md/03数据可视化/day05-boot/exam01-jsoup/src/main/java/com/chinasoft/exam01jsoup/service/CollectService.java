package com.chinasoft.exam01jsoup.service;

import com.chinasoft.exam01jsoup.pojo.Stock;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-12-07 14:31
 */
public interface CollectService {

    // 得到 字符串的数据
    String getStockData(String stockCode, String start, String end);

    String getQqStockData(String stockCode, String start, String end);

    List<List<String>> html2List(String html);
    // 将字符串转换为 JavaBean list 对象
    List<Stock> string2List(List<List<String>> list, String code);
    // 将 list 对象 插入数据库
    boolean list2Db(List<Stock> list);

}
