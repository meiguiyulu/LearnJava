package com.lyj.learnjwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static String TOKEN = "token!Q@W3e4r";
    /**
     * 生成token  header.payload.signature
     * @param map  //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String,String> map){
        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,7);
        builder.withExpiresAt(instance.getTime()); // 指定过期时间
        return builder.sign(Algorithm.HMAC256(TOKEN)); // 前面
    }
    /**
     * 验证token的合法性
     * @param token
     * @return
     */
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);  // 如果验证通过，则不会把报错，否则会报错
    }
    /**
     * 获取token中payload
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}