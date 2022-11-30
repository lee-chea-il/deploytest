package com.classlink.websocket.api.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JwtExeptionCode {
	JWT_EXPIRED(501,"인증 유효시간이 지났습니다."),
	JWT_NOT_VALID(502,"올바르지않은 토큰입니다.");
	
	private final int code;
	private final String message;
}
