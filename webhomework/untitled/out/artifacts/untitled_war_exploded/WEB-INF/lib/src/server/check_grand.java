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


@WebServlet("/check_grand")
public class check_grand extends HttpServlet {
    private database db=new database();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String years=request.getParameter("years");//获取ajax传过来的值
        String team=request.getParameter("team");
        PrintWriter out = response.getWriter();
        String uid="";
        String sql= "select * from stu_grand where years="+"'"+years+"'"+"and team="+"'"+team+"'";
        try {
            ResultSet resultSet = db.select(sql);
            JSONArray jsonArray = db.formatRsToJsonArray(resultSet);
            Gson gson=new Gson();
            String scorejson=gson.toJson(jsonArray);
            out.print(scorejson);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
