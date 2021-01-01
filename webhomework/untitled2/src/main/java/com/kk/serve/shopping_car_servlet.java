package com.kk.serve;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kk.dao.buy_book_timeMapper;
import com.kk.dao.order_listMapper;
import com.kk.dao.shopping_carMapper;
import com.kk.pojo.buy_book_time;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/shopping_car")
public class shopping_car_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String token=request.getParameter("token");
        String method=request.getParameter("method");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        SqlSession sqlSession= mybatisutils.getsqlsession();
        shopping_carMapper mapper=sqlSession.getMapper(shopping_carMapper.class);
        if(method.equals("updatenums"))
        {
            String book_name=request.getParameter("book_name");
            String book_nums=request.getParameter("book_nums");
            if (Integer.valueOf(book_nums) > 0)
            {
                Map<String, String> map = new HashMap<>();
                map.put("userid", userid);
                map.put("book_name", book_name);
                map.put("book_nums", book_nums);
                int k = mapper.updateuserdetail(map);
            } else if (Integer.valueOf(book_nums) == 0)
            {
                Map<String, String> map = new HashMap<>();
                map.put("userid", userid);
                map.put("book_name", book_name);
                int k = mapper.deluserbook(map);
            }
            List<shopping_car> cars = mapper.getuserdetail(userid);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String newcar = gson.toJson(cars);
            out.println(newcar);
        }
       else if(method.equals("set_account"))
        {
            String book_name=request.getParameter("book_name");
            String total_nums=request.getParameter("total_nums");
            String shoppinger=request.getParameter("shoppinger");
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            Gson gson=new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonElements = jsonParser.parse(book_name).getAsJsonArray();
            long timeMils=System.currentTimeMillis();
            for (JsonElement bean : jsonElements) {
                shopping_car car=gson.fromJson(bean,shopping_car.class);
                SqlSession sqlSession1=mybatisutils.getsqlsession();
                buy_book_timeMapper mapper1=sqlSession1.getMapper(buy_book_timeMapper.class);
                buy_book_time time=new buy_book_time(userid,timeMils,car.getBook_name(),car.getBook_nums(),car.getBook_price());
                mapper1.insertdata(time);
                sqlSession1.close();
                mapper.deluserdetail(car);
            }
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SqlSession sqlSession2=mybatisutils.getsqlsession();
            order_listMapper mapper2=sqlSession2.getMapper(order_listMapper.class);
            Map<String,String> map=new HashMap<>();
            map.put("userid",userid);
            map.put("time",sdf.format(date));
            map.put("timeid",String.valueOf(timeMils));
            map.put("shoppinger_address",address);
            map.put("shoppinger",shoppinger);
            map.put("total_price",total_nums);
            map.put("sigin","0");
            mapper2.inserdata(map);

            List<shopping_car> cars = mapper.getuserdetail(userid);
            PrintWriter out = response.getWriter();
            Gson gson1 = new Gson();
            String newcar = gson1.toJson(cars);
            out.println(newcar);
        }
       else if(method.equals("del"))
        {
            String book_name=request.getParameter("book_name");
            shopping_car car=new shopping_car(userid,book_name,"","");
            mapper.deluserdetail(car);
            List<shopping_car> cars = mapper.getuserdetail(userid);
            PrintWriter out = response.getWriter();
            Gson gson1 = new Gson();
            String newcar = gson1.toJson(cars);
            out.println(newcar);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession sqlSession= mybatisutils.getsqlsession();
        shopping_carMapper mapper=sqlSession.getMapper(shopping_carMapper.class);
        String token=request.getParameter("token");
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("kk")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String userid=decodedJWT.getClaim("userid").asString();
        List<shopping_car> cars=mapper.getuserdetail(userid);
        Gson gson=new Gson();
        String data=gson.toJson(cars);
        PrintWriter out=response.getWriter();
        out.println(data);
    }
}
