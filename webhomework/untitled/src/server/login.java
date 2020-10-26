package server;

import com.google.gson.Gson;
import model.user;
import tool.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/login")
public class login extends HttpServlet {
    private static Statement stat;
    public static Connection con;
    database db=new database();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");//获取ajax传过来的值
        String pw=request.getParameter("pw");
        PrintWriter out = response.getWriter();
        String sql= "select uid,upw from stu_message where uid="+"'"+name+"'" +"and upw=" + "'"+pw+"'";
        try {
            ResultSet re=db.select(sql);
//            JSONArray jsonArray = db.formatRsToJsonArray(re);
//            Gson gson=new Gson();
//            String userjson=gson.toJson(jsonArray);
//            System.out.println(userjson);
//            out.print(userjson);
//            用于返回多组json数据
            if (re.next())
            {
                user user=new user(name,pw,"1");
                Gson gson=new Gson();
                String userjson=gson.toJson(user);
                out.print(userjson);
                Cookie cookie_name = new Cookie("username",name);
                Cookie cookie_pw =new Cookie("pw",pw);
                response.addCookie(cookie_name);
                response.addCookie(cookie_pw);
            }
            else
            {
                user user=new user(name,pw,"0");
                Gson gson=new Gson();
                String userjson=gson.toJson(user);
                out.print(userjson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库操作错误");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
        System.out.println();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        System.out.println("yes");
    }
}
