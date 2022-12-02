package com.classlink.websocket.api.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.classlink.websocket.api.member.domain.dto.MemberDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.AvatarDetailDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.InstitutionInfoDto;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarChangeParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.AvatarDetailParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityListParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.InstitutionEnrollmentRequestParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.InstitutionInfoParam;

@Mapper
public interface MemberMapper {
	
	List<MemberDto.IdentityListDto> selectMemberIdentitiesByMemberId(IdentityListParam identityListParam);

	int insertMemberIdentity(IdentityCreateParam IdentityParam);

	int insertMemberAvartar(AvatarCreateParam avatarParam);

	AvatarDetailDto selectIdentityAvartarByMemberId(AvatarDetailParam avatarDetailParam);

	int updateIdentityAvartarByMemberId(AvatarChangeParam avatarDetailParam);

	InstitutionInfoDto selectInstitutionInfoByInsCode(
			InstitutionInfoParam InstitutionInfoParam);

	int insertInstitutionEnrollmentRequest(
			InstitutionEnrollmentRequestParam InstitutionEnrollmentRequestParam);
}
