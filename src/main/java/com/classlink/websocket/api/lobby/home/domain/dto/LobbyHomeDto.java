package com.classlink.websocket.api.lobby.home.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class LobbyHomeDto {
	
	@Getter
	@Setter
	@Builder
	public static class MyInstitutionListDto{
		private String std_use_yn;
		private String ins_name;
	}
}
