package com.classlink.websocket.api.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.jwt.domain.JwtExeptionCode;
import com.classlink.websocket.api.jwt.domain.proto.JwtExceptionProto.JwtException;
import com.classlink.websocket.api.util.JwtTokenParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtExceptionResponseService {
	
	@Autowired
	JwtTokenParser jwtTokenParser;
	
	public BinaryMessage tokenExceptionThrow (RequestPacket packetReqProto) throws StreamReadException, DatabindException, IOException {
		log.info("tokenExceptionThrow 함수 실행!");
		
		JwtExeptionCode resultCode = jwtTokenParser.getValidationResult(packetReqProto.getAccessToken());
		
		JwtException jwtException = JwtException.newBuilder().setMessage(resultCode.getMessage()).build();
		
		ResponsePacket packetData = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
			.setInstanceId(packetReqProto.getInstanceId()).setResultCode(resultCode.getCode()).setResultMessage(resultCode.getMessage()).build();
		
		return new BinaryMessage(packetData.toByteArray());
	}
}
