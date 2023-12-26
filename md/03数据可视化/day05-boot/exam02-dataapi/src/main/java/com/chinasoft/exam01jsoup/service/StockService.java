package com.chinasoft.exam01jsoup.service;

import com.chinasoft.exam01jsoup.pojo.Query;
import com.chinasoft.exam01jsoup.pojo.Stock;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-12-08 8:50
 */
public interface StockService {
    List<Stock> dealStock(Query query);
}
