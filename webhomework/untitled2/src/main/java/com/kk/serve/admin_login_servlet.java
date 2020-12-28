package com.kk.serve;

import com.google.gson.Gson;
import com.kk.dao.adminMapper;
import com.kk.pojo.admin_user;
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

@WebServlet("/admin_login_servlet")
public class admin_login_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String pw=request.getParameter("pw");
        SqlSession getsqlsession = mybatisutils.getsqlsession();
        adminMapper mapper=getsqlsession.getMapper(adminMapper.class);
        admin_user user=new admin_user(id,pw);
        List<admin_user> users=mapper.selectadmin(user);
        Gson gson=new Gson();
        PrintWriter out= response.getWriter();
        if(users.size()>=1)
        {
            String jwt= creat_jwt.creatloginjwt("userid",id,"userpw",pw);
            String token=gson.toJson(jwt);
            out.println(token);
            System.out.println(jwt);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String jwt= creat_jwt.valitoken(token);
        System.out.println(jwt+"kkk");
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
