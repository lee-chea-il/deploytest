package com.classlink.websocket.api.member.domain.param;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberParam {

	@Getter
	@Setter
	@Builder
	public static class MemberIdentityParam{
		private int mdt_idx;
		private String idt_code;
		private String mem_id;
	}

}
