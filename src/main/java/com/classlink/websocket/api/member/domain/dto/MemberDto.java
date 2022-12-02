package com.classlink.websocket.api.member.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class MemberDto {
	
	@Getter
	@Setter
	@Builder
	public static class MemberIdentityDto{
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
		private String ins_code;
		private String identity_type;
		private int mea_avatar_id;
	}
	
	@Getter
	@Setter
	@Builder
	public static class AvatarDetailDto {
		private String ins_code;
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
}
