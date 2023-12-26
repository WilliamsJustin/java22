package com.chinasoft.exam01jsoup.mapper;

import com.chinasoft.exam01jsoup.pojo.Stock;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 中软zhang
 * @create 2022-12-07 15:33
 */
@Mapper
public interface StockMapper {

    @Insert("insert into stock(date, open, close, high, low, vol, code) values( " +
            "  #{date},  " +
            " #{open}, #{close}, #{high}, #{low}, " +
            " #{vol}, #{code} )")
    Integer insert(Stock st);

    @Delete("delete from stock")
    Integer clear();
}
