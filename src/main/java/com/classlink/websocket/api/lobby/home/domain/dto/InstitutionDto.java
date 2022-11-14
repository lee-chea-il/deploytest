package com.classlink.websocket.api.lobby.home.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class InstitutionDto {
	
	@Getter
	@Setter
	@Builder
	public static class MyInstitutionListDto{
		private String std_use_yn;
		private String ins_name;
	}
}
