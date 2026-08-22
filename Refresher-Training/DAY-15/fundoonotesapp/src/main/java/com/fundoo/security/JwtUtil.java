package com.fundoo.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

	private final SecretKey secretKey;
	private final long expirationMillis = 1000 * 60 * 60;

	// convert to secret key
	public JwtUtil(@Value("${jwt.secret}") String secret) {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	// token generation
	public String generateToken(UserDetails user, Long userId) {

		return Jwts.builder()
				.subject(user.getUsername())
				.claim("email", user.getUsername())
				.claim("userId",userId)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + expirationMillis))
				.signWith(secretKey)
				.compact();
	}
	
	 // Extract claims from JWT
    private Claims getClaims(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

	// validation
	public boolean isTokenValid(String token) {
		
		try {
			Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	// extraction
	public Long extractUserId(String token) {
		  return getClaims(token)
	                .get("userId", Long.class);
	}
}
