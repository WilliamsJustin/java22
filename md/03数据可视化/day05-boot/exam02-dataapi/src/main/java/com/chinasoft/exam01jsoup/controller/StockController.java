package com.chinasoft.exam01jsoup.controller;

import com.chinasoft.exam01jsoup.pojo.Query;
import com.chinasoft.exam01jsoup.pojo.Stock;
import com.chinasoft.exam01jsoup.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-12-08 8:34
 */
@RestController
@Slf4j
@CrossOrigin  // 解决跨域问题
public class StockController {

    @Autowired
    StockService stockService;

    /**
     * method: get
     * url: /stock
     * args:
     *     code=600011
     *     start=20120101
     *     end=20121207, 如果不给就是最新
     */
    @GetMapping("/stock")
    // 可以使用 javaBean 接受参数， GET， POST
    public List<Stock> getStockData(Query query) {
        log.debug("query is {}", query);
        dealQuery(query);
        List<Stock> list = stockService.dealStock(query);
        return list;
    }

    /**
     * 处理输入参数
     * @param query
     */
    private void dealQuery(Query query) {
        // 处理 结束日期
        if (query.getEnd() == null) {
            query.setEnd("20221208");
            // ...
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello message !";
    }

    @PostMapping("/post")
    public Query postMethod( Query query, String code, String start) {
//        return "in post method";
        System.out.println(code);
        query.setEnd("set at javaBack");
        return query;
    }
}
