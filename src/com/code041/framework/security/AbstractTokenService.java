package com.code041.framework.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public abstract class AbstractTokenService {

	protected abstract String getSecret();

	protected abstract String getIssuer();

	protected abstract Integer getExpirationTime();

	public String createToken(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		return createToken(user);
	}

	public String createToken(UserDetails user) {
		try {
			var algorithm = Algorithm.HMAC256(getSecret());
			return JWT.create().withIssuer(getIssuer()).withSubject(user.getUsername())
					.withExpiresAt(getExpirationDate()).sign(algorithm);

		} catch (JWTCreationException e) {
			throw new RuntimeException(e);
		}

	}

	private Instant getExpirationDate() {
		return LocalDateTime.now().plusHours(getExpirationTime()).toInstant(ZoneOffset.of("-03:00"));
	}

	public String getSubject(String tokenJWT) {
		try {
			var algorithm = Algorithm.HMAC256(getSecret());
			return JWT.require(algorithm).withIssuer(getIssuer()).build().verify(tokenJWT).getSubject();
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Invalid or expired token");
		}
	}

}
