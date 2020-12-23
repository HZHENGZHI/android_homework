package com.kk.serve;


import com.kk.dao.user_interface;
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

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("id");
        String userpw=request.getParameter("pw");
        User user = new User(userid,userpw);
        SqlSession sqlSession =mybatisutils.getsqlsession();
        user_interface mapper=sqlSession.getMapper(user_interface.class);
        List<User> users=mapper.checkuser(user);
        PrintWriter out=response.getWriter();
        out.println(users.size());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        SqlSession sqlSession= mybatisutils.getsqlsession();
//        PrintWriter out=response.getWriter();
//        user_interface mapeer=sqlSession.getMapper(user_interface.class);
//        List<User> kk = mapeer.checkuser();
//        System.out.println(kk);
//        Gson gson=new Gson();
//        String data=gson.toJson(kk);
//        System.out.println(data);
//        out.print(data);
    }
}
