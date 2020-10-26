package server;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import tool.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/check_question")
public class check_question extends HttpServlet {
    private database db=new database();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        database db=new database();
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String coursename=request.getParameter("coursename");
        String teacher=request.getParameter("teacher");
        String data=request.getParameter("data");
        String text=request.getParameter("coursetext");
        String stuid=request.getParameter("stuid");
        System.out.println(coursename+data+teacher+text+stuid);
        String uuid=creatuuid();
        String sql="insert into stu_question_grand (uuid,stu,coursename,courseteacher,applycause,applytime)" +
                "values('"+uuid+"','"+stuid+"','"+coursename+"','"+teacher+"','"+text+"','"+data+"')";
        System.out.println(sql);
        try {
            db.insert(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        database dbget=new database();
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sql="select * from stu_question_grand";
        String method=request.getParameter("method");
        System.out.println(method);
        PrintWriter out=response.getWriter();
        try {
            ResultSet resultSet = dbget.select(sql);
            JSONArray jsonArray=dbget.formatRsToJsonArray(resultSet);
            Gson gson=new Gson();
            String data=gson.toJson(jsonArray);
            out.print(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String creatuuid()
    {
        return UUID.randomUUID().toString();
    }
}
