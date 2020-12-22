package com.serve;

import com.dao.user_interface;
import com.pojo.user;
import com.utilis.*;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession=mybatis_utils.getsqlsession();
//      方式1：getMapper，这一步相当于在实体实现类中调用方法进行sql查询
        user_interface mapeer=sqlSession.getMapper(user_interface.class);//getMapper的参数为接口类.class
        List<user> kk = mapeer.checkuser();//调用sql语句时，直接传入参数即可
        System.out.println(kk);
    }
}
