package com.ai.web;

import com.ai.web.annotation.WebServletEx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServletEx("/webservletex")
public class TestWebServletExServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;text/html;charset=UTF-8");

        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>WebServletEx</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello WebServletEx</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
