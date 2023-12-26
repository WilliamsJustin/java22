package com.chinasoft.service;

import com.chinasoft.pojo.Brand;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-07 13:49
 */
public interface BrandService {

    List<Brand> getAllBrand();
    Brand getOneBrand(Integer id);
    boolean insertBrand(Brand brand);
    boolean updateBrand(Brand brand);
}
