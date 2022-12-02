package com.classlink.websocket.api.lobby.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequestListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestListParam;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestListReqProto.LobbyHomeEnrollmentRequestListReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList.SWclassMyInstitution;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyHomeService {

	private final LobbyHomeMapper lobbyHomeMapper;
	
	public BinaryMessage findInstitutionEnrollmentsByInsCode(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequestListReq lobbyHomeEnrollmentRequestListReq = LobbyHomeEnrollmentRequestListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam = InstitutionEnrollmentRequestListParam.builder().ins_code(lobbyHomeEnrollmentRequestListReq.getInsCode()).build();
		
		List<InstitutionEnrollmentRequestListDto> institutionEnrollmentRequestListDtos = lobbyHomeMapper.selectInstitutionEnrollmentsByInsCode(institutionEnrollmentRequestListParam);
		
		PacketData packetResProto;
		
//		if(institutionEnrollmentRequestListDtos institutionEnrollmentRequestListDtos.isEmpty()) {
//			
//		}
		
		return null;
	}

	public BinaryMessage modifyInstitutionEnrollmentViewStatus(PacketData packetReqProto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BinaryMessage findInstitutionEnrollmentRequestorInfo(PacketData packetReqProto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public BinaryMessage modifyInstitutionEnrollmentRequestStatus(PacketData packetReqProto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BinaryMessage findMyInstitutionByMemId(PacketData packetReqProto, String userId) {
		
		log.info("findMyInstitutionByMemId 함수 실행!");
		List<MyInstitutionListDto> myInstitutionListDtos = lobbyHomeMapper.selectMyInstitutionByMemId(userId);
		
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
