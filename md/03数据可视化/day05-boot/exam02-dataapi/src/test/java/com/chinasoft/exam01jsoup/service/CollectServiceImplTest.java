package com.chinasoft.exam01jsoup.service;

import com.chinasoft.exam01jsoup.mapper.StockMapper;
import com.chinasoft.exam01jsoup.pojo.Query;
import com.chinasoft.exam01jsoup.pojo.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 中软zhang
 * @create 2022-12-07 14:39
 */
@SpringBootTest
class CollectServiceImplTest {

    @Autowired
    StockService stockService;

    @Autowired
    StockMapper stockMapper;

    @Test
    void testInsert()  {
        Stock s = stockMapper.selectById(864);
        System.out.println(s);

        s.setId(888);
        s.setCode("哈和");
        stockMapper.insert(s);

    }

    @Test
    void selectByCond() {
        Query query = new Query();
        query.setCode("600029");
        query.setStart("2022-12-07");
        query.setEnd("2023-12-08");
        List<Stock> stocks = stockService.dealStock(query);
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }


}