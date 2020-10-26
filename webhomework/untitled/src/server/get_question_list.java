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

@WebServlet("/get_question_list")
public class get_question_list extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        database db=new database();
        String uid=request.getParameter("id");
        String sql="select * from stu_grand where stuid="+ uid;
        try {
            ResultSet set=db.select(sql);
            JSONArray jsonArray=db.formatRsToJsonArray(set);
            Gson gson=new Gson();
            String data=gson.toJson(jsonArray);
            out.print(data);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
