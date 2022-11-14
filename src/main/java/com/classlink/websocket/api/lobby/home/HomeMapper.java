package com.classlink.websocket.api.lobby.home;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.classlink.websocket.api.lobby.home.domain.dto.InstitutionDto.MyInstitutionListDto;

@Mapper
public interface HomeMapper {

	List<MyInstitutionListDto> selectMyInstitutionByMemId(String mem_id);

}
