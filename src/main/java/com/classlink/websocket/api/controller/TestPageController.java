package com.classlink.websocket.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class TestPageController {
	@RequestMapping("/testPage")
	public String testPage() {
		log.info("here?");
		log.info("upload?");
		return "webSocketApiTest";
	}
}
