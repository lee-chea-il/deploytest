package com.classlink.websocket.api.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.proto.Packet.PacketData;
import com.classlink.websocket.api.jwt.domain.JwtExeptionCode;
import com.classlink.websocket.api.jwt.domain.proto.JwtExceptionResponse.JwtException;
import com.classlink.websocket.api.util.JwtTokenParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@Service
public class JwtExceptionResponseService {
	
	@Autowired
	JwtTokenParser jwtTokenParser;
	
	public BinaryMessage tokenExceptionThrow (PacketData packetReqProto) throws StreamReadException, DatabindException, IOException {
		
		JwtExeptionCode resultCode = jwtTokenParser.getValidationResult(packetReqProto.getAccessToken());
		
		int OpCode = resultCode != null ? resultCode.getOpCode() : packetReqProto.getOpCode();
		
		JwtException jwtException = JwtException.newBuilder().setMessage(resultCode.getMessage()).build();
		
		PacketData packetData = PacketData.newBuilder().setOpCode(OpCode).setAccessToken(packetReqProto.getAccessToken())
			.setInstanceId(packetReqProto.getInstanceId()).setData(jwtException.toByteString()).build();
		
		return new BinaryMessage(packetData.toByteArray());
	}
}
