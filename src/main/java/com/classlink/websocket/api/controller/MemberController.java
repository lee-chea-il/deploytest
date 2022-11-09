package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.Packet.CWclassPacket;
import com.classlink.websocket.api.member.MemberService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@OpCodeMapping(value = 100)
	public void memberIdentityAdd(WebSocketSession session, CWclassPacket packetReqProto) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.addMemberIdentity(packetReqProto));
	}
	
	@OpCodeMapping(value = 101)
	public void memberIdentityDetails(WebSocketSession session, CWclassPacket packetReqProto) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findMemberIdentityByMemberIdx(packetReqProto));
	}
}