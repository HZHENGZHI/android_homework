package com.kk.serve;

import com.google.gson.Gson;
import com.kk.dao.book_searchMapper;
import com.kk.pojo.book;
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

@WebServlet("/admin_manger_servlet")
public class admin_manger_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String book_name=request.getParameter("book_name");
        String book_price=request.getParameter("book_price");
        String category=request.getParameter("category");
        String method=request.getParameter("method");
        PrintWriter out=response.getWriter();

        if(method.equals("update_book"))
        {
            Gson gson=new Gson();
            book book=new book(book_name,category,book_price);
            SqlSession getsqlsession = mybatisutils.getsqlsession();
            book_searchMapper mapper=getsqlsession.getMapper(book_searchMapper.class);
            mapper.updatebook(book);
            List<book> books=mapper.getallbook();
            String data=gson.toJson(books);
            out.println(data);
        }
        else if(method.equals("del_book"))
        {
            Gson gson=new Gson();
            book book=new book(book_name,category,book_price);
            SqlSession getsqlsession = mybatisutils.getsqlsession();
            book_searchMapper mapper=getsqlsession.getMapper(book_searchMapper.class);
            mapper.delbook(book);
            List<book> books=mapper.getallbook();
            String data=gson.toJson(books);
            out.println(data);
        }
        else if(method.equals("add_book"))
        {
            Gson gson=new Gson();
            book book=new book(book_name,category,book_price);
            SqlSession getsqlsession = mybatisutils.getsqlsession();
            book_searchMapper mapper=getsqlsession.getMapper(book_searchMapper.class);
            mapper.inserbook(book);
            List<book> books=mapper.getallbook();
            String data=gson.toJson(books);
            out.println(data);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
