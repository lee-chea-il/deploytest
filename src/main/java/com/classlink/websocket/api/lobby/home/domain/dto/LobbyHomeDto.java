package com.classlink.websocket.api.lobby.home.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LobbyHomeDto {

	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequestListDto{
		  String mem_id;
		  String mem_img; 
		  String mem_name;
		  String itm_registration_date;
		  String itm_view_yn;
	}
	
	@Getter
	@Setter
	@Builder
	public static class MyInstitutionListDto{
		private String std_use_yn;
		private String ins_name;
	}
}