package com.chinasoft.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 中软zhang
 * @create 2023-08-09 10:26
 */
@WebServlet("/hello")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(200);
        System.out.println("ajax Servlet is calling");
        resp.getWriter().write("ajax request is reach !");
    }
}
