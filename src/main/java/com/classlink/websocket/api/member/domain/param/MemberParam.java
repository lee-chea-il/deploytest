package com.classlink.websocket.api.member.domain.param;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberParam {

	@Getter
	@Setter
	@Builder
	public static class IdentityCreateParam{
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
	
//	@Getter
//	@Setter
//	@Builder
//	public static class AvatarCreateParam{
//		private String mem_id;
//		private String ins_code;
//		private String identity_type;
//		private int mea_avatar_id;
//	}
	
	@Getter
	@Setter
	@Builder
	public static class AvatarListParam{
		private String mem_id;
		private String ins_code;
	}
	
	@Getter
	@Setter
	@Builder
	public static class AvatarChangeParam{
		private int mea_avatar_id;
		private String mem_id;
		private String ins_code;
		private String identity_type;	
	}
	
	@Getter
	@Setter
	@Builder
	public static class InstitutionInfoParam{
		private String ins_code;
		private String ins_invite_url;	
	}
	
	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequestParam{
		private String ins_code;
		private String mem_id;
	}

	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequestListParam {
		private String ins_code;
	}

	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequestConfirmParam {
		private int itm_idx;
		private String mem_id;
	}

	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequesterInfoParam {
		int itm_idx;
		private String mem_id;
	}
}
