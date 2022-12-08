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
	public static class InstitutionEnrollmentRequestListDto{
		  String mem_id;
		  String mem_img; 
		  String mem_name;
		  String itm_registration_date;
		  String itm_view_yn;
	}
	
	@ToString
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class InstitutionEnrollmentRequesterInfoDto{
		int mea_avatar_id;
		String mem_img;
		String mem_nickname;
		String mem_name;
		String mem_email;
		String mem_phone;
		String itm_registration_date;
		List<String> rti_registration_dates;
	}
	
	@Getter
	@Setter
	@Builder
	public static class MyInstitutionListDto{
		private String std_use_yn;
		private String ins_name;
	}
}
