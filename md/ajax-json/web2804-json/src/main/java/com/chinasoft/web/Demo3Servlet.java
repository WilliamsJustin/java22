package com.chinasoft.web;

import com.alibaba.fastjson.JSON;
import com.chinasoft.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 中软zhang
 * @create 2023-08-09 16:20
 */
@WebServlet("/demo3")
public class Demo3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 不是json格式的post 请求

        //  读取 请求体里面的数据
        BufferedReader reader = req.getReader();

        //  得到 javaBean
        User user = new User("monkey猴子", "123");

        // 将javaBean转换为 json字符串
        String json = JSON.toJSONString(user);

        // 设置 contentType
        resp.setContentType("text/json;charset=utf-8");
        // 输出 json串
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
