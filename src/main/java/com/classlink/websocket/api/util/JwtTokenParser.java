
package com.classlink.websocket.api.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.classlink.websocket.api.common.CommonConst;
import com.classlink.websocket.api.jwt.domain.JwtExeptionCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenParser {

	// ==Jwt 토큰의 유효성 체크 메소드==//

	public boolean checkClaim(String token) {
		try {
			token = BearerRemove(token); // Bearer 제거
			Claims claims = Jwts.parser()
					.setSigningKey(Base64.getEncoder().encodeToString(CommonConst.SIGNING_KEY.getBytes()))
					.parseClaimsJws(token).getBody();
			return true;
		} catch (ExpiredJwtException e) { // Token이 만료된 경우 Exception이 발생한다.
			return false;

		} catch (JwtException e) { // Token이 변조된 경우 Exception이 발생한다.
			return false;
		}
	}
	
	// ==Jwt 토큰의 유효성 체크 메소드==//
	public JwtExeptionCode getValidationResult(String token) {
		try {
			token = BearerRemove(token); // Bearer 제거
			Claims claims = Jwts.parser()
					.setSigningKey(Base64.getEncoder().encodeToString(CommonConst.SIGNING_KEY.getBytes()))
					.parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) { // Token이 만료된 경우 Exception이 발생한다.
			return JwtExeptionCode.JWT_TOKEN_EXPIRED;

		} catch (JwtException e) { // Token이 변조된 경우 Exception이 발생한다.
			return JwtExeptionCode.JWT_TOKEN_NOT_VALID;
		}
		
		return null;
	}

	// ==토큰 앞 부분('Bearer') 제거 메소드==//
	private String BearerRemove(String token) {

		return token.substring("Bearer ".length());
	}

	// username(id) 리턴
	public String getUserId(String token) {

		token = BearerRemove(token); // Bearer 제거
		String userId = (String) Jwts.parser()
				.setSigningKey(Base64.getEncoder().encodeToString(CommonConst.SIGNING_KEY.getBytes()))
				.parseClaimsJws(token).getBody().get("user_name");
		return userId;
	}
}
