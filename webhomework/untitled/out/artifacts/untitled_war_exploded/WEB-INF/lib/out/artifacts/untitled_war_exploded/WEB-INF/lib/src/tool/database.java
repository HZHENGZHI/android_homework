package tool;

import java.sql.*;

import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class database {
    private static Statement stat;
    private static Connection con;
    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        String url="jdbc:mysql:"
                + "//127.0.0.1:3306/stu_manger?useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="123456";
        con = DriverManager.getConnection(url,user,password);
        System.out.println("CHENGG");
        stat = con.createStatement();
    }
    public static Statement getStat() throws ClassNotFoundException, SQLException{
        if(stat==null) init();
        return stat;
    }
    public static ResultSet select(String sql) throws SQLException, ClassNotFoundException {
        ResultSet re = getStat().executeQuery(sql);
        getStat().close();
        return re;
    }
    public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject();// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到w
            }
            array.add(mapOfColValues);
        }
        return array;
    }
}
