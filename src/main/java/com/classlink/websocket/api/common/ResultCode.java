package com.classlink.websocket.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
	
	SUCCESS(200,"작업결과 이상없습니다."),
	NOT_FOUND(503,"일치하는 결과가 없습니다."), ADD_FAIL(504, "생성에 실패했습니다."),
	MODIFY_FAIL(505, "수정을 실패했습니다.");

	private final int code;
	private final String message;
}
