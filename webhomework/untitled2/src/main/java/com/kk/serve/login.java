package com.kk.serve;


import com.google.gson.Gson;
import com.kk.dao.userMapper;
import com.kk.pojo.User;
import com.kk.utilis.creat_jwt;
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

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("id");
        String userpw=request.getParameter("pw");
        User user = new User(userid,userpw,"","","");
        SqlSession sqlSession =mybatisutils.getsqlsession();
        userMapper mapper=sqlSession.getMapper(userMapper.class);
        List<User> users=mapper.checkuser(user);
        PrintWriter out=response.getWriter();
        Gson gson=new Gson();
        if(users.size()==1)
        {
            String jwt= creat_jwt.creatloginjwt("userid",userid,"userpw",userpw);
            String token=gson.toJson(jwt);
            out.println(token);
            System.out.println(jwt);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String jwt= creat_jwt.valitoken(token);
        PrintWriter out=response.getWriter();
        if(jwt.equals("ok"))
        {
            out.println(1);
        }
        else
        {
            out.println(0);
        }
    }
}
