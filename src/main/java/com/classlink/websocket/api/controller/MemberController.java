package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.Packet.PacketData;
import com.classlink.websocket.api.member.MemberService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

//	public MemberService memberService() {
//		return new MemberService();
//	}
	
	@Autowired
	MemberService memberService;

	@OpCodeMapping(value = 101)
	public void memberIdentityDetails(WebSocketSession session, PacketData packet) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findMemberIdentityByIdMemberIdx(packet));
	}
}
