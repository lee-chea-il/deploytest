package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.lobby.home.HomeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final HomeService homeService;
	
	@OpCodeMapping(value = OpCode.INSTITUTION_MY_LIST)
	public void myInstitutionList(WebSocketSession session, PacketData packetReqProto, String memId) throws IOException {
		session.sendMessage(homeService.findMyInstitutionByMemId(packetReqProto, memId));
	}
}
