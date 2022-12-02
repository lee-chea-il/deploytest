package com.classlink.websocket.api.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
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
import com.classlink.websocket.api.util.CommonUtil;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public BinaryMessage findMemberIdentitiesByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityListReq identityListReqProto = IdentityListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		IdentityListParam identityListParam = IdentityListParam.builder().ins_code(identityListReqProto.getInsCode())
				.mem_id(userId).build();

		List<IdentityListDto> identityDto = memberMapper.selectMemberIdentitiesByMemberId(identityListParam);

		PacketData packetResProto;
		
		if (identityDto.isEmpty()) {

			System.out.println("identityDto == null && identityDto.isEmpty() 실행!!");
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.NOT_FOUND.getCode()).setResultMessage(ResultCode.NOT_FOUND.getMessage())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}

		System.out.println("identityDto : " + identityDto.toString());
		List<Identity> identities = new ArrayList<>();

		System.out.println("identityDto != null!!");
		identityDto.stream().forEach(idtDto -> {

			Identity identity = Identity.newBuilder().setInsCode(idtDto.getIns_code())
					.setIdentitytType(idtDto.getIdentity_type()).setAvartarId(idtDto.getMea_avatar_id()).build();
			identities.add(identity);

			log.info("result : " + idtDto.getMea_avatar_id());

		});

		IdentityListRes identityListProto = IdentityListRes.newBuilder().addAllIdtList(identities).build();

		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setData(identityListProto.toByteString()).build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage addMemberIdentity(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityCreateReq identityCreateProto = IdentityCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		IdentityCreateParam identityParam = IdentityCreateParam.builder().ins_code(identityCreateProto.getInsCode())
				.mem_id(userId).identity_type(identityCreateProto.getIdentityType()).build();

		int result = memberMapper.insertMemberIdentity(identityParam);

		PacketData packetResProto;

		if (result == 0) {

			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.ADD_FAIL.getCode()).setResultMessage(ResultCode.ADD_FAIL.getMessage()).build();

			return new BinaryMessage(packetResProto.toByteArray());
		}

		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(IdentityCreateRes.newBuilder().build().toByteString()).build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage addIdentityAvartar(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarCreateReq avartarCreateReqProto = IdentityAvatarCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
				.build();
		AvatarCreateParam avatarParam = AvatarCreateParam.builder().mem_id(userId)
				.ins_code(avartarCreateReqProto.getInsCode()).identity_type(avartarCreateReqProto.getIdentityType())
				.mea_avatar_id(avartarCreateReqProto.getAvatarId()).build();

		int result = memberMapper.insertMemberAvartar(avatarParam);
		
		PacketData packetResProto;

		if (result == 0) {
			
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
					.setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.ADD_FAIL.getCode()).setResultMessage(ResultCode.ADD_FAIL.getMessage()).build();

			return new BinaryMessage(packetResProto.toByteArray());
		}

		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarCreateRes.newBuilder().build().toByteString()).build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findIdentityAvartarByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		IdentityAvatarDetailReq identityAvatarDetailReqProto = IdentityAvatarDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		CommonUtil.checkIfProtoParamAvailable(identityAvatarDetailReqProto);
		
		AvatarDetailParam identityAvatarDetailParam = AvatarDetailParam.builder().ins_code(identityAvatarDetailReqProto.getInsCode())
				.identity_type(identityAvatarDetailReqProto.getIdentityType()).mem_id(userId).build();
		
		AvatarDetailDto identityAvatarDetailDto = memberMapper.selectIdentityAvartarByMemberId(identityAvatarDetailParam);

		PacketData packetResProto;

		if (identityAvatarDetailDto == null) {
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.NOT_FOUND.getCode()).setResultMessage(ResultCode.NOT_FOUND.getMessage())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}

		IdentityAvatarDetailRes identityAvatarDetailResProto = IdentityAvatarDetailRes.newBuilder().setInsCode(identityAvatarDetailDto.getIns_code())
				.setIdentityType(identityAvatarDetailDto.getIdentity_type()).setAvatarId(identityAvatarDetailDto.getMea_avatar_id())
				.build();
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(identityAvatarDetailResProto.toByteString()).build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage modifyIdentityAvartarByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {
		
		IdentityAvatarChangeReq identityAvatarChangeReqProto = IdentityAvatarChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		AvatarChangeParam avatarDetailParam = AvatarChangeParam.builder().mea_avatar_id(identityAvatarChangeReqProto.getAvatarId()).mem_id(userId).ins_code(identityAvatarChangeReqProto.getInsCode())
				.identity_type(identityAvatarChangeReqProto.getIdentityType()).build();
		
		int result = memberMapper.updateIdentityAvartarByMemberId(avatarDetailParam);
		
		PacketData packetResProto;
		
		if(result == 0) {
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.MODIFY_FAIL.getCode()).setResultMessage(ResultCode.MODIFY_FAIL.getMessage())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarChangeRes.newBuilder().build().toByteString()).build();
		
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

	public BinaryMessage addInstitutionEnrollment(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		IdentityInstitutionEnrollmentRequestReq identityInstitutionEnrollmentRequestReq = IdentityInstitutionEnrollmentRequestReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestParam institutionEnrollmentRequestParam = InstitutionEnrollmentRequestParam.builder().ins_code(identityInstitutionEnrollmentRequestReq.getInsCode()).mem_id(userId).build();
		
		int result = memberMapper.insertInstitutionEnrollmentRequest(institutionEnrollmentRequestParam);
		
		PacketData packetResProto;
		
		if (result == 0) {

			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
					.setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.ADD_FAIL.getCode()).setResultMessage(ResultCode.ADD_FAIL.getMessage())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(IdentityInstitutionEnrollmentRequestRes.newBuilder().build().toByteString()).build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

}
