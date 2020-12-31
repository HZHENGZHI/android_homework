package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.kk.dao.book_collectionMapper;
import com.kk.dao.book_searchMapper;
import com.kk.pojo.book;
import com.kk.pojo.book_collection;
import com.kk.pojo.shopping_car;
import com.kk.utilis.mybatisutils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/book_search")
public class book_search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession=mybatisutils.getsqlsession();
        book_searchMapper mapper=sqlSession.getMapper(book_searchMapper.class);
        String data=request.getParameter("kk");
        String token=request.getParameter("token");
        String method=request.getParameter("method");
        JWTVerifier jWTVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jWTVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        Gson gson=new Gson();
        book books=new book();
        books =gson.fromJson(data,book.class);
        shopping_car car=new shopping_car(userid,books.getBook_name(),"1",books.getBook_price());
        List<shopping_car> shopping_carList=mapper.checkIssave(car);

        if(method.equals("shopping_car") || method.equals("total_car"))
        {
            if (shopping_carList.size() >= 1)
            {
                int nums = Integer.valueOf(shopping_carList.get(0).getBook_nums()) + 1;
                String newnums = String.valueOf(nums);
                shopping_car updatecar = new shopping_car(userid, books.getBook_name(), newnums, books.getBook_price());
                int k = mapper.updatecar(updatecar);
            }
            else
            {
                int k = mapper.addshoppingcar(car);
            }
        }
        else if(method.equals("add_collection"))
        {
            book_collection co=new book_collection();
            co=gson.fromJson(data,book_collection.class);
            book_collectionMapper mapper1=sqlSession.getMapper(book_collectionMapper.class);
            book_collection newcollection=new book_collection(userid,co.getBook_name(),co.getCategory(),co.getBook_price());
            Map<String,String> map=new HashMap<>();
            map.put("userid",userid);
            map.put("book_name",co.getBook_name());
            List<book_collection>book_collection=mapper1.checksamedata(map);

            if(book_collection.size()<1)
            {
                int k=mapper1.insertusercollection(newcollection);
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession session= mybatisutils.getsqlsession();
        book_searchMapper mapper=session.getMapper(book_searchMapper.class);
        List<book> books=mapper.getallbook();
        Gson gson=new Gson();
        String data=gson.toJson(books);
        PrintWriter out=response.getWriter();
        out.println(data);

    }
}
