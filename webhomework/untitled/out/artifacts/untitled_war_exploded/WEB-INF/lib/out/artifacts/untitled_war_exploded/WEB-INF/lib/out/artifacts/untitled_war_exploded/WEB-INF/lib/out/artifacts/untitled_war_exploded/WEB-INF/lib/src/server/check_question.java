package server;

import tool.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check_question")
public class check_question extends HttpServlet {
    private database db=new database();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String course_name=request.getParameter("course_name");//获取ajax传过来的值

        String apply_cause=request.getParameter("apply_cause");

        String apply_time=request.getParameter("apply_time");

        System.out.println(apply_time);
        System.out.println(course_name);
        System.out.println(apply_cause);
        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
