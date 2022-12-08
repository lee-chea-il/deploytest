package com.classlink.websocket.api.member;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.member.domain.dto.MemberDto.AvatarDetailDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.InstitutionInfoDto;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarChangeResProto.IdentityAvatarChangeRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarCreateResProto.IdentityAvatarCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarDetailResProto.IdentityAvatarDetailRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityCreateResProto.IdentityCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityInstitutionEnrollmentRequestResProto.IdentityInstitutionEnrollmentRequestRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityInstitutionInfoResProto.IdentityInstitutionInfoRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityListResProto.IdentityListRes;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarChangeParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarDetailParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityListParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.InstitutionEnrollmentRequestParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.InstitutionInfoParam;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarCreateReqProto.IdentityAvatarCreateReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarDetailReqProto.IdentityAvatarDetailReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityCreateReqProto.IdentityCreateReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityInstitutionEnrollmentRequestReqProto.IdentityInstitutionEnrollmentRequestReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityInstitutionInfoReqProto.IdentityInstitutionInfoReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityListReqProto.IdentityListReq;
import com.classlink.websocket.api.util.CommonUtil;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public BinaryMessage findIdentitiesByMemberId(RequestPacket packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityListReq identityListReqProto = IdentityListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		IdentityListParam identityListParam = IdentityListParam.builder().ins_code(identityListReqProto.getInsCode())
				.mem_id(userId).build();
		
		List<String> identityDtoList = memberMapper.selectIdentitiesByMemberId(identityListParam);
	
		IdentityListRes.Builder identityListRes = IdentityListRes.newBuilder();
		
		if(identityDtoList != null) {
			CommonUtil.nullSafeSet(identityDtoList, identityListRes::addAllIdentityTypes);
		}
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(identityListRes.build().toByteString())
				.build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addIdentity(RequestPacket packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityCreateReq identityCreateProto = IdentityCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		IdentityCreateParam identityParam = IdentityCreateParam.builder().ins_code(identityCreateProto.getInsCode())
				.mem_id(userId).identity_type(identityCreateProto.getSelectIdentityType()).build();

		int result = memberMapper.insertIdentity(identityParam);

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityCreateRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	
	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addAvartar(RequestPacket packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarCreateReq avartarCreateReqProto = IdentityAvatarCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		AvatarCreateParam avatarParam = AvatarCreateParam.builder().mem_id(userId)
				.ins_code(avartarCreateReqProto.getInsCode()).identity_type(avartarCreateReqProto.getIdentityType())
				.mea_avatar_id(avartarCreateReqProto.getAvatarId()).build();

		int result = memberMapper.insertAvartar(avatarParam);
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarCreateRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());	
	}

	
	public BinaryMessage findAvartarByMemberId(RequestPacket packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarDetailReq identityAvatarDetailReqProto = IdentityAvatarDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		
		AvatarDetailParam identityAvatarDetailParam = AvatarDetailParam.builder().ins_code(identityAvatarDetailReqProto.getInsCode())
				.identity_type(identityAvatarDetailReqProto.getIdentityType()).mem_id(userId).build();
		
		AvatarDetailDto identityAvatarDetailDto = memberMapper.selectAvartarByMemberId(identityAvatarDetailParam);

		IdentityAvatarDetailRes.Builder IdentityAvatarDetailResBuilder = IdentityAvatarDetailRes.newBuilder();

		if(identityAvatarDetailDto != null) {
			CommonUtil.nullSafeSet(identityAvatarDetailDto.getIns_code(), IdentityAvatarDetailResBuilder::setInsCode);
			CommonUtil.nullSafeSet(identityAvatarDetailDto.getIdentity_type(), IdentityAvatarDetailResBuilder::setIdentityType);
			CommonUtil.nullSafeSet(identityAvatarDetailDto.getMea_avatar_id(), IdentityAvatarDetailResBuilder::setAvatarId);	
		}
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(identityAvatarDetailDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(identityAvatarDetailDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarDetailResBuilder.build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	
	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage modifyAvartarByMemberId(RequestPacket packetReqProto, String userId)
			throws InvalidProtocolBufferException {
		
		IdentityAvatarChangeReq identityAvatarChangeReqProto = IdentityAvatarChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		AvatarChangeParam avatarDetailParam = AvatarChangeParam.builder().mea_avatar_id(identityAvatarChangeReqProto.getAvatarId()).mem_id(userId).ins_code(identityAvatarChangeReqProto.getInsCode())
				.identity_type(identityAvatarChangeReqProto.getIdentityType()).build();
		
		int result = memberMapper.updateAvartarByMemberId(avatarDetailParam);
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarChangeRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	
	public BinaryMessage findInstitutionInfoByInsCode(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		IdentityInstitutionInfoReq identityInstitutionInfoReq = IdentityInstitutionInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionInfoParam institutionInfoParam = InstitutionInfoParam.builder().ins_code(identityInstitutionInfoReq.getInsCode()).ins_invite_url(identityInstitutionInfoReq.getInsInviteUrl()).build();
		
		InstitutionInfoDto identityInstitutionInfoDto  = memberMapper.selectInstitutionInfoByInsCode(institutionInfoParam);
		
		IdentityInstitutionInfoRes.Builder IdentityInstitutionInfoResBuilder = IdentityInstitutionInfoRes.newBuilder();
		
		if(identityInstitutionInfoDto != null) {
			CommonUtil.nullSafeSet(identityInstitutionInfoDto.getIns_code(), IdentityInstitutionInfoResBuilder::setInsCode);
			CommonUtil.nullSafeSet(identityInstitutionInfoDto.getInsName(), IdentityInstitutionInfoResBuilder::setInsName);
			CommonUtil.nullSafeSet(identityInstitutionInfoDto.getInsLogoImg(), IdentityInstitutionInfoResBuilder::setInsLogoImg);	
		}
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(identityInstitutionInfoDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
					.setResultMessage(identityInstitutionInfoDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
					.setData(IdentityInstitutionInfoResBuilder.build().toByteString())
					.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	
	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addInstitutionEnrollment(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		IdentityInstitutionEnrollmentRequestReq identityInstitutionEnrollmentRequestReq = IdentityInstitutionEnrollmentRequestReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestParam institutionEnrollmentRequestParam = InstitutionEnrollmentRequestParam.builder().ins_code(identityInstitutionEnrollmentRequestReq.getInsCode()).mem_id(userId).build();
		
		int result = memberMapper.insertInstitutionEnrollmentRequest(institutionEnrollmentRequestParam);
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityInstitutionEnrollmentRequestRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

}
