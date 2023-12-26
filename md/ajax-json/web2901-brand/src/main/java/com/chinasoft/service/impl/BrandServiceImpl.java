package com.chinasoft.service.impl;

import com.chinasoft.mapper.BrandMapper;
import com.chinasoft.pojo.Brand;
import com.chinasoft.service.BrandService;
import com.chinasoft.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-07 13:50
 */
public class BrandServiceImpl implements BrandService {

    SqlSessionFactory factory = MybatisUtils.getSqlSessionFactory();

    @Override
    public List<Brand> getAllBrand() {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 执行 selectAll sql语句
        List<Brand> brandList = mapper.selectAll();
        return brandList;
    }

    @Override
    public Brand getOneBrand(Integer id) {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 执行 selectAll sql语句
        Brand brand = mapper.selectById(id);
        return brand;
    }

    @Override
    public boolean insertBrand(Brand brand) {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 执行 insert
        int ret = mapper.insert(brand);
        // 进行提交操作
        sqlSession.commit();
        //  判断插入是否成功
        if (ret != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean updateBrand(Brand brand) {
        // 获取 sqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 执行 insert
        int ret = mapper.update(brand);
        // 进行提交操作
        sqlSession.commit();
        //  判断插入是否成功
        if (ret != 1) {
            return false;
        } else {
            return true;
        }
    }
}
