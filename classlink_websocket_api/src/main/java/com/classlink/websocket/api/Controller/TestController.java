package com.classlink.websocket.api.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.OpCodeAnnotation;
import com.classlink.websocket.api.service.TestService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

@Controller
public class TestController {
	@Autowired
	TestService testService;

	@OpCodeAnnotation(value = "111")
	public BinaryMessage test(BinaryMessage message) throws StreamReadException, DatabindException, IOException {

		return testService.test(message);
	}
}
