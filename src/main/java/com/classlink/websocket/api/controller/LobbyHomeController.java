package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.lobby.home.LobbyHomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LobbyHomeController {
	
	private final LobbyHomeService lobbyHomeService;

	@OpCodeMapping(value = OpCode.INSTITUTION_MY_LIST)
	public void myInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findMyInstitutionByMemId(packetReqProto, memId));
	}

}
