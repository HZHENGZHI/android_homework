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
import java.sql.*;

@WebServlet("/test")
public class test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        database dbpost=new database();
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        String cause=request.getParameter("apply_cause");
        String sql="update test set testtext="+"'"+cause+"'"+"where testid="+"'"+id+"'";
        try {
            dbpost.update(sql);
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
        String sql="select * from test";
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
}
