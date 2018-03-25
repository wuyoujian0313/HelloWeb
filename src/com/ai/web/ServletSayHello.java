package com.ai.web;

import com.oracle.tools.packager.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@javax.servlet.annotation.WebServlet(name = "ServletSayHello",urlPatterns = "/sayhello",initParams = {
        @WebInitParam(name="name",value = "伍珂")
})
public class ServletSayHello extends javax.servlet.http.HttpServlet {

    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }



    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取所有的初始化参数
        Enumeration<String> e = config.getInitParameterNames();
        while(e.hasMoreElements()){
            String paramName = e.nextElement();
            String value = config.getInitParameter(paramName);
        }

        String name = config.getInitParameter("name");
        String param = request.getParameter("name");
        if (param == null || param.length() == 0) {
            param = name;
        }

        /**
         * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
         * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
         */
        //获得ServletContext对象
        ServletContext context = this.getServletConfig().getServletContext();
        //将param存储到ServletContext对象中
        context.setAttribute("name", param);

        //获取整个web站点的初始化参数
        String contextInitParam = context.getInitParameter("url");

        // 方法一：设置字符编码
        //response.setContentType("text/html;text/html;charset=UTF-8");

        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello " + param + "</h1>");
        out.println("<h1>AppParam:" + contextInitParam + "</h1>");
        out.println("</body>");
        out.println("</html>");
        // 方法二：设置字符编码
        //out.println("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");


        //转发请求
//        //获取请求转发对象(RequestDispatcher)
//        RequestDispatcher rd = context.getRequestDispatcher("/forward?name=fromSayHello");
//        //调用forward方法实现请求转发
//        rd.forward(request, response);

    }
}
