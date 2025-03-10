package com.example.utils;

import com.example.config.SystemConfig;
import com.example.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProjectUtil {

    // 校验长度
    public static Boolean verify(String name) {
        if (name.length() > 0 && name.length() < 20){
            return true;
        }
        return false;
    }

    public static Boolean verify(String username, String password) {
        if (username.length() < 15 && username.length() >= 6 && password.length() >= 6 && password.length() < 10) {
            return true;
        }
        return false;
    }

    public static Boolean verify(String username, String password, String repassword) {
        if (username.length() < 15 && username.length() >= 6 && password.length() >= 6 && password.length() < 10 && repassword.length() >= 6 && repassword.length() < 10) {
            return true;
        }
        return false;
    }

    public static Boolean hasLength(String jwt) {
        if (jwt == null) {
            return true;
        }
        return false;
    }

    // 生成文件名
    public static String UUIDFileName(MultipartFile image) {
        // 获取唯一标识
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-","");
        // 获取文件后缀
        Integer sufIndex = image.getOriginalFilename().lastIndexOf('.');
        String suffix = image.getOriginalFilename().substring(sufIndex);
        return "E:\\javaprojects\\vue3+ssm\\vue-bookManagement\\src\\assets\\" + uuidStr + suffix;
    }

    // 生成jwt
    public static String generateJwt(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        String jwt = Jwts.builder()
                .setClaims(claims) // 设置自定义内容
                .signWith(SignatureAlgorithm.HS256, SystemConfig.SECRET_KEY) // 加密算法跟密钥
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 10000)) // 令牌有效期
                .compact();
        return jwt;
    }

    // 解析jwt令牌
    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SystemConfig.SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
