package com.chinasoft.exam01jsoup.mapper;

import com.chinasoft.exam01jsoup.pojo.Query;
import com.chinasoft.exam01jsoup.pojo.Stock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("select * from stock where code = #{code} " +
            " and date > #{start} and date < #{end} order by date ")
    List<Stock> selectByCond(Query query);

    @Select("select * from stock where id = #{id}")
    Stock selectById(Integer id);
}
