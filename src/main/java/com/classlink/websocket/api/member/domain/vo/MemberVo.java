package com.classlink.websocket.api.member.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberVo {
	
	@Getter
	@NoArgsConstructor
	public static class MemberIdentityVo {
		private int mdt_idx;
		private String idt_code;
		private int mem_idx;
		private String delete_yn;
		private String reg_date;
		private String uptdate;
		private String delete_date;
	}
	
	@Getter
	@NoArgsConstructor
	public static class IdentityVo {
		private String idt_code;
		private String idt_name;
		private String delete_yn;
		private String reg_date;
		private String uptdate;
		private String delete_date;
	}
}
