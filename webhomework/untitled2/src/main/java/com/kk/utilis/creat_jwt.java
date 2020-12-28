package com.kk.utilis;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

public class creat_jwt {
    public static String creatloginjwt(String userid,String userid_value,
                                String userpw,String userpw_value)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,24*60*60*20);
        String token= JWT.create()
                .withClaim(userid,userid_value)
                .withClaim(userpw,userpw_value)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256("kk"));
        return token;
    }
    public static String valitoken(String token)
    {
        JWTVerifier jWTVerifier=JWT.require(Algorithm.HMAC256("kk")).build();
        try
        {
              DecodedJWT decodedJWT=jWTVerifier.verify(token);
        }catch(Exception e)
        {
            return "过期";
        }
        return "ok";
    }


//    public static void main(String[] args) {
////        ("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VycHciOiIxMjMiLCJleHAiOjE2MTAzNTQzNTEsInVzZXJpZCI6IjEyMyJ9.6Knb3eFDvdrSL6qaYhoUvM3xYkw0qCMrMwwPfRImgsA");
//        JWTVerifier jWTVerifier=JWT.require(Algorithm.HMAC256("kk")).build();
//        DecodedJWT decodedJWT=jWTVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VycHciOiIxMjMiLCJleHAiOjE2MTA2MDUxMTMsInVzZXJpZCI6IjEyMyJ9.dOq7KcrbAFyR9JzMo9OYH9yeyJBXGiVR1Yy1bEI_mpI");
//        String kk=decodedJWT.getClaim("userid").asString();
//        String kkk=valitoken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VycHciOiIxMjMiLCJleHAiOjE2MTA2MDUxMTMsInVzZXJpZCI6IjEyMyJ9.dOq7KcrbAFyR9JzMo9OYH9yeyJBXGiVR1Yy1bEI_mpI");
//        System.out.println(kkk);
//        System.out.println(kk);
//    }
}
