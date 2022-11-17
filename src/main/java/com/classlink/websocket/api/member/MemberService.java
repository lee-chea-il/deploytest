package com.classlink.websocket.api.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.domain.proto.Packet.PacketData;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityList.SWclassIdentityList;
import com.classlink.websocket.api.member.domain.param.MemberParam.MemberIdentityParam;
import com.classlink.websocket.api.member.domain.param.proto.IdentityCreate.SWclassIdentityCreate;
import com.classlink.websocket.api.member.domain.vo.MemberVo.IdentityVo;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;
	
	public BinaryMessage findMemberIdentityByMemberIdx(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		log.info("userId : " + userId);
		List<IdentityVo> identityVo = memberMapper.selectMemberIdentityByMemberIdx(userId);
		
		PacketData packetResProto;
		
		if(identityVo.isEmpty()) {
			
			packetResProto = PacketData.newBuilder().setOpCode(OpCode.NOT_FOUND.getValue()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
			
			return new BinaryMessage(packetResProto.toByteArray());
		}
		
		identityVo.stream().forEach(idtVo -> log.info("result : " + idtVo.getIdt_name()));
		
		List<String> IdtNames = identityVo.stream().map(field -> field.getIdt_name()).collect(Collectors.toList());	
		
		SWclassIdentityList memberIdentityListProto = SWclassIdentityList.newBuilder().addAllIdtNames(IdtNames).build();
		
		packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).setData(memberIdentityListProto.toByteString()).build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage addMemberIdentity(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		SWclassIdentityCreate identityCreateProto = SWclassIdentityCreate.newBuilder().mergeFrom(packetReqProto.getData()).build(); 
		MemberIdentityParam memberIdentityParam = MemberIdentityParam.builder().idt_code(identityCreateProto.getIdtCode()).mem_id(userId).build();
		
		memberMapper.insertMemberIdentity(memberIdentityParam);
		
		int opCode = memberIdentityParam.getMdt_idx() == 0 ? OpCode.ADD_FAIL.getValue() : packetReqProto.getOpCode();
		
		PacketData PacketResProto = PacketData.newBuilder()
				.setOpCode(opCode).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
		
		return new BinaryMessage(PacketResProto.toByteArray());
	}

}
