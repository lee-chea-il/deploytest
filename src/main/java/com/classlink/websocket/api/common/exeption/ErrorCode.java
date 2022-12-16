package com.classlink.websocket.api.common.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    PROTO_PARSE_ERROR(506,"protobuf 데이터 형태가 잘못되었습니다.");

    private final int code;
    private final String message;
}
