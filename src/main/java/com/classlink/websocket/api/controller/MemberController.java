package com.classlink.websocket.api.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
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

	@OpCodeMapping(value = OpCode.IDENTITY_CREATE)
	public void memberIdentityAdd(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.addMemberIdentity(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.IDENTITY_LIST)
	public void memberIdentityDetails(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findMemberIdentityByMemberId(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.AVARTAR_CREATE)
	public void IdentityAvartarAdd(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.addIdentityAvartar(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.AVARTAR_DETAIL)
	public void IdentityAvartarDetails(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findIdentityAvartarByMemberId(packetReqProto, userId));
	}
	
	@OpCodeMapping(value = OpCode.AVARTAR_CHANGE)
	public void IdentityAvartarModify(WebSocketSession session, PacketData packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyIdentityAvartarByMemberId(packetReqProto, userId));
	}
}
