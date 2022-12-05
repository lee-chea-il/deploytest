package com.classlink.websocket.api.lobby.home.domain.param;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LobbyHomeParam {

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
		private String ins_code;
		private String mem_id;
	}
	
	@Getter
	@Setter
	@Builder
	public static class InstitutionEnrollmentRequesterInfoParam {
		private String ins_code;
		private String mem_id;
	}
	
}
