package com.kk.serve;

import com.google.gson.Gson;
import com.kk.dao.userMapper;
import com.kk.pojo.User;
import com.kk.utilis.mybatisutils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/resigin")
public class resigin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String userpw=request.getParameter("user_password");
        String real_name=request.getParameter("real_name");
        String birthday=request.getParameter("birthday");
        String sex=request.getParameter("sex");
        User user=new User(userid,userpw,real_name,birthday,sex);
        SqlSession sqlSession = mybatisutils.getsqlsession();
        userMapper mapper=sqlSession.getMapper(userMapper.class);

        User user1 = mapper.getusermsg(userid);

        PrintWriter out=response.getWriter();
        Gson gson=new Gson();

        System.out.println(user1);
        if(user1!=null)
        {
            String data=gson.toJson("1");
            out.print(data);
        }
        else
        {
            mapper.resiginuser(user);
            String data=gson.toJson("0");
            out.print(data);
        }
        System.out.println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
