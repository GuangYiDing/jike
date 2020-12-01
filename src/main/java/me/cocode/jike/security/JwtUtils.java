package me.cocode.jike.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author guangyi
 */
public class JwtUtils {

    /* *
     * 过期时间7天
     * */

    private final static long EXPIRE_TIME =  7 * 24 * 60 * 60 * 1000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    /**
     * 验证 token 是否正确
     * @param token 密钥
     * @param username 用户名
     * @param password 密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String password) {
        try {
            // 加密算法
            Algorithm algorithm = Algorithm.HMAC256(password);
            // 验证器 构造器(算法,混淆条件).生成
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            DecodedJWT jwt      = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean verify(String token, Integer userId, String password) {
        try {
            // 加密算法
            Algorithm algorithm = Algorithm.HMAC256(password);
            // 验证器 构造器(算法,混淆条件).生成
            JWTVerifier verifier = JWT.require(algorithm).withClaim("userId", userId).build();
            DecodedJWT jwt      = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取token中的信息无需解密
     * @param token 密码
     * @return 是否获得
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取token中的信息无需解密
     * @param token 密码
     * @return 是否获得
     */
    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt    = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名7天后失效
     * @param userId 用户id
     * @param password 密码
     * @return 加密的token
     */
    public static String sign(Integer userId, String password) {
        try {
            Date      date      = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT
                    .create()
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e){
            return null;
        }
    }
}
