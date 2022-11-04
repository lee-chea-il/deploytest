package com.classlink.websocket.api.member.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MemberDto {
	
	@Data
	@Builder
	public static class MemberIdentityDto{
		private String IdtCode;
		private String IdtName;
		private String DeleteYn;
		private String regDate;
		private String update;
		private String deleteDate;
	}
	
	@Getter
	@Setter
	public static class IdentityDto {
		private String idt_name;
		private String resultCode;
		private String message;
	}
}
