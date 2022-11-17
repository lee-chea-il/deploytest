package com.classlink.websocket.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpCode {
	
	DEFAULT(0), IDENTITY_ADD(100), IDENTITY_DETAILS(101),
	INSTITUTION_MY_LIST(201),
	NOT_FOUND(500), ADD_FAIL(501);

	private final int value;

}
