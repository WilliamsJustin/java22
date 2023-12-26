package com.chinasoft.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域问题， 一个解决中文乱码问题
 * @author 中软zhang
 * @create 2023-08-10 8:55
 */
@WebFilter("/*")
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 处理 request
        request.setCharacterEncoding("utf-8");
        // 执行 servlet 原有逻辑
        chain.doFilter(request, response);
        // 处理response
        HttpServletResponse resp = (HttpServletResponse) response;
        // 解决跨域问题
        resp.setHeader("Access-Control-Allow-Origin", "*");
        //允许跨域的请求方法GET, POST, HEAD 等
        resp.setHeader("Access-Control-Allow-Methods", "*");
        //重新预检验跨域的缓存时间 (s)
        resp.setHeader("Access-Control-Max-Age", "4200");
        //允许跨域的请求头
        resp.setHeader("Access-Control-Allow-Headers", "*");
        //是否携带cookie
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void destroy() {

    }
}
