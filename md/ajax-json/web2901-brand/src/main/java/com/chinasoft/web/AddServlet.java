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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author 中软zhang
 * @create 2023-08-10 9:50
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 前端发送的json串
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
        System.out.println(json);

        // 将json串转换为 javaBean
        Brand brand = JSON.parseObject(json, Brand.class);
        System.out.println(brand);

        // 调用servcie 添加品牌数据
        boolean flag = brandService.insertBrand(brand);

        // 发送json串到前端
        resp.setContentType("text/json;charset=utf-8");
        if (flag) {
            resp.getWriter().write("succ");
        } else {
            resp.getWriter().write("fail");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
