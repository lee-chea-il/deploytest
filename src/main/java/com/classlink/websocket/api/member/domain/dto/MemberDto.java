package com.classlink.websocket.api.member.domain.dto;

import java.util.List;

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
	public static class IdentityDto {
		private List<String> idt_names;
	}
}
