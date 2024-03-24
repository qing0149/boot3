package com.jq.common.api.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 * Created by RubinChu on 2021/1/22 下午 4:11
 */
@Slf4j
@Component
public class JwtUtil {

    public static final Long TWO_LONG = 2L;

    /**
     * 秘钥
     */
    private final static String JWT_PRIVATE_KEY = "0CB16040A41140E48F2F93A7BE222C46";

    /**
     * 刷新时间
     */
    private final static String RENEWAL_TIME = "RENEWAL_TIME";

    /**
     * 生成token
     *
     * @param subject
     * @param claimKey
     * @param claimValue
     * @param expire
     * @return
     */
    public static String generateToken(String subject, String claimKey, Object claimValue, Long expire) {
        String token = Jwts.builder()
                .setSubject(subject)
                .claim(claimKey, claimValue)
                .claim(RENEWAL_TIME, new Date(System.currentTimeMillis() + expire / TWO_LONG))
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS256, JWT_PRIVATE_KEY)
                .compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Object analyzeToken(String token, String claimKey) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_PRIVATE_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims.get(claimKey);
        } catch (Exception e) {
            return null;
        }
    }


}
