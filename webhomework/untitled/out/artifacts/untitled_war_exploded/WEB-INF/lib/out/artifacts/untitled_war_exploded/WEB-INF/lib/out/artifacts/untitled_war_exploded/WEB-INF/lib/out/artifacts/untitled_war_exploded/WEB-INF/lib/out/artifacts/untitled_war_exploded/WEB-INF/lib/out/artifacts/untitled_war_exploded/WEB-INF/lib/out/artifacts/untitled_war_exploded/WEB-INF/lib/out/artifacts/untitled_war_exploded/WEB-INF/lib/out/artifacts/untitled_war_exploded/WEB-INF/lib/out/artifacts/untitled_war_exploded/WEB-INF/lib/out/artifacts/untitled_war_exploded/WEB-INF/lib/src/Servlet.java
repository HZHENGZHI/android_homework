import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import tool.database;

import javax.servlet.ServletException;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("开始交互");
        String name=request.getParameter("name");//获取ajax传过来的值
        PrintWriter out = response.getWriter();

        name="收到1111";
        out.write(name);//相应
        System.out.println("name=="+name+"\n");
        out.flush();
        out.close();
        System.out.println("交互结束");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        database db=new database();
        try {
            ResultSet set=db.select("select * from person_information");
            JSONArray array=db.formatRsToJsonArray(set);
            PrintWriter out = res.getWriter();
            out.print(array);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
