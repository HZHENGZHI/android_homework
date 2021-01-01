package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.kk.dao.userMapper;
import com.kk.pojo.User;
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
import java.util.List;

@WebServlet("/user_msg")
public class user_msg extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String method=request.getParameter("method");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();

        SqlSession sqlSession= mybatisutils.getsqlsession();
        userMapper mapper=sqlSession.getMapper(userMapper.class);
        if(method.equals("getusermsg"))
        {
            User user = mapper.getusermsg(userid);
            Gson gson = new Gson();
            String data = gson.toJson(user);
            PrintWriter out = response.getWriter();
            out.println(data);
        }
        else if(method.equals("getaddressmsg"))
        {
            List<shopping_address> addresses=mapper.getuseraddreess(userid);
            Gson gson=new Gson();
            String data=gson.toJson(addresses);
            PrintWriter out= response.getWriter();
            out.println(data);
        }
    }
}
