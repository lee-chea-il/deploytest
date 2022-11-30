package com.classlink.websocket.api.member.domain.param;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberParam {

	@Getter
	@Setter
	@Builder
	public static class IdentityCreateParam{
		private int mdt_idx;
		private String ins_code;
		private String mem_id;
		private String identity_type;
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityListParam{
		private String mem_id;
		private String ins_code;
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityAvatarCreateParam{
		private int mea_idx;
		private String mem_id;
		private String ins_code;
		private String identity_type;
		private String mea_avatar_id;		
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityAvatarDetailParam{
		private String mem_id;
		private String ins_code;
		private String identity_type;	
	}
	
	@Getter
	@Setter
	@Builder
	public static class IdentityAvatarChangeParam{
		private String mea_avatar_id;
		private String mem_id;
		private String ins_code;
		private String identity_type;	
	}

}
