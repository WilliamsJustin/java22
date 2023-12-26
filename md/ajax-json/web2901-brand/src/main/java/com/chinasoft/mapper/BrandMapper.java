package com.chinasoft.mapper;

import com.chinasoft.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-07 13:42
 */
public interface BrandMapper {

    @Select("select * from tb_brand")
    List<Brand> selectAll();
    // 插入一条记录
    @Insert("insert into tb_brand values(null, #{brandName}, #{companyName}, " +
            "#{ordered}, #{description}, #{status})")
    int insert(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(Integer id);

    @Update("update  tb_brand set brand_name =  #{brandName}, " +
            " company_name = #{companyName}, " +
            " ordered = #{ordered}, " +
            " description = #{description}, " +
            " status = #{status} " +
            " where id = #{id}")
    int update(Brand brand);
}
