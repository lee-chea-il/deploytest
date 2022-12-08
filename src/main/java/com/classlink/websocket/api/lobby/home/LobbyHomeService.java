package com.classlink.websocket.api.lobby.home;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequestListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequesterInfoDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequestListResProto.LobbyHomeEnrollmentRequestListRes;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequestListResProto.LobbyHomeEnrollmentRequestListRes.LobbyHomeEnrollmentRequest;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequesterInfoResProto.LobbyHomeEnrollmentRequesterInfoRes;
import com.classlink.websocket.api.lobby.home.domain.dto.proto.LobbyHomeEnrollmentRequesterInfoResProto.LobbyHomeEnrollmentRequesterInfoRes.Builder;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestConfirmParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestListParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequesterInfoParam;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestConfirmReqProto.LobbyHomeEnrollmentRequestConfirmReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequestListReqProto.LobbyHomeEnrollmentRequestListReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.LobbyHomeEnrollmentRequesterInfoReqProto.LobbyHomeEnrollmentRequesterInfoReq;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList;
import com.classlink.websocket.api.lobby.home.domain.param.proto.MyInstitutionList.SWclassMyInstitutionList.SWclassMyInstitution;
import com.classlink.websocket.api.member.domain.dto.proto.IdentityAvatarChangeResProto.IdentityAvatarChangeRes;
import com.classlink.websocket.api.util.CommonUtil;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyHomeService {
	
	private final LobbyHomeMapper lobbyHomeMapper;
	
	public BinaryMessage findInstitutionEnrollmentsByInsCode(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequestListReq lobbyHomeEnrollmentRequestListReq = LobbyHomeEnrollmentRequestListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam = InstitutionEnrollmentRequestListParam.builder().ins_code(lobbyHomeEnrollmentRequestListReq.getInsCode()).build();
		
		List<InstitutionEnrollmentRequestListDto> institutionEnrollmentRequestDtoList = lobbyHomeMapper.selectInstitutionEnrollmentsByInsCode(institutionEnrollmentRequestListParam);
		
		List<LobbyHomeEnrollmentRequest> LobbyHomeEnrollmentRequestList = null;
		
		if(!institutionEnrollmentRequestDtoList.isEmpty()) {
			LobbyHomeEnrollmentRequestList = institutionEnrollmentRequestDtoList.stream().map(institutionEnrollmentRequestDto -> {

	    		LobbyHomeEnrollmentRequest.Builder LobbyHomeEnrollmentRequestBuilder = LobbyHomeEnrollmentRequest.newBuilder();
	    		
	    		CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getMem_id(), LobbyHomeEnrollmentRequestBuilder::setMemId);
	    		CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getMem_img(), LobbyHomeEnrollmentRequestBuilder::setMemImg);
	    		CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getMem_name(), LobbyHomeEnrollmentRequestBuilder::setMemName);
	    		CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_registration_date(), LobbyHomeEnrollmentRequestBuilder::setItmRegistrationDate);
	    		CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_view_yn(), LobbyHomeEnrollmentRequestBuilder::setItmViewYn);
	    		
	    		return LobbyHomeEnrollmentRequestBuilder.build();

	    	}).collect(Collectors.toList());
		}
		
		LobbyHomeEnrollmentRequestListRes.Builder LobbyHomeEnrollmentRequestListResBuilder = LobbyHomeEnrollmentRequestListRes.newBuilder();
		CommonUtil.nullSafeSet(LobbyHomeEnrollmentRequestList, LobbyHomeEnrollmentRequestListResBuilder::addAllLobbyHomeEnrollmentRequestList);
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
		        .setData(LobbyHomeEnrollmentRequestListResBuilder.build().toByteString())
		        .build();
	
		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage modifyInstitutionEnrollmentViewStatus(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequestConfirmReq lobbyHomeEnrollmentRequestConfirmReq = LobbyHomeEnrollmentRequestConfirmReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequestConfirmParam lobbyHomeEnrollmentRequestConfirmParam = InstitutionEnrollmentRequestConfirmParam.builder().ins_code(lobbyHomeEnrollmentRequestConfirmReq.getInsCode())
		.mem_id(lobbyHomeEnrollmentRequestConfirmReq.getMemId()).build();
		
		int result = lobbyHomeMapper.updateInstitutionEnrollmentViewStatus(lobbyHomeEnrollmentRequestConfirmParam);
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken())
				.setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(IdentityAvatarChangeRes.newBuilder().build().toByteString())
				.build();
	
		return new BinaryMessage(packetResProto.toByteArray());
	}
	
	public BinaryMessage findInstitutionEnrollmentRequesterInfo(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
		
		LobbyHomeEnrollmentRequesterInfoReq lobbyHomeEnrollmentRequesterInfoReq = LobbyHomeEnrollmentRequesterInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
		InstitutionEnrollmentRequesterInfoParam lobbyHomeEnrollmentRequesterInfoParam = InstitutionEnrollmentRequesterInfoParam.builder().ins_code(lobbyHomeEnrollmentRequesterInfoReq.getInsCode()).mem_id(lobbyHomeEnrollmentRequesterInfoReq.getMemId()).build();
				
		InstitutionEnrollmentRequesterInfoDto institutionEnrollmentRequesterInfoDto = lobbyHomeMapper.selectInstitutionEnrollmentRequesterInfo(lobbyHomeEnrollmentRequesterInfoParam);
				
		Builder lobbyHomeEnrollmentRequesterInfoResBuilder = LobbyHomeEnrollmentRequesterInfoRes.newBuilder();
		
		if(institutionEnrollmentRequesterInfoDto != null) {
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMea_avatar_id(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMeaAvartarId);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_img(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMemImg);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_nickname(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMemImg);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_name(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMemName);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_email(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMemEmail);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_phone(), lobbyHomeEnrollmentRequesterInfoResBuilder::setMemPhone);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getItm_registration_date(), lobbyHomeEnrollmentRequesterInfoResBuilder::setItmRegistrationDate);
			CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getRti_registration_dates(), lobbyHomeEnrollmentRequesterInfoResBuilder::addAllRtiRegistrationDates);
		}	
		
		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(institutionEnrollmentRequesterInfoDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
				.setResultMessage(institutionEnrollmentRequesterInfoDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
				.setData(lobbyHomeEnrollmentRequesterInfoResBuilder.build().toByteString())
				.build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

	@Transactional(rollbackFor = {Exception.class})
	public BinaryMessage modifyInstitutionEnrollmentRequestStatus(RequestPacket packetReqProto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BinaryMessage findMyInstitutionByMemId(RequestPacket packetReqProto, String userId) {
		
		log.info("findMyInstitutionByMemId 함수 실행!");
		List<MyInstitutionListDto> myInstitutionListDtos = lobbyHomeMapper.selectMyInstitutionByMemId(userId);
		
		ResponsePacket packetResProto;
		
		if(myInstitutionListDtos.isEmpty()) {
			
			packetResProto = ResponsePacket.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
			
		}else {
			List<SWclassMyInstitution> subMyInstitutionList = new ArrayList<>() ;
			
			myInstitutionListDtos.stream().forEach(MyInstitutionListDto -> {
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
