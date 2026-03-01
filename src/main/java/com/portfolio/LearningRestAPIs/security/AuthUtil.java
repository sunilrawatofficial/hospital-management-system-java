package com.portfolio.LearningRestAPIs.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.portfolio.LearningRestAPIs.admin.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class AuthUtil {

  @Value("${jwt.secret}")
  private String jwtSecretKey;

  private SecretKey getSecretKey() {
    return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
  }

  public String generateAccessToken(User user) {
    return Jwts.builder()
        .setSubject(user.getUsername())
        .claim("userId", user.getId().toString())
        .setIssuedAt(new Date())
        .signWith(getSecretKey())
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
        .compact();
  }
    
}