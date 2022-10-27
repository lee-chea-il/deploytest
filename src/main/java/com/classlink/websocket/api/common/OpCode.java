package com.classlink.websocket.api.common;

public enum OpCode {
	TEST(121), LOGIN(101);

	private final int value;

	OpCode(int value) {
		this.value = value;
	}
}
