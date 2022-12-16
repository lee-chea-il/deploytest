package com.classlink.websocket.api.member.domain.dto;

import lombok.*;

import java.util.List;


public class MemberDto {
	
	@Getter
	@Setter
	@Builder
	public static class IdentityDto{
		private String idt_code;
		private String idt_name;
		private String delete_yn;
		private String reg_date;
		private String update;
		private String delete_date;
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityListDto {
		private String identity_type;
	}
	
	@Getter
	@Setter
	@Builder
	public static class AvatarListDto {
		private String identity_type;
		private int mea_avatar_id;
	}
	
	@Getter
	@Setter
	@Builder
	public static class InstitutionInfoDto{
		private String ins_code;
		private String InsName;	
		private String InsLogoImg;
	}

	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequestListDto{
		int itm_idx;
		String identity_type;
		String mem_img;
		String mem_name;
		String itm_registration_date;
		String itm_status;
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
}
