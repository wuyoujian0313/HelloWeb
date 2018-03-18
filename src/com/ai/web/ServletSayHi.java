package com.ai.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletSayHi")
public class ServletSayHi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //从ServletContext对象中取出数据
        String param = (String) context.getAttribute("name");

        response.setContentType("json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Hi World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello " + param + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
