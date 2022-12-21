package com.classlink.websocket.api.lobby;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.lobby.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.domain.dto.proto.LobbyHomeFranchiseInstitutionListResProto;
import com.classlink.websocket.api.lobby.domain.dto.proto.LobbyHomeScheduleListResProto;
import com.classlink.websocket.api.lobby.domain.dto.proto.LobbyHomeStudentInstitutionListResProto;
import com.classlink.websocket.api.lobby.domain.dto.proto.LobbyInstitutionClassTeacherListResProto;
import com.classlink.websocket.api.lobby.domain.param.proto.LobbyHomeFranchiseInstitutionListReqProto;
import com.classlink.websocket.api.lobby.domain.param.proto.LobbyHomeScheduleListReqProto;
import com.classlink.websocket.api.lobby.domain.param.proto.LobbyHomeStudentInstitutionListReqProto;
import com.classlink.websocket.api.lobby.domain.param.proto.LobbyInstitutionClassTeacherListProto;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyHomeService {
	
	private final LobbyHomeMapper lobbyHomeMapper;

	public BinaryMessage findStudentInstitutionsByMemId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

		LobbyHomeStudentInstitutionListReqProto.LobbyHomeStudentInstitutionListReq lobbyHomeStudentInstitutionListReq = LobbyHomeStudentInstitutionListReqProto.LobbyHomeStudentInstitutionListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution studentInstitution = LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution.newBuilder()
				.setInsCode("testA")
				.setInsName("클래스링크어학원")
				.setInsLogoImgUrl("/img/logo/1123a4e.png")
				.setInsDesc("인성도 최고, 성적도 최고, 학생들이 최고의 결과를 만들 수 있도록 도와드리겠습니다.")
				.setInsImgUrl("/img/img/1583eg.png")
				.setItmAccYn(true)
				.setRtiRegistrationDate("2022-12-21")
				.build();

		List<LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution> studentInstitutions = Arrays.asList(studentInstitution);

		LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes lobbyHomeStudentInstitutionListRes = LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.newBuilder().addAllStudentInstitutions(studentInstitutions).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(lobbyHomeStudentInstitutionListRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findFranchiseInstitutionsByMemId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

		LobbyHomeFranchiseInstitutionListReqProto.LobbyHomeFranchiseInstitutionListReq lobbyHomeFranchiseInstitutionListReq = LobbyHomeFranchiseInstitutionListReqProto.LobbyHomeFranchiseInstitutionListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution franchiseInstitution = LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution.newBuilder()
				.setInsCode("testA")
				.setInsName("클래스링크어학원")
				.setInsLogoUrl("/img/logo/1123a4e.png")
				.setTotalUserCnt(97)
				.setChangedUserCnt(20)
				.setRequestedDate("2022-12-21")
				.setIsPermission(true)
				.setLinkUrl("http://classlink.com/franchise/detail/page")
				.build();

		List<LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution> franchiseInstitutions = Arrays.asList(franchiseInstitution);

		LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes lobbyHomeFranchiseInstitutionListRes = LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.newBuilder().addAllFranchiseInstitutions(franchiseInstitutions).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(lobbyHomeFranchiseInstitutionListRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSchedulesByMemId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

		LobbyHomeScheduleListReqProto.LobbyHomeScheduleListReq lobbyHomeScheduleListReq = LobbyHomeScheduleListReqProto.LobbyHomeScheduleListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo scheduleInfo = LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo.newBuilder()
				.setScheduleId(1)
				.setScheduleName("수학과제")
				.setStartTime("2022-12-21")
				.setEndTime("2022-12-22")
				.build();

		List<LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo> scheduleInfos = Arrays.asList(scheduleInfo);

		LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes lobbyHomeScheduleListRes = LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.newBuilder().addAllScheduleInfoList(scheduleInfos).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(lobbyHomeScheduleListRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findTeacherList(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

		LobbyInstitutionClassTeacherListProto.LobbyInstitutionClassTeacherListReq lobbyInstitutionClassTeacherListReq = LobbyInstitutionClassTeacherListProto.LobbyInstitutionClassTeacherListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo teacherInfo = LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo.newBuilder()
				.setTchIdx(1)
				.setTeacherImgUrl("/img/profile/sd5e8ag.png")
				.setTeacherName("홍길동")
				.setClassName("수학 심화A반")
				.setInsName("클래스종합학원")
				.build();

		List<LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo> teacherInfos = Arrays.asList(teacherInfo);

		LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes lobbyHomeScheduleListRes = LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.newBuilder().addAllTeacherInfos(teacherInfos).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(lobbyHomeScheduleListRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}



//	public BinaryMessage findMyInstitutionByMemId(RequestPacket packetReqProto, String userId) {
//
//		log.info("findMyInstitutionByMemId 함수 실행!");
//		List<MyInstitutionListDto> myInstitutionListDtos = lobbyHomeMapper.selectMyInstitutionByMemId(userId);
//
//		ResponsePacket packetResProto;
//
//		if(myInstitutionListDtos.isEmpty()) {
//
//			packetResProto = ResponsePacket.newBuilder().setOpCode(ResultCode.NOT_FOUND.getCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).build();
//
//		}else {
//			List<SWclassMyInstitution> subMyInstitutionList = new ArrayList<>() ;
//
//			myInstitutionListDtos.forEach(MyInstitutionListDto -> {
//				log.info("findMyInstitutionByMemId 함수 실행!");
//				SWclassMyInstitution myInstitution = SWclassMyInstitution.newBuilder().setInsName(MyInstitutionListDto.getIns_name()).setStdUseYn(MyInstitutionListDto.getStd_use_yn()).build();
//				subMyInstitutionList.add(myInstitution);
//
//			});
//
//			SWclassMyInstitutionList myInstitutionList  = SWclassMyInstitutionList.newBuilder().addAllSwclassMyInstitution(subMyInstitutionList).build();
//
//			packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId()).setData(myInstitutionList.toByteString()).build();
//		}
//
//		return new BinaryMessage(packetResProto.toByteArray());
//	}
	
}
