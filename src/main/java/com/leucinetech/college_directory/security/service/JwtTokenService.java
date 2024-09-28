package com.leucinetech.college_directory.security.service;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * @author Sudharshan
 */

@Component
public class JwtTokenService {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenService.class);
	
	@Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private int jwtExpirationInMs;
	
	public String generateAccessToken(String username, String role) {

		Date currentDate = new Date();
 		Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);
 		

 		return Jwts.builder()
	                .claim("UserName", username)
	                .claim("Role", role) 
	 				.setIssuedAt(new Date())
	 				.setExpiration(expireDate)
	 				.signWith(key(), SignatureAlgorithm.HS256)
	 				.compact();
 	}
 	
 	private Key key() {
 		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
 	}

 	public String getUsername(String token) {
 		try {
			Jws<Claims> claimsJws = Jwts.parserBuilder()
			        .setSigningKey(key())
			        .build()
			        .parseClaimsJws(token);
			Claims claims = claimsJws.getBody();
			return claims.get("UserName", String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 	
 	public String getRole(String token) {
 		try {
 			Jws<Claims> claimsJws = Jwts.parserBuilder()
 					.setSigningKey(key())
 					.build()
 					.parseClaimsJws(token);
 			Claims claims = claimsJws.getBody();
 			return claims.get("Role", String.class);
 		} catch (Exception e) {
 			e.printStackTrace();
 			return null;
 		}
 	}
 	
 	public boolean validateToken(String token) {
 		try {
 			Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
 			return true;
 		} catch (MalformedJwtException e) {
 			logger.error("Invalid JWT token: {}", e.getMessage());
 		} catch (ExpiredJwtException e) {
 			logger.error("JWT token is expired: {}", e.getMessage());
 		} catch (UnsupportedJwtException e) {
 			logger.error("JWT token is unsupported: {}", e.getMessage());
 		} catch (IllegalArgumentException e) {
 			logger.error("JWT claims string is empty: {}", e.getMessage());
 		}
 		return false;
 	}

}
