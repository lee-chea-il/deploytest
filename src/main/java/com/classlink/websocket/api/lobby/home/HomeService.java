package com.classlink.websocket.api.lobby.home;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.domain.proto.Packet.PacketData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService {

	private final HomeMapper homeMapper;
	
	public BinaryMessage findMyInstitutionByMemId(PacketData packetReqProto, String userId) {
		
//		List<MyInstitutionListDto> myInstitutionListDtos = homeMapper.selectMyInstitutionByMemId(userId);
		
		return null;
	}
	
}
