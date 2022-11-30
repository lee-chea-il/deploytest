package com.classlink.websocket.api.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.member.domain.dto.MemberDto.IdentityAvatarDetailDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.IdentityListDto;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarChangeResProto.IdentityAvatarChangeRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarCreateResProto.IdentityAvatarCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarDetailResProto.IdentityAvatarDetailRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityCreateResProto.IdentityCreateRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityListResProto.IdentityListRes;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityListResProto.IdentityListRes.Identity;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarChangeParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarDetailParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityListParam;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarChangeReqProto.IdentityAvatarChangeReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarCreateReqProto.IdentityAvatarCreateReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityAvatarDetailReqProto.IdentityAvatarDetailReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityCreateReqProto.IdentityCreateReq;
import com.classlink.websocket.api.member.domain.param.proto.IdentityListReqProto.IdentityListReq;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public BinaryMessage findMemberIdentityByMemberId(PacketData packetReqProto, String userId)
			throws InvalidProtocolBufferException {

		log.info("userId : " + userId);
		IdentityListReq identityListReqProto = IdentityListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		IdentityListParam identityListParam = IdentityListParam.builder().ins_code(identityListReqProto.getInsCode())
				.mem_id(userId).build();

		List<IdentityListDto> identityDto = memberMapper.selectMemberIdentityByMemberId(identityListParam);

		PacketData packetResProto;

		if (identityDto.isEmpty()) {

			packetResProto = PacketData.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}

		List<Identity> identities = new ArrayList<>();

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

		memberMapper.insertMemberIdentity(identityParam);

		PacketData packetResProto;

		if (identityParam.getMdt_idx() == 0) {

			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.setResultCode(ResultCode.ADD_FAIL.getCode()).build();

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
		IdentityAvatarCreateParam identityAvatarParam = IdentityAvatarCreateParam.builder().mem_id(userId)
				.ins_code(avartarCreateReqProto.getInsCode()).identity_type(avartarCreateReqProto.getIdentityType())
				.mea_avatar_id(avartarCreateReqProto.getAvatarId()).build();

		memberMapper.insertMemberAvartar(identityAvatarParam);

		PacketData packetResProto;

		int opCode = packetReqProto.getOpCode();

		if (identityAvatarParam.getMea_idx() == 0) {
			opCode = ResultCode.ADD_FAIL.getCode();

			packetResProto = PacketData.newBuilder().setOpCode(opCode).setAccessToken(packetReqProto.getAccessToken())
					.setInstanceId(packetReqProto.getInstanceId()).build();

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
		IdentityAvatarDetailParam identityAvatarDetailParam = IdentityAvatarDetailParam.builder().ins_code(identityAvatarDetailReqProto.getInsCode())
				.identity_type(identityAvatarDetailReqProto.getIdentityType()).mem_id(userId).build();

		IdentityAvatarDetailDto identityAvatarDetailDto = memberMapper.selectIdentityAvartarByMemberId(identityAvatarDetailParam);

		PacketData packetResProto;

		if (identityAvatarDetailDto == null) {
			packetResProto = PacketData.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
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
		IdentityAvatarChangeParam identityAvatarDetailParam = IdentityAvatarChangeParam.builder().mea_avatar_id(identityAvatarChangeReqProto.getAvatarId()).mem_id(userId).ins_code(identityAvatarChangeReqProto.getInsCode())
				.identity_type(identityAvatarChangeReqProto.getIdentityType()).build();
		
		int result = memberMapper.updateIdentityAvartarByMemberId(identityAvatarDetailParam);
		
		PacketData packetResProto;
		
		if(result == 0) {
			packetResProto = PacketData.newBuilder().setOpCode(ResultCode.MODIFY_FAIL.getCode())
					.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
					.build();

			return new BinaryMessage(packetResProto.toByteArray());
		}
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode()).setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarChangeRes.newBuilder().build().toByteString()).build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}
	
	

}
