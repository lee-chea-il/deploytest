package com.classlink.websocket.api.lobby.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.lobby.home.domain.dto.InstitutionDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList.SWclassMyInstitution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService {

	private final HomeMapper homeMapper;
	
	public BinaryMessage findMyInstitutionByMemId(PacketData packetReqProto, String userId) {
		
		log.info("findMyInstitutionByMemId 함수 실행!");
		List<MyInstitutionListDto> myInstitutionListDtos = homeMapper.selectMyInstitutionByMemId(userId);
		
		PacketData packetResProto;
		
		if(myInstitutionListDtos.isEmpty()) {
			
			packetResProto = PacketData.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
			
		}else {
			List<SWclassMyInstitution> subMyInstitutionList = new ArrayList<>() ;
			
			myInstitutionListDtos.stream().forEach(MyInstitutionListDto -> {
				log.info("findMyInstitutionByMemId 함수 실행!");
				SWclassMyInstitution myInstitution = SWclassMyInstitution.newBuilder().setInsName(MyInstitutionListDto.getIns_name()).setStdUseYn(MyInstitutionListDto.getStd_use_yn()).build();
				subMyInstitutionList.add(myInstitution);
				
			});
			
			SWclassMyInstitutionList myInstitutionList  = SWclassMyInstitutionList.newBuilder().addAllSwclassMyInstitution(subMyInstitutionList).build();
			
			packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).setData(myInstitutionList.toByteString()).build();
		}
				
		
		return new BinaryMessage(packetResProto.toByteArray());
	}
	
}
