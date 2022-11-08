package com.classlink.websocket.api.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.Packet.CwclassPacket;
import com.classlink.websocket.api.member.domain.dto.proto.MemberIdentityList.CwclassMemberIdentityList;
import com.classlink.websocket.api.member.domain.vo.MemberVo.IdentityVo;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;
	
	public BinaryMessage findMemberIdentityByMemberIdx(CwclassPacket param) throws InvalidProtocolBufferException {
		
		List<IdentityVo> identityVo = memberMapper.findMemberIdentityByMemberIdx(7);
		List<String> Idt_names = identityVo.stream().map(field -> field.getIdt_name()).collect(Collectors.toList());
		
		for(IdentityVo idtVo : identityVo) {
			log.info("result : " + idtVo.getIdt_name());
		}
		
		CwclassMemberIdentityList memberIdentityListData = CwclassMemberIdentityList.newBuilder().setResultCode(200).setMessage("신분조회 성공했습니다.").addAllIdtName(Idt_names).build();
		CwclassPacket result = CwclassPacket.newBuilder().setOpCode(101).setAccessToken(param.getAccessToken()).setInstanceId(param.getInstanceId()).setData(memberIdentityListData.toByteString()).build();

		return new BinaryMessage(result.toByteArray());
	}

//	public BinaryMessage addMemberIdentity(CwclassPacket packet) {
//		
//		
//		
//		return null;
//	}

}
