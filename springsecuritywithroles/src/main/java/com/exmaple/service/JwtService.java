package com.exmaple.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.exmaple.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${app.jwt-secret}")
	private String secretKey;

	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().claims().add(claims).subject(user.getUsername()).issuer("Rahul")
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 10 * 1000)).and().signWith(generateKey())
				.compact();
	}

	private SecretKey generateKey() {
		byte[] decode = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(decode);
	}

	public String extractUserName(String token) {
		Claims claims = Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token).getPayload();

		String username = claims.getSubject(); // claims here is the payload

		return username;
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		Claims claims = Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token).getPayload();
		return (extractUserName(token).equals(userDetails.getUsername())
				&& !(claims.getExpiration().before(new Date())));

	}

}
