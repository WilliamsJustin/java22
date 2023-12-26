package com.chinasoft.web;

import com.alibaba.fastjson.JSON;
import com.chinasoft.pojo.Brand;
import com.chinasoft.service.BrandService;
import com.chinasoft.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-10 9:50
 */
@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取列表对象
        List<Brand> brandList = brandService.getAllBrand();

        // 将对象转换为 json 字符串
        String json = JSON.toJSONString(brandList);

        // 发送json串到前端
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
