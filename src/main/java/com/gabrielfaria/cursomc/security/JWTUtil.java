package com.gabrielfaria.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String generateToken(String username) {
		return Jwts.builder() 			//gera um token
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) // converte em array de byte
				.compact();
	}	
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token); // utilizado para armazenar as reinvindicações do token
		if(claims != null) {
			String username = claims.getSubject(); // metodo utilizado para pegar o user name atravez do claims
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis()); // pegar tempo atual
			if(username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}
	
	public String getUsername(String token) {
		Claims claims = getClaims(token); // utilizado para armazenar as reinvindicações do token
		if(claims != null) {
			return claims.getSubject(); // metodo utilizado para pegar o user name atravez do claims
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch(Exception e) {
			return null;
		}
	}
	

}
