package com.fundoo.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

	private final SecretKey secretKey;
	private final StringRedisTemplate redisTemplate;
	private final long expirationMillis = 1000 * 60 * 60;

	// convert to secret key
	public JwtUtil(@Value("${jwt.secret}") String secret, StringRedisTemplate redisTemplate) {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.redisTemplate = redisTemplate;
	}

	// token generation
	public String generateToken(UserDetails user, Long userId) {

		return Jwts.builder().subject(user.getUsername()).claim("email", user.getUsername()).claim("userId", userId)
				.issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + expirationMillis))
				.signWith(secretKey).compact();
	}

	// validation
	public boolean isTokenValid(String token) {

		String cacheKey = "jwt:valid:" + token;
		String cached = redisTemplate.opsForValue().get(cacheKey);

		if (cached != null) {
			System.out.println("Cache HIT for token");
			return Boolean.parseBoolean(cached);
		}

		System.out.println("Cache MISS for token, performing real validation");

		try {
			var claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
			Date expiration = claims.getExpiration();

			long remainingMillis = expiration.getTime() - System.currentTimeMillis();
			
			if (remainingMillis <= 0) {
				return false;
			}
						 
			long cacheSeconds = Math.min(60, Math.max(1, remainingMillis / 1000));
			redisTemplate.opsForValue().set(cacheKey, "true", cacheSeconds, TimeUnit.SECONDS);
			System.out.println("Cached validation result for " + cacheSeconds + " seconds");

			return true;

		} catch (Exception e) {
			redisTemplate.opsForValue().set(cacheKey, "false", 10, TimeUnit.SECONDS);
			return false;
		}
	}

	
	// Extract claims from JWT
		private Claims getClaims(String token) {
			return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
		}
		
		
		
	// extraction
	public Long extractUserId(String token) {
		return getClaims(token).get("userId", Long.class);
	}

	// generate reset password token
	public String generateResetToken(String email, Long userId) {

		return Jwts.builder().subject(email).claim("email", email).claim("userId", userId)
				.claim("type", "PASSWORD_RESET").issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + expirationMillis)).signWith(secretKey).compact();
	}

	//validate the reset token
	public boolean isResetTokenValid(String token) {

		try {
			Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();

			String type = claims.get("type", String.class);

			return "PASSWORD_RESET".equals(type);

		} catch (Exception e) {
			return false;
		}
	}
}
