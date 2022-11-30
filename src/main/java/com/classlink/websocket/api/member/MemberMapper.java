package com.classlink.websocket.api.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.classlink.websocket.api.member.domain.dto.MemberDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.IdentityAvatarDetailDto;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarChangeParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityAvatarDetailParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityCreateParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.IdentityListParam;

@Mapper
public interface MemberMapper {
	
	List<MemberDto.IdentityListDto> selectMemberIdentityByMemberId(IdentityListParam identityListParam);

	void insertMemberIdentity(IdentityCreateParam IdentityParam);

	void insertMemberAvartar(IdentityAvatarCreateParam avatarParam);

	IdentityAvatarDetailDto selectIdentityAvartarByMemberId(IdentityAvatarDetailParam avatarDetailParam);

	int updateIdentityAvartarByMemberId(IdentityAvatarChangeParam avatarDetailParam);
}
