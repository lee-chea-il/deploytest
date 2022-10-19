package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.domain.PacketData;
import com.classlink.websocket.api.domain.PacketHeader;
import com.classlink.websocket.api.domain.testDto;
import com.classlink.websocket.api.service.TestService;
import com.classlink.websocket.api.service.TestService2;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class TestController2 {

	public TestService2 testService2() {
		return new TestService2();
	}

	@OpCodeMapping(value = 113)
	public void test(WebSocketSession session, BinaryMessage message)
			throws StreamReadException, DatabindException, IOException {
		log.info("113");
		session.sendMessage(testService2().test(message));
	}

	@OpCodeMapping(value = 114)
	public void test1(WebSocketSession session, BinaryMessage message)
			throws StreamReadException, DatabindException, IOException {
		log.info("114");
		session.sendMessage(testService2().test1(message));
	}

}