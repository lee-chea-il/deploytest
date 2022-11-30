package com.classlink.websocket.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpCode {
	
	DEFAULT(0), IDENTITY_CREATE(100), IDENTITY_LIST(101), 
	AVARTAR_CREATE(102), AVARTAR_DETAIL(103), AVARTAR_CHANGE(104),
	INSTITUTION_MY_LIST(120);

	private final int code;

}
