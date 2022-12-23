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
	public void IdentityAdd(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
			session.sendMessage(memberService.addIdentity(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_LIST)
	public void IdentityList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findIdentitiesByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_CHANGE)
	public void IdentityChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyIdentityByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_PROFILE_DETAIL)
	public void IdentityProfileDetail(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findIdentityProfileDetailByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_PROFILE_UPDATE)
	public void IdentityProfileUpdate(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyIdentityProfileByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_AVATAR_LIST)
	public void IdentityAvatarList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findAvatarsByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_AVATAR_CHANGE)
	public void IdentityAvatarChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyAvatarByMemberId(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_INSTITUTION_INFO)
	public void IdentityInstitutionInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionInfoByInsCode(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_INSTITUTION_ENROLLMENT)
	public void IdentityInstitutionEnrollmentAdd(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.addInstitutionEnrollment(packetReqProto, userId));
	}

	//from lobby
	@OpCodeMapping(value = OpCode.IDENTITY_ENROLLMENT_LIST)
	public void InstitutionEnrollmentList(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionEnrollmentsByInsCode(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_ENROLLMENT_CONFIRM)
	public void InstitutionEnrollmentViewStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyInstitutionEnrollmentViewStatus(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_ENROLLMENT_INFO)
	public void InstitutionEnrollmentRequestorInfo(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.findInstitutionEnrollmentRequesterInfo(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.IDENTITY_ENROLLMENT_REPLY)
	public void InstitutionEnrollmentRequestStatusChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyInstitutionEnrollmentRequestStatus(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.LOGIN_INSTITUTE_REGIST)
	public void LoginInstituteRegistrationChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyLoginInstituteRegistration(packetReqProto, userId));
	}

	@OpCodeMapping(value = OpCode.LOGIN_IDENTITY_REGIST)
	public void LoginIdentityRegistrationChange(WebSocketSession session, RequestPacket packetReqProto, String userId) throws StreamReadException, DatabindException, IOException {
		session.sendMessage(memberService.modifyLoginIdentityRegistration(packetReqProto, userId));
	}

}
