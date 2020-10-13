import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;
import model.user;
import net.sf.json.JSONArray;
import tool.database;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;

public class Servlet extends HttpServlet {
    private static Statement stat;
    public static Connection con;
    database db=new database();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("开始交互");
        String name=request.getParameter("name");//获取ajax传过来的值
        String pw=request.getParameter("pw");
        PrintWriter out = response.getWriter();
        String sql= "select * from user where uid="+"'"+name+"'" +"and upw=" + "'"+pw+"'";
        try {
            ResultSet re=db.select(sql);
            if(re.next())
            {
                System.out.println("yes1");
                user user=new user(name,pw,"1");
                Gson gson=new Gson();
                String userjson=gson.toJson(user);
                out.print(userjson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
        System.out.println("交互结束");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");




       Cookie cookie[]=request.getCookies();
       for (Cookie cookie1:cookie)
       {
           System.out.println(cookie1.getValue());
       }




//        PrintWriter out = response.getWriter();
//        Gson gson=new Gson();
//        String data=gson.toJson(cookie1);
//        out.print(data);
    }
    public void creat(String uid,String upw,HttpServletRequest request, HttpServletResponse response)
    {
        Cookie cookie_uid=new Cookie("uid",uid);
        Cookie cookie_upw=new Cookie("upw",upw);
        cookie_uid.setMaxAge(60*60);
        cookie_upw.setMaxAge(60*60);
        response.addCookie(cookie_uid);
        response.addCookie(cookie_upw);
    }
}