package tool;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.UUID;

public class database {
    private static Statement stat;
    private static Connection con;
    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        String url="jdbc:mysql:"
                + "//rm-bp113sao09r93e60yvo.mysql.rds.aliyuncs.com:3306/stu_manger";
        String user="hzz_user";
        String password="DUIdui421";
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
        return re;
    }

    public static void  delete(String sql) throws SQLException, ClassNotFoundException {
       getStat().executeUpdate(sql);
    }

    public static void insert(String sql) throws SQLException, ClassNotFoundException {
        getStat().executeUpdate(sql);
    }

    public static void  update(String sql) throws SQLException, ClassNotFoundException {
        getStat().executeUpdate(sql);
    }

    public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject();// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到
            }
            array.add(mapOfColValues);
        }
        return array;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        {
            //注意replaceAll前面的是正则表达式
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
//        String sql="select * from stu_score";
//        ResultSet set = select(sql);
//        while (set.next())
//        {
//            System.out.println(set.getString("teacher_name"));
//        }
//
//        String sql_delete="DELETE FROM user where uid=123";
//        delete(sql_delete);
////        String sql_inser="insert into user (uid,upw) values(33333,44444)";
////        insert(sql_inser);
//        String sql_updata="update user set upw =123 where uid=33333";
//        update(sql_updata);
    }

}
