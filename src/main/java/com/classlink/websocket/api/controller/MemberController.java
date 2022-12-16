package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.exeption.ErrorCode;
import com.classlink.websocket.api.common.exeption.ProtoParseException;
import com.classlink.websocket.api.member.MemberService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@OpCodeMapping(value = OpCode.IDENTITY_CREATE)
	public void memberIdentityAdd(WebSocketSession session, RequestPacket packetReqProto, String userId) {
		try {
			session.sendMessage(memberService.addIdentity(packetReqProto, userId));
		}catch (InvalidProtocolBufferException e){
			throw new ProtoParseException(session, packetReqProto, ErrorCode.PROTO_PARSE_ERROR);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OpCodeMapping(value = OpCode.IDENTITY_LIST)
	public void memberIdentityList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findIdentitiesByMemberId(packetReqProto, userId));
	}

//	@OpCodeMapping(value = OpCode.AVATAR_CREATE)
//	public void IdentityAvatarAdd(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
//		session.sendMessage(memberService.addAvatar(packetReqProto, userId));
//	}

	@OpCodeMapping(value = OpCode.AVATAR_INFO)
	public void IdentityAvatarInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findAvatarListByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.AVATAR_CHANGE)
	public void IdentityAvatarChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyAvatarByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.INSTITUTION_INFO)
	public void IdentityInstitutionInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionInfoByInsCode(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_CREATE)
	public void IdentityInstitutionEnrollmentAdd(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.addInstitutionEnrollment(packetReqProto, userId));
	}

	//from lobby
	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_LIST)
	public void InstitutionEnrollmentList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionEnrollmentsByInsCode(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_VIEW_STATUS_CHANGE)
	public void InstitutionEnrollmentViewStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyInstitutionEnrollmentViewStatus(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUESTER_INFO)
	public void InstitutionEnrollmentRequestorInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionEnrollmentRequesterInfo(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.INSTITUTION_ENROLLMENT_REQUEST_STATUS_CHANGE)
	public void InstitutionEnrollmentRequestStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyInstitutionEnrollmentRequestStatus(packetReqProto, userId));
	}



}
