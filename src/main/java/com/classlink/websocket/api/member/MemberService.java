package com.classlink.websocket.api.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.domain.Packet.PacketData;
import com.classlink.websocket.api.member.domain.dto.proto.MemberIdentity.MemberIdentityData;
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
		MemberIdentityData deserialized = MemberIdentityData.newBuilder().mergeFrom(param.getData()).build();

		log.info("MdtIdx ? =" + deserialized.getMdtIdx());
		log.info("IdtCode ? =" + deserialized.getIdtCode());
		log.info("MemIdx ? =" + deserialized.getMemIdx());
		log.info("DeleteYn ? =" + deserialized.getDeleteYn());
		log.info("toByteArray ? =" + deserialized.toByteArray().toString());
		
		log.info("result : " + memberMapper.selectMemberIdentityByIdMemberIdx(deserialized.getMemIdx(), deserialized.getIdtCode()));
		List<IdentityVo> identityVo = memberMapper.selectMemberIdentityByIdMemberIdx(deserialized.getMemIdx(), deserialized.getIdtCode());
//		log.info("DeleteYn ? =" + memberIdentityVO.getDelete_yn());
		
//		MemberIdentityData memberIdentityData = MemberIdentityData.newBuilder().setDeleteYn(memberIdentityVO.getDelete_yn()).build();
		PacketData result = PacketData.newBuilder().setOpCode(101).setAccessToken(param.getAccessToken()).setInstanceId(param.getInstanceId()).build();

		return new BinaryMessage(result.toByteArray());
	}

}
