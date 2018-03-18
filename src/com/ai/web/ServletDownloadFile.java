package com.ai.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "ServletDownloadFile")
public class ServletDownloadFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        downloadFileByOutputStream(response);
    }

    /**
     * 下载文件，通过OutputStream流
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void downloadFileByOutputStream(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        //1.获取要下载的文件的绝对路径
        String realPath = this.getServletContext().getRealPath("/files/qrcode.png");
        //String realPath = this.getServletContext().getRealPath("/files/二维码.png");
        //2.获取要下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/")+1);
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        //response.setHeader("content-disposition", "attachment;filename="+ fileName);
        response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
        //4.获取要下载的文件输入流
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        //5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        //6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        //7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer,0,len);
        }
        in.close();
    }
}
