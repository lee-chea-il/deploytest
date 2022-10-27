package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.domain.Packet.PacketData;
import com.classlink.websocket.api.service.TestService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class TestController {
	
	public TestService testService() {
		return new TestService();
	}

	@OpCodeMapping(value = 111)
	public void test(WebSocketSession session, PacketData param)
			throws StreamReadException, DatabindException, IOException {
		//session.sendMessage(testService().test(message));
	}

	@OpCodeMapping(value = 112)
	public void test1(WebSocketSession session, BinaryMessage message)
			throws StreamReadException, DatabindException, IOException {
		//session.sendMessage(testService().test1(message));
	}
	
	@OpCodeMapping(value = 121)
	public void testPacketDto(WebSocketSession session, PacketData param)
			throws StreamReadException, DatabindException, IOException {
		session.sendMessage(testService().testPacketDto(param));
	}
}