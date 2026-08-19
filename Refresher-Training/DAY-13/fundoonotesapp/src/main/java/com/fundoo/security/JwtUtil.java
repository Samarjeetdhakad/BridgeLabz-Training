package com.fundoo.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	
	private final SecretKey secretKey;
	private final long expirationMillis = 1000 * 60 *60;
	
	public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
	}

	public String generateToken(UserDetails user) {
		
		return Jwts.builder().subject(user.getUsername())
				.claim("email", user.getUsername())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + expirationMillis)
						)
				.signWith(secretKey)
				.compact();
		
		
		
	}

	

}
