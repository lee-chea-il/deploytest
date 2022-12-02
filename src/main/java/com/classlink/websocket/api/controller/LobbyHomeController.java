package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.lobby.home.LobbyHomeService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LobbyHomeController {
	
	private final LobbyHomeService homeService;
	
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_LIST)
	public void IdentityInstitutionEnrollmentList(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(homeService.findInstitutionEnrollmentsByInsCode(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_VIEW_STATUS_CHANGE)
	public void IdentityInstitutionEnrollmentViewStatusChange(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(homeService.modifyInstitutionEnrollmentViewStatus(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUESTER_INFO)
	public void IdentityInstitutionEnrollmentRequestorInfo(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(homeService.findInstitutionEnrollmentRequestorInfo(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_STATUS_CHANGE)
	public void IdentityInstitutionEnrollmentRequestStatusChange(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(homeService.modifyInstitutionEnrollmentRequestStatus(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.INSTITUTION_MY_LIST)
	public void myInstitutionList(WebSocketSession session, PacketData packetReqProto, String memId) throws IOException {
		session.sendMessage(homeService.findMyInstitutionByMemId(packetReqProto, memId));
	}
}
