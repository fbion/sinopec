package com.sensenets.sinopec.core.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.core.security.entity.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
  * @ClassName: JwtUtil
  * @Description: jwt工具
  * @author think
  * @date 2018年8月8日 上午9:47:57
  *
  */
@Component
public class JwtUtil {


    private static final String CLAIM_KEY_USER_ACCOUNT = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private  String secret; //秘钥

    @Value("${jwt.expiration}")
    private  Long expiration; //过期时间

    /**
     * 从token中获取用户account
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        String useraccount;
        try {
            final Claims claims = getClaimsFromToken(token);
            useraccount = claims.getSubject();
        } catch (Exception e) {
            useraccount = null;
        }
        return useraccount;
    }

    /**
     * 从token中获取创建时间
     * @param token
     * @return
     */
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    /**
     * 获取token的过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 从token中获取claims
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生存token的过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
    
    

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        Boolean result= expiration.before(new Date());
        return result;
    }

    /**
     * 生成token
     * @param  user
     * @return
     */
    public String generateToken(JwtUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ACCOUNT, user.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
    
    /**
     * 生成token
     * @param  user
     * @return
     */
    public  String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ACCOUNT, authentication.getName());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }


    /**
     * 生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USER_ACCOUNT, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

     String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * token 是否可刷新
     * @param token
     * @return
     */
    public Boolean canTokenBeRefreshed(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证token
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String useraccount = getUsernameFromToken(token);
        Boolean result= (
                useraccount.equals(user.getUsername())
                        && !isTokenExpired(token)
        );
        return result;
    }
    
    

    
    /**
     * @Title: isSameUid
     * @Description: 检查登陆的账户和查询到的账户是否一致（大小写敏感）
     * @param requestUserId
     *            登陆账户
     * @param findUserId
     *            查询到的账户
     * @return 是否
     */
    public static boolean isSameUid(String requestUserId, String findUserId) {
        return StringUtils.equals(requestUserId, findUserId);
    }

    /**
     * @Title: checkUserIsExpire
     * @Description: 检查是否过期（有效时间段之外视为过期，开始或结束时间为空也视为过期）
     * @param startTime
     *            开始时间
     * @param endTime
     *            截止时间
     * @return 是否
     * @throws Exception
     *             异常
     */
    public static boolean checkUserIsExpire(String startTime, String endTime) throws Exception {
        if (StringUtils.isNoneBlank(startTime) && StringUtils.isNoneBlank(endTime)) {
            boolean startFlag = true;
            boolean endFlag = true;
            if (DateHelper.reverse2Date(startTime).getTime() - System.currentTimeMillis() <= 0) {
                startFlag = false;
            }
            if (DateHelper.reverse2Date(endTime).getTime() - System.currentTimeMillis() > 0) {
                endFlag = false;
            }
            return startFlag || endFlag;
        }
        return true;
    }

   
    /**
     * @Title: checkUserIsExpire
     * @Description: 检查是否过期（有效时间段之外视为过期，开始或结束时间为空也视为过期）
     * @param startTime
     *            开始时间
     * @param endTime
     *            截止时间
     * @return 是否
     * @throws Exception
     *             异常
     */
    public static boolean checkUserIsExpire(long startTime, long endTime) throws Exception {
        if (startTime >0 && endTime >0 ) {
            boolean startFlag = true;
            boolean endFlag = true;
            if (startTime - System.currentTimeMillis() <= 0) {
                startFlag = false;
            }
            if (endTime - System.currentTimeMillis() > 0) {
                endFlag = false;
            }
            return startFlag || endFlag;
        }
        return true;
    }
}