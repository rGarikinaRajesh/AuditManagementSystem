package com.cognizant.AuditAuthenticationMicroservice.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class jwtUtil {

	private static String secretKey = "secret";

	/**
	 * 
	 * @param token
	 * @return retrieve username from jwt token
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * 
	 * @param token
	 * @return retrieve expiration date from jwt token
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	/**
	 * 
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * 
	 * @param token
	 * @return for retrieveing any information from token we will need the secret
	 *         key
	 */
	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	/**
	 * 
	 * @param token
	 * @return check if the token has expired
	 */
	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * 
	 * @param username
	 * @return generate token for user
	 */
	public static String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	/**
	 * 
	 * @param claims
	 * @param subject
	 * @return while creating the token - 1. Define claims of the token, like
	 *         Issuer, Expiration, Subject, and the ID 2. Sign the JWT using the
	 *         HS256 algorithm and secret key. compaction of the JWT to a URL-safe
	 *         string
	 */
	public static String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 100))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	/**
	 * 
	 * @param token
	 * @return validate token
	 */
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

}
