package com.classlink.websocket.api.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@Controller
public class JwtExceptionResponseController {
	
	@Autowired
	JwtExceptionResponseService jwtExceptionResponseService;
	
	public void tokenException (WebSocketSession session, PacketData packetReqProto) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(jwtExceptionResponseService.tokenExceptionThrow(packetReqProto));
	}
}
