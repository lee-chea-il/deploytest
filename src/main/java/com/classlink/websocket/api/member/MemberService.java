package com.classlink.websocket.api.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.Packet.CWclassPacket;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityList.CWclassIdentityList;
import com.classlink.websocket.api.member.domain.param.MemberParam.MemberIdentityParam;
import com.classlink.websocket.api.member.domain.param.proto.IdentityCreate.CWclassIdentityCreate;
import com.classlink.websocket.api.member.domain.vo.MemberVo.IdentityVo;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;
	
	public BinaryMessage findMemberIdentityByMemberIdx(CWclassPacket packetReqProto) throws InvalidProtocolBufferException {
		
		List<IdentityVo> identityVo = memberMapper.selectMemberIdentityByMemberIdx(7);
		
		int opCode = 101;
		
		CWclassPacket PacketResProto;
		
		if(identityVo.isEmpty()) {
			
			opCode = 404;
			
			PacketResProto = CWclassPacket.newBuilder().setOpCode(opCode).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
			
		}else {
			identityVo.stream().forEach(idtVo -> log.info("result : " + idtVo.getIdt_name()));
			
			List<String> IdtNames = identityVo.stream().map(field -> field.getIdt_name()).collect(Collectors.toList());	
			
			CWclassIdentityList memberIdentityListProto = CWclassIdentityList.newBuilder().addAllIdtNames(IdtNames).build();
			
			PacketResProto = CWclassPacket.newBuilder().setOpCode(opCode).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).setData(memberIdentityListProto.toByteString()).build();
		}
		

		return new BinaryMessage(PacketResProto.toByteArray());
	}

	public BinaryMessage addMemberIdentity(CWclassPacket packetReqProto) throws InvalidProtocolBufferException {
		
		CWclassIdentityCreate identityCreateProto = CWclassIdentityCreate.newBuilder().mergeFrom(packetReqProto.getData()).build(); 
		MemberIdentityParam memberIdentityParam = MemberIdentityParam.builder().idt_code(identityCreateProto.getIdtCode()).mem_idx(identityCreateProto.getMemIdx()).build();
		
		memberMapper.insertMemberIdentity(memberIdentityParam);
		
		int opCode = 101;
		
		if(memberIdentityParam.getMdt_idx() == 0) {
			opCode = 500;
		}
		
		CWclassPacket PacketResProto = CWclassPacket.newBuilder().setOpCode(opCode).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
		
		return new BinaryMessage(PacketResProto.toByteArray());
	}

}
