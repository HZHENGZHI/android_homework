package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.kk.dao.book_collectionMapper;
import com.kk.pojo.book_collection;
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

@WebServlet("/book_collection_servlet")
public class boo_collection_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String book_name=request.getParameter("book_name");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        SqlSession sqlSession=mybatisutils.getsqlsession();
        book_collectionMapper mapper=sqlSession.getMapper(book_collectionMapper.class);

        Map<String,String> map=new HashMap<>();
        map.put("userid",userid);
        map.put("book_name",book_name);
        int k=mapper.delusercollection(map);
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        SqlSession sqlSession= mybatisutils.getsqlsession();
        book_collectionMapper mapper=sqlSession.getMapper(book_collectionMapper.class);
        List<book_collection> book_collections=mapper.getusercollection(userid);
        System.out.println(book_collections);
        Gson gson=new Gson();
        String data=gson.toJson(book_collections);
        PrintWriter out=response.getWriter();
        out.println(data);
    }
}
