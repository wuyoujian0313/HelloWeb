package com.ai.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletClientDataCache")
public class ServletClientDataCache extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setDateHeader("expires",System.currentTimeMillis() + 24 * 3600 * 1000);
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello Cache Data</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
