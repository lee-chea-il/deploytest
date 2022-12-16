package com.classlink.websocket.api.lobby.home;

import com.classlink.websocket.api.lobby.home.domain.dto.LobbyHomeDto.MyInstitutionListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LobbyHomeMapper {

	List<MyInstitutionListDto> selectMyInstitutionByMemId(String mem_id);

}
