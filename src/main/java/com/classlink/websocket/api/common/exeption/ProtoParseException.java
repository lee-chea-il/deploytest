package com.classlink.websocket.api.common.exeption;

import com.classlink.websocket.api.common.domain.proto.RequestPacketProto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;


@AllArgsConstructor
@Getter
@Setter
public class ProtoParseException extends RuntimeException {

    private final WebSocketSession session;

    private final RequestPacketProto.RequestPacket packetReqProto;
    private final ErrorCode errorCode;

}
