package com.classlink.websocket.api.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JwtExeptionCode {
	JWT_TOKEN_EXPIRED(401,"인증 유효시간이 지났습니다."),
	JWT_TOKEN_NOT_VALID(401,"올바르지않은 토큰입니다.");
	
	private final int opCode;
	private final String message;
}
