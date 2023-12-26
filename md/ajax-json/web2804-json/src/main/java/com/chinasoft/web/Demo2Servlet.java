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
@WebServlet("/demo2")
public class Demo2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 不是json格式的post 请求
//        resp.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");

        // 解决跨域问题
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        //允许跨域的请求方法GET, POST, HEAD 等
//        resp.setHeader("Access-Control-Allow-Methods", "*");
//        //重新预检验跨域的缓存时间 (s)
//        resp.setHeader("Access-Control-Max-Age", "4200");
//        //允许跨域的请求头
//        resp.setHeader("Access-Control-Allow-Headers", "*");
//        //是否携带cookie
//        resp.setHeader("Access-Control-Allow-Credentials", "true");



        //  读取 请求体里面的数据
        BufferedReader reader = req.getReader();

        String json = reader.readLine();
        System.out.println(json);

        // 将json 字符串转换为 pojo 对象
        User user = JSON.parseObject(json, User.class);
        System.out.println(user);

        resp.getWriter().write("json str is rece ...");

//        String username = req.getParameter("username");
//        System.out.println(username);
//        String password = req.getParameter("password");
//        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
