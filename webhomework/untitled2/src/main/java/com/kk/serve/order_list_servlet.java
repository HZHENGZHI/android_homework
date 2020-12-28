package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.kk.dao.order_listMapper;
import com.kk.pojo.buy_book_time;
import com.kk.pojo.order_list;
import com.kk.pojo.order_list_table;
import com.kk.utilis.mybatisutils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/order_list")
public class order_list_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String time=request.getParameter("time");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        PrintWriter out= response.getWriter();

        SqlSession sqlSession= mybatisutils.getsqlsession();
        order_listMapper mapper=sqlSession.getMapper(order_listMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("userid",userid);
        map.put("time",time);
        map.put("sigin","1");

        mapper.updateusersigin(map);

        Map<String,String> map1=new HashMap<>();
        map1.put("userid",userid);
        map1.put("sigin","0");
        List<order_list> selectuserorder = mapper.selectuserorder(map1);
        List<order_list_table> tableList=new ArrayList<>();
        for (order_list order_list : selectuserorder)
        {
            order_list_table table=new order_list_table();
            table.setTime(order_list.getTime());
            String kk="";
            List<buy_book_time> b=order_list.getBuy_book_time();
            for (com.kk.pojo.buy_book_time buy_book_time : b) {
                kk+=buy_book_time.getBook_name()+"-"+buy_book_time.getBook_nums()+"件-";
            }
            table.setAllbookname(kk.substring(0,kk.length()-1));
            table.setTotal_price(order_list.getTotal_price());
            table.setShoppinger(order_list.getShoppinger());
            table.setShoppinger_address(order_list.getShopping_address());
            tableList.add(table);
        }
        Gson gson=new Gson();
        String data=gson.toJson(tableList);
        out.println(data);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=request.getParameter("token");
        String method=request.getParameter("method");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        PrintWriter out= response.getWriter();

        {
            SqlSession sqlSession= mybatisutils.getsqlsession();
            order_listMapper mapper=sqlSession.getMapper(order_listMapper.class);
            Map<String,String> map=new HashMap<>();
            map.put("userid",userid);
            if(method.equals("notyet_finish")) {
                map.put("sigin", "0");
            }
            else if(method.equals("finish"))
            {
                map.put("sigin","1");
            }
            List<order_list> selectuserorder = mapper.selectuserorder(map);
            List<order_list_table> tableList=new ArrayList<>();
            for (order_list order_list : selectuserorder)
            {
                order_list_table table=new order_list_table();
                table.setTime(order_list.getTime());
                String kk="";
                List<buy_book_time> b=order_list.getBuy_book_time();
                for (com.kk.pojo.buy_book_time buy_book_time : b) {
                    kk+=buy_book_time.getBook_name()+"-"+buy_book_time.getBook_nums()+"件-";
                }
                table.setAllbookname(kk.substring(0,kk.length()-1));
                table.setTotal_price(order_list.getTotal_price());
                table.setShoppinger(order_list.getShoppinger());
                table.setShoppinger_address(order_list.getShopping_address());
                tableList.add(table);
            }
            Gson gson=new Gson();
            String data=gson.toJson(tableList);
            out.println(data);

        }
    }
}
