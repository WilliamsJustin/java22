package com.chinasoft.exam01jsoup.service;

import com.chinasoft.exam01jsoup.mapper.StockMapper;
import com.chinasoft.exam01jsoup.pojo.Stock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-12-07 14:33
 */
@Service
//@Log4j
public class CollectServiceImpl  implements CollectService{

    @Autowired
    ObjectMapper mapper;

    @Autowired
    StockMapper stockMapper;

    @Override
    public String getStockData(String stockCode, String start, String end) {
        String url = "http://quotes.money.163.com/service/chddata.html";
        try {
            // 得到和设置 connection 对象
            Connection conn = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);
            // 给url请求参数
            conn.data("code", stockCode)
                    // 数据的开始日期
//                    .data("start", "20120101")
                    .data("start", start)
                    // 数据的结束日期
                    .data("end", end);


            // 执行请求
            Connection.Response response = conn.execute();

            // 判断请求是否成功
            if (response.statusCode() == 200) {
                // 显示 contentType
                // 响应对象的输入流， 流就是 图片的字节
                String html = new String(response.bodyAsBytes(), "GBK");
                // 读 bis的内容 到 buff里面， 然后将buff内容写入 fos
//                System.out.println(html);
                return html;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getQqStockData(String stockCode, String start, String end) {
        String url = "https://web.ifzq.gtimg.cn/appstock/app/fqkline/get";
        try {
            // 得到和设置 connection 对象
            Connection conn = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);
            // 给url请求参数
            String str = stockCode + "," +
                    "day," +
                start + "," +
                end + ",500,qfq";
            conn.data("param", str);

            // 执行请求
            Connection.Response response = conn.execute();

            // 判断请求是否成功
            if (response.statusCode() == 200) {
                // 显示 contentType
                // 响应对象的输入流， 流就是 图片的字节
                String html = new String(response.bodyAsBytes(), "GBK");
                // 读 bis的内容 到 buff里面， 然后将buff内容写入 fos
//                System.out.println(html);
                return html;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<List<String>> html2List(String html) {
        int startIndex = html.indexOf("[[");
        int endIndex = html.indexOf(",\"qt");
        String qfqday = html.substring(startIndex, endIndex);

        List<List<String>> list = null;
        try {
            list = mapper.readValue(qfqday, new TypeReference<List<List<String>>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        for (List<String> ls : list) {
            System.out.println(ls);
        }
        return list;
    }

    @Override
    public List<Stock> string2List(List<List<String>> list, String code) {
        ArrayList<Stock> stocks = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            List<String> ls = list.get(i);
            System.out.println(ls);
            //日期,股票代码,名称,收盘价,最高价,最低价,开盘价,前收盘,涨跌额,涨跌幅,换手率,成交量,成交金额,总市值,流通市值,成交笔数
            Stock st = new Stock();
            st.setDate(ls.get(0));
            st.setClose(Float.parseFloat(ls.get(2)));
            st.setHigh(Float.parseFloat(ls.get(3)));
            st.setLow(Float.parseFloat(ls.get(4)));
            st.setOpen(Float.parseFloat(ls.get(1)));
            st.setVol((long)Float.parseFloat(ls.get(5)));
            st.setCode(code);
            stocks.add(st);
        }
        return stocks;
    }

    @Override
    public boolean list2Db(List<Stock> list) {
        for (Stock stock : list) {
            stockMapper.insert(stock);
        }
        return true;
    }
}
