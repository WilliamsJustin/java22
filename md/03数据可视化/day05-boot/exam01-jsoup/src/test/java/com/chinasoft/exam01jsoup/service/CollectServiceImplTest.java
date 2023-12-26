package com.chinasoft.exam01jsoup.service;

import com.chinasoft.exam01jsoup.mapper.StockMapper;
import com.chinasoft.exam01jsoup.pojo.InputMain;
import com.chinasoft.exam01jsoup.pojo.InputStock;
import com.chinasoft.exam01jsoup.pojo.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 中软zhang
 * @create 2022-12-07 14:39
 */
@SpringBootTest
class CollectServiceImplTest {

    @Autowired
    StockMapper stockMapper;

    @Autowired
    CollectService cs;

    @Test
    void getStockData() {
//        cs.getStockData("0600029", "");
        String html = cs.getStockData("0600029", "20120101", "20221206");
        System.out.println(html);
//        List<Stock> stockList = cs.string2List(html);
        System.out.println("----------------------------------------------");
//        for (Stock stock : stockList) {
//            System.out.println(stock);
//        }
//        cs.list2Db(stockList);
    }

    @Test
    void getQqData()  {
        String html = cs.getQqStockData("sh600029", "2022-1-1", "2023-10-1");
        List<List<String>> list = cs.html2List(html);
        List<Stock> stocks = cs.string2List(list, "600029");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
        cs.list2Db(stocks);
    }

    @Test
    void test() {
        stockMapper.clear();
    }
}