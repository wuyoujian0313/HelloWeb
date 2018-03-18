package com.ai.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "ServletReadConfigByClassLoader")
public class ServletReadConfigByClassLoader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        readClassesCfgFile(response);
    }

    private void readClassesCfgFile(HttpServletResponse response) throws IOException {
        //获取到装载当前类的类装载器
        ClassLoader loader = this.getClass().getClassLoader();
        //用类装载器读取src目录下的sys.properties配置文件,即clases目录的
        InputStream in = loader.getResourceAsStream("sys.properties");
        Properties prop = new Properties();
        prop.load(in);
        String systemName = prop.getProperty("systemName");

        response.setContentType("text/html;text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Read Config: systemName=" + systemName + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
