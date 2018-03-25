package com.ai.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "FilterUTF8")
public class FilterUTF8 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //对request和response进行一些预处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("FilterUTF8执行前！！！");
        chain.doFilter(req, resp);
        System.out.println("FilterUTF8执行后！！！");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("-----过滤器初始化-----");

        //得到过滤器的名字
        String filterName = config.getFilterName();
        //得到在web.xml文件中配置的初始化参数
        String initParam1 = config.getInitParameter("name");
        String initParam2 = config.getInitParameter("like");
        //返回过滤器的所有初始化参数的名字的枚举集合。
        Enumeration<String> initParameterNames = config.getInitParameterNames();

        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }
}
