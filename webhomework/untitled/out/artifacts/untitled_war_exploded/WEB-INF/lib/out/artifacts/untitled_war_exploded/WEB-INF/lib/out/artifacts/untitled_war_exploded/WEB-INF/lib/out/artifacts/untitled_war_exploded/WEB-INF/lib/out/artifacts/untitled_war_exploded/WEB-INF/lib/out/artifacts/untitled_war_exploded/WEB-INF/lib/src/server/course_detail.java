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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/couse_detail")
public class course_detail extends HttpServlet {
    private static Statement stat;
    private static Connection con;
    private static database db=new database();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String week=request.getParameter("countweek");
        String sql="SELECT * FROM `stu_course` where years=2020 and team=1 and startweek<="+"'"+week+"' and endweek >="+"'"+week+"'"+" ORDER BY weeknum";
        System.out.println(sql);
        try {
            ResultSet set=db.select(sql);
            JSONArray jsonArray=db.formatRsToJsonArray(set);
            Gson gson=new Gson();
            String data=gson.toJson(jsonArray);
            PrintWriter out = response.getWriter();
            out.print(data);
            System.out.println(data);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
