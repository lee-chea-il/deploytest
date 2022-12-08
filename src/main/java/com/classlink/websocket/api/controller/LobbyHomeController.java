package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.lobby.home.LobbyHomeService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LobbyHomeController {
	
	private final LobbyHomeService lobbyHomeService;
	
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_LIST)
	public void InstitutionEnrollmentList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(lobbyHomeService.findInstitutionEnrollmentsByInsCode(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_VIEW_STATUS_CHANGE)
	public void InstitutionEnrollmentViewStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(lobbyHomeService.modifyInstitutionEnrollmentViewStatus(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUESTER_INFO)
	public void InstitutionEnrollmentRequestorInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(lobbyHomeService.findInstitutionEnrollmentRequesterInfo(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_STATUS_CHANGE)
	public void InstitutionEnrollmentRequestStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(lobbyHomeService.modifyInstitutionEnrollmentRequestStatus(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_MY_LIST)
	public void myInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findMyInstitutionByMemId(packetReqProto, memId));
	}
}
