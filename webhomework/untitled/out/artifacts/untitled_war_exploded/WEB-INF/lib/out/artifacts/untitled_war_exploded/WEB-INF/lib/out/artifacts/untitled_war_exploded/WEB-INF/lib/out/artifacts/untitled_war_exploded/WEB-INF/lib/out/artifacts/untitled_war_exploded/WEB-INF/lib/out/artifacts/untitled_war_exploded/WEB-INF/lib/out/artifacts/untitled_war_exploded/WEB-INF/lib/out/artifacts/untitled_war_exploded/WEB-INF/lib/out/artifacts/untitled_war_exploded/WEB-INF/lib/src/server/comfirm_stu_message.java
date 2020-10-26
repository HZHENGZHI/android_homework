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

@WebServlet("/comfirm_stu_message")
public class comfirm_stu_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out=response.getWriter();
        database db=new database();
        String sql="select * FROM stu_message WHERE uid=182814471665";
        try {
            ResultSet resultSet=db.select(sql);
            Gson gson=new Gson();
            JSONArray jsonArray = db.formatRsToJsonArray(resultSet);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
