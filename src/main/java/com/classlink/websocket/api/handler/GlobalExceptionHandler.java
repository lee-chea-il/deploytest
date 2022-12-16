package com.classlink.websocket.api.handler;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto;
import com.classlink.websocket.api.common.exeption.ProtoParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProtoParseException.class)
    public void protobufParseException(ProtoParseException exception){

        WebSocketSession session = exception.getSession();

        ResponsePacketProto.ResponsePacket packetResProto = ResponsePacketProto.ResponsePacket.newBuilder()
                .setOpCode(exception.getPacketReqProto().getOpCode())
                .setAccessToken(exception.getPacketReqProto().getAccessToken()).setInstanceId(exception.getPacketReqProto().getInstanceId())
                .setResultCode(exception.getErrorCode().getCode())
                .setResultMessage(exception.getErrorCode().getMessage())
                .build();

//        session.sendMessage(new BinaryMessage(packetResProto.toByteArray()));

    }
}
