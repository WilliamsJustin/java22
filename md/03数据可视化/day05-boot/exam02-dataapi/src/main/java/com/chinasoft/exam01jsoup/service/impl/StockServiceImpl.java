package com.chinasoft.exam01jsoup.service.impl;

import com.chinasoft.exam01jsoup.mapper.StockMapper;
import com.chinasoft.exam01jsoup.pojo.Query;
import com.chinasoft.exam01jsoup.pojo.Stock;
import com.chinasoft.exam01jsoup.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-12-08 8:53
 */
@Service
@Slf4j
public class StockServiceImpl  implements StockService {
    @Autowired
    StockMapper stockMapper;

    @Override
    public List<Stock> dealStock(Query query) {
        List<Stock> list = stockMapper.selectByCond(query);
        for (Stock stock : list) {
            stock.setDate(stock.getDate().substring(0, 10));
            log.debug("{}", stock);
        }
        return list;
    }
}
