package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.kk.dao.shopping_addressMapper;
import com.kk.pojo.shopping_address;
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
import java.util.Map;

@WebServlet("/shopping_address")
public class shopping_address_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
//        System.out.println(userid);
        SqlSession sqlSession=mybatisutils.getsqlsession();
        shopping_addressMapper mappre=sqlSession.getMapper(shopping_addressMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("userid",userid);
        shopping_address address=mappre.selectcurrentaddress(map);
//        System.out.println(address);
        Gson gson=new Gson();
        String data=gson.toJson(address);
        PrintWriter out=response.getWriter();
        out.println(data);

    }
}