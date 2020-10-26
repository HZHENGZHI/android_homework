package server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/upload")
public class upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        InputStream inputStream =request.getInputStream();
        byte[] bys=new byte[1000];
        int len=inputStream.read(bys);
        String path=request.getRealPath("/upload");
        File file=new File(path,"a.js");
        OutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(bys,0,len);
        inputStream.close();
        bufferedOutputStream.close();
        outputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
        PrintWriter out=response.getWriter();
        out.print("123");
    }
}
