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
		private String IdtCode;
		private String IdtName;
		private String DeleteYn;
		private String regDate;
		private String update;
		private String deleteDate;
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityDto {
		private List<String> idt_names;
	}
}
