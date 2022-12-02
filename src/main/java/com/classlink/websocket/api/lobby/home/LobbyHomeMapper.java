package com.classlink.websocket.api.lobby.home;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.InstitutionEnrollmentRequestListDto;
import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import com.classlink.websocket.api.lobby.home.domain.param.LobbyHomeParam.InstitutionEnrollmentRequestListParam;

@Mapper
public interface LobbyHomeMapper {

	List<MyInstitutionListDto> selectMyInstitutionByMemId(String mem_id);

	List<InstitutionEnrollmentRequestListDto> selectInstitutionEnrollmentsByInsCode(
			InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam);

}
