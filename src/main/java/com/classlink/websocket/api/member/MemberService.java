package com.classlink.websocket.api.member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData.Builder;
import com.classlink.websocket.api.member.domain.dto.MemberDto.AvatarDetailDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.IdentityListDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.InstitutionInfoDto;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarChangeResProto.IdentityAvatarChangeRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarCreateResProto.IdentityAvatarCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarDetailResProto.IdentityAvatarDetailRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityCreateResProto.IdentityCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityInstitutionEnrollmentRequestResProto.IdentityInstitutionEnrollmentRequestRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityInstitutionInfoResProto.IdentityInstitutionInfoRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityListResProto.IdentityListRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityListResProto.IdentityListRes.Identity;
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
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public BinaryMessage findIdentitiesByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityListReq identityListReqProto = IdentityListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		IdentityListParam identityListParam = IdentityListParam.builder().ins_code(identityListReqProto.getInsCode())
				.mem_id(userId).build();

		List<IdentityListDto> identityDtoList = memberMapper.selectIdentitiesByMemberId(identityListParam);
		
		Builder packetResProtoBuilder = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage());
		
		List<Identity> identities = identityDtoList.isEmpty() ? new ArrayList<>() : identityDtoList.stream().map(idtDto -> {

			return Identity.newBuilder().setInsCode(idtDto.getIns_code())
					.setIdentitytType(idtDto.getIdentity_type()).setAvartarId(idtDto.getMea_avatar_id()).build();

		}).collect(Collectors.toList());

		packetResProtoBuilder.setData(identities.isEmpty() ? ByteString.EMPTY : IdentityListRes.newBuilder().addAllIdtList(identities).build().toByteString());

		return new BinaryMessage(packetResProtoBuilder.build().toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addIdentity(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityCreateReq identityCreateProto = IdentityCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		IdentityCreateParam identityParam = IdentityCreateParam.builder().ins_code(identityCreateProto.getInsCode())
				.mem_id(userId).identity_type(identityCreateProto.getIdentityType()).build();

		int result = memberMapper.insertIdentity(identityParam);

		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(result == 0 ? ByteString.EMPTY : IdentityCreateRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addAvartar(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarCreateReq avartarCreateReqProto = IdentityAvatarCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		AvatarCreateParam avatarParam = AvatarCreateParam.builder().mem_id(userId)
				.ins_code(avartarCreateReqProto.getInsCode()).identity_type(avartarCreateReqProto.getIdentityType())
				.mea_avatar_id(avartarCreateReqProto.getAvatarId()).build();

		int result = memberMapper.insertAvartar(avatarParam);
		
		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(result == 0 ? ByteString.EMPTY : IdentityAvatarCreateRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());	
	}

	public BinaryMessage findAvartarByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarDetailReq identityAvatarDetailReqProto = IdentityAvatarDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		
		AvatarDetailParam identityAvatarDetailParam = AvatarDetailParam.builder().ins_code(identityAvatarDetailReqProto.getInsCode())
				.identity_type(identityAvatarDetailReqProto.getIdentityType()).mem_id(userId).build();
		
		AvatarDetailDto identityAvatarDetailDto = memberMapper.selectAvartarByMemberId(identityAvatarDetailParam);

		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(identityAvatarDetailDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(identityAvatarDetailDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(identityAvatarDetailDto == null ? ByteString.EMPTY : 
					IdentityAvatarDetailRes.newBuilder().setInsCode(identityAvatarDetailDto.getIns_code())
						.setIdentityType(identityAvatarDetailDto.getIdentity_type()).setAvatarId(identityAvatarDetailDto.getMea_avatar_id())
						.build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage modifyAvartarByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {
		
		IdentityAvatarChangeReq identityAvatarChangeReqProto = IdentityAvatarChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		AvatarChangeParam avatarDetailParam = AvatarChangeParam.builder().mea_avatar_id(identityAvatarChangeReqProto.getAvatarId()).mem_id(userId).ins_code(identityAvatarChangeReqProto.getInsCode())
				.identity_type(identityAvatarChangeReqProto.getIdentityType()).build();
		
		int result = memberMapper.updateAvartarByMemberId(avatarDetailParam);
		
		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(result == 0 ? ByteString.EMPTY : IdentityAvatarChangeRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findInstitutionInfoByInsCode(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		IdentityInstitutionInfoReq identityInstitutionInfoReq = IdentityInstitutionInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionInfoParam institutionInfoParam = InstitutionInfoParam.builder().ins_code(identityInstitutionInfoReq.getInsCode()).ins_invite_url(identityInstitutionInfoReq.getInsInviteUrl()).build();
		
		InstitutionInfoDto identityInstitutionInfoDto  = memberMapper.selectInstitutionInfoByInsCode(institutionInfoParam);
		
		PacketData packetResProto;
		
		if (identityInstitutionInfoDto == null) {
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.NOT_FOUND.getCode()).setResultMessage(ResultCode.NOT_FOUND.getMessage())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}
		
		IdentityInstitutionInfoRes identityInstitutionInfoRes = IdentityInstitutionInfoRes.newBuilder()
				.setInsCode(identityInstitutionInfoDto.getIns_code())
				.setInsName(identityInstitutionInfoDto.getInsName())
				.setInsLogoImg(identityInstitutionInfoDto.getInsLogoImg())
				.build();
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(identityInstitutionInfoRes.toByteString()).build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage addInstitutionEnrollment(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		IdentityInstitutionEnrollmentRequestReq identityInstitutionEnrollmentRequestReq = IdentityInstitutionEnrollmentRequestReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestParam institutionEnrollmentRequestParam = InstitutionEnrollmentRequestParam.builder().ins_code(identityInstitutionEnrollmentRequestReq.getInsCode()).mem_id(userId).build();
		
		int result = memberMapper.insertInstitutionEnrollmentRequest(institutionEnrollmentRequestParam);
		
		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(result == 0 ? ByteString.EMPTY : IdentityInstitutionEnrollmentRequestRes.newBuilder().build().toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

}
