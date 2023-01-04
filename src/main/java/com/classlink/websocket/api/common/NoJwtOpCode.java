package com.classlink.websocket.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum NoJwtOpCode {

    SYS_WORLD_SET_INFO(120),
    SYS_WORLD_INTER_OBJ_SET_PACKAGE_CREATE(127),
    SYS_WORLD_INTER_OBJ_SET_CURRICULUM_CREATE(201),
    SYS_WORLD_INTER_OBJ_SET_CURRICULUM_INIT(128);

    private final int code;

    public static final List<Integer> codeValues = Arrays.stream(NoJwtOpCode.values()).map(value -> value.code)
            .collect(Collectors.toList());

}
