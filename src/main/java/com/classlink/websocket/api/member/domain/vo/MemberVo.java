package com.classlink.websocket.api.member.domain.vo;

import lombok.Getter;
import lombok.Setter;

public class MemberVo {
	
	@Getter
	@Setter
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
	@Setter
	public static class IdentityVo {
		private String idt_code;
		private String idt_name;
		private String delete_yn;
		private String reg_date;
		private String uptdate;
		private String delete_date;
	}
}
