package com.classlink.websocket.api.lobby.home;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData;
import com.classlink.websocket.api.common.domain.proto.PacketDataProto.PacketData.Builder;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequestListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequesterInfoDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequestListResProto.LobbyHomeEnrollmentRequestListRes;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequestListResProto.LobbyHomeEnrollmentRequestListRes.LobbyHomeEnrollmentRequest;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestConfirmParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestListParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequesterInfoParam;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestListReqProto.LobbyHomeEnrollmentRequestListReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequesterInfoReqProto.LobbyHomeEnrollmentRequesterInfoReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList.SWclassMyInstitution;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarChangeResProto.IdentityAvatarChangeRes;
import com.google.protobuf.ByteString;
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
		
		List<InstitutionEnrollmentRequestListDto> institutionEnrollmentRequestDtoList = lobbyHomeMapper.selectInstitutionEnrollmentsByInsCode(institutionEnrollmentRequestListParam);
		
		Builder packetResProtoBuilder = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage());
			
		List<LobbyHomeEnrollmentRequest> lobbyHomeEnrollmentRequestResList = institutionEnrollmentRequestDtoList.isEmpty() ? new ArrayList<>() : institutionEnrollmentRequestDtoList.stream().map(institutionEnrollmentRequestDto -> {

			return LobbyHomeEnrollmentRequest.newBuilder().setMemId(institutionEnrollmentRequestDto.getMem_id())
					.setMemImg(institutionEnrollmentRequestDto.getMem_img()).setMemName(institutionEnrollmentRequestDto.getMem_name())
					.setItmRegistrationDate(institutionEnrollmentRequestDto.getItm_registration_date())
					.setItmViewYn(institutionEnrollmentRequestDto.getItm_view_yn()).build();

		}).collect(Collectors.toList());
		
		packetResProtoBuilder.setData(lobbyHomeEnrollmentRequestResList.isEmpty() ? ByteString.EMPTY : LobbyHomeEnrollmentRequestListRes.newBuilder().addAllLobbyHomeEnrollmentRequestList(lobbyHomeEnrollmentRequestResList).build().toByteString());
	
		return new BinaryMessage(packetResProtoBuilder.build().toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage modifyInstitutionEnrollmentViewStatus(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequestConfirmReq lobbyHomeEnrollmentRequestConfirmReq = LobbyHomeEnrollmentRequestConfirmReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestConfirmParam lobbyHomeEnrollmentRequestConfirmParam = InstitutionEnrollmentRequestConfirmParam.builder().ins_code(lobbyHomeEnrollmentRequestConfirmReq.getInsCode())
		.mem_id(lobbyHomeEnrollmentRequestConfirmReq.getMemId()).build();
		
		int result = lobbyHomeMapper.updateInstitutionEnrollmentViewStatus(lobbyHomeEnrollmentRequestConfirmParam);
		
		PacketData packetResProto = PacketData.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(result == 0 ? ByteString.EMPTY : IdentityAvatarChangeRes.newBuilder().build().toByteString())
				.build();
	
		return new BinaryMessage(packetResProto.toByteArray());
	}
	
	public BinaryMessage findInstitutionEnrollmentRequesterInfo(PacketData packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequesterInfoReq lobbyHomeEnrollmentRequesterInfoReq = LobbyHomeEnrollmentRequesterInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequesterInfoParam lobbyHomeEnrollmentRequesterInfoParam = InstitutionEnrollmentRequesterInfoParam.builder().ins_code(lobbyHomeEnrollmentRequesterInfoReq.getInsCode()).mem_id(lobbyHomeEnrollmentRequesterInfoReq.getMemId()).build();
		
		List<InstitutionEnrollmentRequesterInfoDto> institutionEnrollmentRequesterInfoDto = lobbyHomeMapper.selectInstitutionEnrollmentRequesterInfo(lobbyHomeEnrollmentRequesterInfoParam);
		
		return null;
	}

	@Transactional(rollbackFor = {Exception.class})
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
