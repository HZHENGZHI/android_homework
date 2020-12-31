package com.kk.serve;

import com.google.gson.Gson;
import com.kk.dao.*;
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

@WebServlet("/admin_user")
public class admin_user extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid=request.getParameter("userid");
        SqlSession sqlSession= mybatisutils.getsqlsession();

        userMapper users=sqlSession.getMapper(userMapper.class);
        users.deluser(userid);

        shopping_carMapper shopping_car=sqlSession.getMapper(shopping_carMapper.class);
        shopping_car.delusercar(userid);

        shopping_addressMapper shopping_address = sqlSession.getMapper(shopping_addressMapper.class);
        shopping_address.deluseraddress(userid);

        order_listMapper order_list = sqlSession.getMapper(order_listMapper.class);
        order_list.deluserorderlist(userid);

        buy_book_timeMapper buy_book_time=sqlSession.getMapper(buy_book_timeMapper.class);
        buy_book_time.deluserbook(userid);

        book_collectionMapper book_collection=sqlSession.getMapper(book_collectionMapper.class);
        book_collection.deluserallcollection(userid);

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession= mybatisutils.getsqlsession();
        userMapper mapper=sqlSession.getMapper(userMapper.class);
        List<User> allusers=mapper.getalluser();
        System.out.println(allusers);
        Gson gson=new Gson();
        String data=gson.toJson(allusers);
        PrintWriter out=response.getWriter();
        out.print(data);
    }
}
