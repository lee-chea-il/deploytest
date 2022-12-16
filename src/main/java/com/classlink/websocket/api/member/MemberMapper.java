package com.classlink.websocket.api.member;

import com.classlink.websocket.api.member.domain.dto.MemberDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.InstitutionInfoDto;
import com.classlink.websocket.api.member.domain.param.MemberParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<String> selectIdentitiesByMemberId(IdentityListParam identityListParam);

    int insertIdentity(IdentityCreateParam IdentityParam);

//	int insertAvatar(AvatarCreateParam avatarParam);

    List<MemberDto.AvatarListDto> selectAvatarByMemberId(MemberParam.AvatarListParam avatarListParam);

    int updateAvatarByMemberId(AvatarChangeParam avatarDetailParam);

    InstitutionInfoDto selectInstitutionInfoByInsCode(
            InstitutionInfoParam InstitutionInfoParam);

    int insertInstitutionEnrollmentRequest(
            InstitutionEnrollmentRequestParam InstitutionEnrollmentRequestParam);

    List<MemberDto.InstitutionEnrollmentRequestListDto> selectInstitutionEnrollmentsByInsCode(
            InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam);

    int updateInstitutionEnrollmentViewStatus(
            InstitutionEnrollmentRequestConfirmParam lobbyHomeEnrollmentRequestConfirmParam);

    MemberDto.InstitutionEnrollmentRequesterInfoDto selectInstitutionEnrollmentRequesterInfo(
            InstitutionEnrollmentRequesterInfoParam lobbyHomeEnrollmentRequesterInfoParam);
}
