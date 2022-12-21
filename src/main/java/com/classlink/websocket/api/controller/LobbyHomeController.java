package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.lobby.LobbyHomeService;
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

	@OpCodeMapping(value = OpCode.LOBBY_HOME_STUDENT_INSTITUTION_LIST)
	public void studentInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findStudentInstitutionsByMemId(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_FRANCHISE_INSTITUTION_LIST)
	public void franchiseInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findFranchiseInstitutionsByMemId(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_SCHEDULE_LIST)
	public void scheduleList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findSchedulesByMemId(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_CLASS_TEACHER_LIST)
	public void teacherList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findTeacherList(packetReqProto, memId));
	}

}
