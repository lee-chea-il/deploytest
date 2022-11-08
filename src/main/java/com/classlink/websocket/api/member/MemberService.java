package com.classlink.websocket.api.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.Packet.PacketData;
import com.classlink.websocket.api.member.domain.dto.proto.Identity.IdentityData;
import com.classlink.websocket.api.member.domain.vo.MemberVo.IdentityVo;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	public BinaryMessage findMemberIdentityByIdMemberIdx(PacketData param) throws InvalidProtocolBufferException {

		// data 부분 역직렬화
//		MemberIdentityData deserialized = MemberIdentityData.newBuilder().mergeFrom(param.getData()).build();
//
//		log.info("MdtIdx ? =" + deserialized.getMdtIdx());
//		log.info("IdtCode ? =" + deserialized.getIdtCode());
//		log.info("MemIdx ? =" + deserialized.getMemIdx());
//		log.info("DeleteYn ? =" + deserialized.getDeleteYn());
//		log.info("toByteArray ? =" + deserialized.toByteArray().toString());
		
		List<IdentityVo> identityVo = memberMapper.selectMemberIdentityByIdMemberIdx(7);
		List<String> Idt_names = identityVo.stream().map(field -> field.getIdt_name()).collect(Collectors.toList());
		
		for(IdentityVo idtVo : identityVo) {
			log.info("result : " + idtVo.getIdt_name());
		}
//		log.info("DeleteYn ? =" + memberIdentityVO.getDelete_yn());
		
		IdentityData memberIdentityData = IdentityData.newBuilder().setResultCode(200).setMessage("신분조회 성공했습니다.").addAllIdtName(Idt_names).build();
		PacketData result = PacketData.newBuilder().setOpCode(101).setAccessToken(param.getAccessToken()).setInstanceId(param.getInstanceId()).setData(memberIdentityData.toByteString()).build();

		return new BinaryMessage(result.toByteArray());
	}

}
