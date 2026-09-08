package com.fundoonotes.notes.security;

import java.time.Duration;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private final StringRedisTemplate redisTemplate;

    public JwtUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String extractUserId(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String extractEmail(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("email", String.class);
    }

    public boolean isTokenValid(String token) {

        String key = "jwt:valid:" + token;

        String cachedResult = redisTemplate.opsForValue().get(key);

        if ("true".equals(cachedResult)) {
            return true;
        }

        try {

            var claims = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            Date expiration = claims.getExpiration();

            long remainingMillis = expiration.getTime() - System.currentTimeMillis();

            if (remainingMillis <= 0) {
                return false;
            }

			redisTemplate.opsForValue().set(key, "true", Duration.ofMillis(remainingMillis));

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
