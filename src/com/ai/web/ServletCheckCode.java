package com.ai.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ServletCheckCode")
public class ServletCheckCode extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 先设置编码！！！！
        request.setCharacterEncoding("UTF-8");

        Enumeration<String> enumeration = request.getParameterNames();
        String paramName = enumeration.nextElement();

        //接收客户端浏览器提交上来的验证码
        String clientCheckcode = request.getParameter(paramName);
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码

        String msg = "";
        if (clientCheckcode.equals(serverCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            System.out.println("验证码验证通过！");
            msg = "验证码验证通过！";

        }else {
            System.out.println("验证码验证失败！");
            msg = "验证码验证失败！";
        }

        response.setContentType("text/html;text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello " + msg + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
