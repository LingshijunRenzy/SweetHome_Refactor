package org.tomjerry.sweethome.util.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

/*
    * 这个类用于生成一个随机的令牌
 */
@Service
public class TokenService {

    private static final String SECRET_KEY = "6D78E658-D49A-D922-6F89-428E12867B2B--94862B27-3BBF-C724-4D5C-B46005478A1D";  // 秘钥（32字节）
    private static final Long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7L; // 令牌的有效时间为7天
    private Key key;

    private TokenService() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private static final TokenService instance = new TokenService();

    public static TokenService getInstance() {
        return instance;
    }

    /*
    * 生成一个随机的令牌
    * @param userId 用户id
     */
    public String generateToken(Integer userId){
        try{
            String token = Jwts.builder()
                    .setSubject(userId.toString())
                    .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
            return token;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * 从令牌中获取用户id
    * @param token 令牌
    * @return 用户id
     */
    public Integer getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * 验证令牌是否有效
    * @param token 令牌
    * @return 令牌是否有效
     */
    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
