package com.classlink.websocket.api.lobby.home;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList.SWclassMyInstitution;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyHomeService {
	
	private final LobbyHomeMapper lobbyHomeMapper;

	public BinaryMessage findMyInstitutionByMemId(RequestPacket packetReqProto, String userId) {
		
		log.info("findMyInstitutionByMemId 함수 실행!");
		List<MyInstitutionListDto> myInstitutionListDtos = lobbyHomeMapper.selectMyInstitutionByMemId(userId);
		
		ResponsePacket packetResProto;
		
		if(myInstitutionListDtos.isEmpty()) {
			
			packetResProto = ResponsePacket.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
			
		}else {
			List<SWclassMyInstitution> subMyInstitutionList = new ArrayList<>() ;
			
			myInstitutionListDtos.forEach(MyInstitutionListDto -> {
				log.info("findMyInstitutionByMemId 함수 실행!");
				SWclassMyInstitution myInstitution = SWclassMyInstitution.newBuilder().setInsName(MyInstitutionListDto.getIns_name()).setStdUseYn(MyInstitutionListDto.getStd_use_yn()).build();
				subMyInstitutionList.add(myInstitution);
				
			});
			
			SWclassMyInstitutionList myInstitutionList  = SWclassMyInstitutionList.newBuilder().addAllSwclassMyInstitution(subMyInstitutionList).build();
			
			packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).setData(myInstitutionList.toByteString()).build();
		}
		
		return new BinaryMessage(packetResProto.toByteArray());
	}
	
}
