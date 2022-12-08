package com.classlink.websocket.api.lobby.home;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequestListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequesterInfoDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestConfirmParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestListParam;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequesterInfoParam;

@Mapper
public interface LobbyHomeMapper {

	List<MyInstitutionListDto> selectMyInstitutionByMemId(String mem_id);

	List<InstitutionEnrollmentRequestListDto> selectInstitutionEnrollmentsByInsCode(
			InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam);

	int updateInstitutionEnrollmentViewStatus(
			InstitutionEnrollmentRequestConfirmParam lobbyHomeEnrollmentRequestConfirmParam);

	InstitutionEnrollmentRequesterInfoDto selectInstitutionEnrollmentRequesterInfo(
			InstitutionEnrollmentRequesterInfoParam lobbyHomeEnrollmentRequesterInfoParam);

}
