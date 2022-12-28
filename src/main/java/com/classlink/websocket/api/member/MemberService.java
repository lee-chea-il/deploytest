package com.classlink.websocket.api.member;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.member.domain.dto.MemberDto;
import com.classlink.websocket.api.member.domain.dto.MemberDto.InstitutionInfoDto;
import com.classlink.websocket.api.member.domain.dto.proto.*;
import com.classlink.websocket.api.member.domain.param.MemberParam;
import com.classlink.websocket.api.member.domain.param.MemberParam.*;
import com.classlink.websocket.api.member.domain.param.proto.*;
import com.classlink.websocket.api.util.CommonUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public BinaryMessage findIdentitiesByMemberId(RequestPacket packetReqProto, String userId)
            throws InvalidProtocolBufferException {

        IdentityListReqProto.IdentityListReq identityListReqProto = IdentityListReqProto.IdentityListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        IdentityListParam identityListParam = IdentityListParam.builder().ins_code(identityListReqProto.getInsCode())
                .mem_id(userId).build();

        List<String> identityDtoList = memberMapper.selectIdentitiesByMemberId(identityListParam);

        System.out.println(identityDtoList.toString());

        IdentityListResProto.IdentityListRes.Builder identityListRes = IdentityListResProto.IdentityListRes.newBuilder();

        if (!identityDtoList.isEmpty()) {
            CommonUtil.nullSafeSet(identityDtoList, identityListRes::addAllIdentityTypes);
        }

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(identityDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(identityListRes.build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage addIdentity(RequestPacket packetReqProto, String userId)
            throws InvalidProtocolBufferException {

        IdentityCreateReqProto.IdentityCreateReq identityCreateProto = IdentityCreateReqProto.IdentityCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
                .build();
        IdentityCreateParam identityParam = IdentityCreateParam.builder().ins_code(identityCreateProto.getInsCode())
                .mem_id(userId).identity_type(identityCreateProto.getTarIdentityType()).build();

        int result = memberMapper.insertIdentity(identityParam);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityCreateResProto.IdentityCreateRes.newBuilder().build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findIdentityProfileDetailByMemberId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityProfileDetailReqProto.IdentityProfileDetailReq identityProfileDetailReq = IdentityProfileDetailReqProto.IdentityProfileDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        IdentityProfileDetailResProto.IdentityProfileDetailRes identityProfileDetailRes = IdentityProfileDetailResProto.IdentityProfileDetailRes.newBuilder()
                .setAvatarId(1)
                .setMemId("test7777")
                .setMemName("방수영")
                .setMemNickName("soo")
                .setMemEmail("tpwls4555@gmail.com")
                .setMemPhone("01055558888")
                .setMemImgUrl("/img/profile/a1275sd.png")
                .setMemBirthday("08-15")
                .setMemSex("M")
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(identityProfileDetailRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage modifyIdentityProfileByMemberId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityProfileUpdateReqProto.IdentityProfileUpdateReq identityProfileUpdateReq = IdentityProfileUpdateReqProto.IdentityProfileUpdateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        IdentityProfileUpdateResProto.IdentityProfileUpdateRes identityProfileUpdateRes = IdentityProfileUpdateResProto.IdentityProfileUpdateRes.newBuilder()
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(identityProfileUpdateRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

//	@Transactional(rollbackFor = {Exception.class})
//	public BinaryMessage addAvatar(RequestPacket packetReqProto, String userId)
//			throws InvalidProtocolBufferException {
//
//		IdentityAvatarCreateReq avatarCreateReqProto = IdentityAvatarCreateReq.newBuilder().mergeFrom(packetReqProto.getData())
//				.build();
//		AvatarCreateParam avatarParam = AvatarCreateParam.builder().mem_id(userId)
//				.ins_code(avatarCreateReqProto.getInsCode()).identity_type(avatarCreateReqProto.getIdentityType())
//				.mea_avatar_id(avatarCreateReqProto.getAvatarId()).build();
//
//		int result = memberMapper.insertAvatar(avatarParam);
//
//		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
//				.setInstanceId(packetReqProto.getInstanceId())
//				.setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
//				.setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
//				.setData(IdentityAvatarCreateRes.newBuilder().build().toByteString())
//				.build();
//
//		return new BinaryMessage(packetResProto.toByteArray());
//	}


    public BinaryMessage findAvatarsByMemberId(RequestPacket packetReqProto, String userId)
            throws InvalidProtocolBufferException {

        IdentityAvatarListReqProto.IdentityAvatarListReq identityAvatarDetailReqProto = IdentityAvatarListReqProto.IdentityAvatarListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        MemberParam.AvatarListParam identityAvatarDetailParam = MemberParam.AvatarListParam.builder().ins_code(identityAvatarDetailReqProto.getInsCode())
                .mem_id(userId).build();

        List<MemberDto.AvatarListDto> identityAvatarDtoList = memberMapper.selectAvatarByMemberId(identityAvatarDetailParam);

        List<IdentityAvatarListResProto.IdentityAvatarListRes.AvatarInfo> avatarInfos = null;

        if (!identityAvatarDtoList.isEmpty()) {
            avatarInfos = identityAvatarDtoList.stream().map(identityAvatarDto -> {

                IdentityAvatarListResProto.IdentityAvatarListRes.AvatarInfo.Builder avatarInfoBuilder = IdentityAvatarListResProto.IdentityAvatarListRes.AvatarInfo.newBuilder();

                CommonUtil.nullSafeSet(identityAvatarDto.getIdentity_type(), avatarInfoBuilder::setSelectIdentityType);
                CommonUtil.nullSafeSet(identityAvatarDto.getMea_avatar_id(), avatarInfoBuilder::setAvatarId);

                return avatarInfoBuilder.build();

            }).collect(Collectors.toList());
        }

        IdentityAvatarListResProto.IdentityAvatarListRes.Builder identityAvatarListResBuilder = IdentityAvatarListResProto.IdentityAvatarListRes.newBuilder();
        CommonUtil.nullSafeSet(avatarInfos, identityAvatarListResBuilder::addAllAvatarInfos);

        ResponsePacket packetResProto;

        packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(identityAvatarDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(identityAvatarDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(identityAvatarListResBuilder.build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }


    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage modifyAvatarByMemberId(RequestPacket packetReqProto, String userId)
            throws InvalidProtocolBufferException {

        IdentityAvatarChangeReqProto.IdentityAvatarChangeReq identityAvatarChangeReqProto = IdentityAvatarChangeReqProto.IdentityAvatarChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        AvatarChangeParam avatarDetailParam = AvatarChangeParam.builder().mea_avatar_id(identityAvatarChangeReqProto.getAvatarId()).mem_id(userId).ins_code(identityAvatarChangeReqProto.getInsCode())
                .identity_type(identityAvatarChangeReqProto.getIdentityType()).build();

        int result = memberMapper.updateAvatarByMemberId(avatarDetailParam);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken())
                .setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityAvatarChangeResProto.IdentityAvatarChangeRes.newBuilder().build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }


    public BinaryMessage findInstitutionInfoByInsCode(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityInstitutionInfoReqProto.IdentityInstitutionInfoReq identityInstitutionInfoReq = IdentityInstitutionInfoReqProto.IdentityInstitutionInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        InstitutionInfoParam institutionInfoParam = InstitutionInfoParam.builder().ins_code(identityInstitutionInfoReq.getInsCode()).ins_invite_url(identityInstitutionInfoReq.getInsInviteUrl()).build();

        InstitutionInfoDto identityInstitutionInfoDto = memberMapper.selectInstitutionInfoByInsCode(institutionInfoParam);

        IdentityInstitutionInfoResProto.IdentityInstitutionInfoRes.Builder IdentityInstitutionInfoResBuilder = IdentityInstitutionInfoResProto.IdentityInstitutionInfoRes.newBuilder();

        if (identityInstitutionInfoDto != null) {
            CommonUtil.nullSafeSet(identityInstitutionInfoDto.getInsName(), IdentityInstitutionInfoResBuilder::setInsName);
            CommonUtil.nullSafeSet(identityInstitutionInfoDto.getInsLogoImg(), IdentityInstitutionInfoResBuilder::setInsLogoImgUrl);
        }

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(identityInstitutionInfoDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(identityInstitutionInfoDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityInstitutionInfoResBuilder.build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }


    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage addInstitutionEnrollment(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityInstitutionEnrollmentReqProto.IdentityInstitutionEnrollmentReq identityInstitutionEnrollmentRequestReq = IdentityInstitutionEnrollmentReqProto.IdentityInstitutionEnrollmentReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        InstitutionEnrollmentRequestParam institutionEnrollmentRequestParam = InstitutionEnrollmentRequestParam.builder().ins_code(identityInstitutionEnrollmentRequestReq.getInsCode()).mem_id(userId).build();

        int result = memberMapper.insertInstitutionEnrollmentRequest(institutionEnrollmentRequestParam);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode()).setAccessToken(packetReqProto.getAccessToken())
                .setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(result == 0 ? ResultCode.ADD_FAIL.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(result == 0 ? ResultCode.ADD_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityInstitutionEnrollmentResProto.IdentityInstitutionEnrollmentRes.newBuilder().build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findInstitutionEnrollmentsByInsCode(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityEnrollmentListReqProto.IdentityEnrollmentListReq lobbyHomeEnrollmentRequestListReq = IdentityEnrollmentListReqProto.IdentityEnrollmentListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        InstitutionEnrollmentRequestListParam institutionEnrollmentRequestListParam = InstitutionEnrollmentRequestListParam.builder().ins_code(lobbyHomeEnrollmentRequestListReq.getInsCode()).build();

        List<MemberDto.InstitutionEnrollmentRequestListDto> institutionEnrollmentRequestDtoList = memberMapper.selectInstitutionEnrollmentsByInsCode(institutionEnrollmentRequestListParam);

        List<IdentityEnrollmentListResProto.IdentityEnrollmentListRes.EnrollmentRequest> enrollmentRequestList = null;

        if (!institutionEnrollmentRequestDtoList.isEmpty()) {
            enrollmentRequestList = institutionEnrollmentRequestDtoList.stream().map(institutionEnrollmentRequestDto -> {

                IdentityEnrollmentListResProto.IdentityEnrollmentListRes.EnrollmentRequest.Builder enrollmentRequestBuilder = IdentityEnrollmentListResProto.IdentityEnrollmentListRes.EnrollmentRequest.newBuilder();

                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_idx(), enrollmentRequestBuilder::setItmIdx);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getIdentity_type(), enrollmentRequestBuilder::setIdentityType);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getMem_img(), enrollmentRequestBuilder::setMemImgUrl);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getMem_name(), enrollmentRequestBuilder::setMemName);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_registration_date(), enrollmentRequestBuilder::setItmRegistrationDate);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_view_yn(), enrollmentRequestBuilder::setItmViewYn);
                CommonUtil.nullSafeSet(institutionEnrollmentRequestDto.getItm_status(), enrollmentRequestBuilder::setItmStatus);

                return enrollmentRequestBuilder.build();

            }).collect(Collectors.toList());
        }

        IdentityEnrollmentListResProto.IdentityEnrollmentListRes.Builder IdentityEnrollmentListResBuilder = IdentityEnrollmentListResProto.IdentityEnrollmentListRes.newBuilder();
        CommonUtil.nullSafeSet(enrollmentRequestList, IdentityEnrollmentListResBuilder::addAllEnrollmentRequestes);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(institutionEnrollmentRequestDtoList.isEmpty() ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityEnrollmentListResBuilder.build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage modifyInstitutionEnrollmentViewStatus(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityEnrollmentConfirmReqProto.IdentityEnrollmentConfirmReq identityEnrollmentConfirmReq = IdentityEnrollmentConfirmReqProto.IdentityEnrollmentConfirmReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        InstitutionEnrollmentRequestConfirmParam lobbyHomeEnrollmentRequestConfirmParam = InstitutionEnrollmentRequestConfirmParam.builder().itm_idx(identityEnrollmentConfirmReq.getItmIdx()).build();

        int result = memberMapper.updateInstitutionEnrollmentViewStatus(lobbyHomeEnrollmentRequestConfirmParam);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken())
                .setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityEnrollmentConfirmResProto.IdentityEnrollmentConfirmRes.newBuilder().build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findInstitutionEnrollmentRequesterInfo(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityEnrollmentInfoReqProto.IdentityEnrollmentInfoReq identityEnrollmenterInfoReq = IdentityEnrollmentInfoReqProto.IdentityEnrollmentInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        InstitutionEnrollmentRequesterInfoParam lobbyHomeEnrollmentRequesterInfoParam = InstitutionEnrollmentRequesterInfoParam.builder().itm_idx(identityEnrollmenterInfoReq.getItmIdx()).mem_id(userId).build();

        MemberDto.InstitutionEnrollmentRequesterInfoDto institutionEnrollmentRequesterInfoDto = memberMapper.selectInstitutionEnrollmentRequesterInfo(lobbyHomeEnrollmentRequesterInfoParam);

        IdentityEnrollmentInfoResProto.IdentityEnrollmentInfoRes.Builder IdentityEnrollmenterInfoResBuilder = IdentityEnrollmentInfoResProto.IdentityEnrollmentInfoRes.newBuilder();

        if (institutionEnrollmentRequesterInfoDto != null) {
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMea_avatar_id(), IdentityEnrollmenterInfoResBuilder::setMeaAvartarId);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_img(), IdentityEnrollmenterInfoResBuilder::setMemImgUrl);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_nickname(), IdentityEnrollmenterInfoResBuilder::setMemNickName);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_name(), IdentityEnrollmenterInfoResBuilder::setMemName);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_email(), IdentityEnrollmenterInfoResBuilder::setMemEmail);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getMem_phone(), IdentityEnrollmenterInfoResBuilder::setMemPhone);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getItm_registration_date(), IdentityEnrollmenterInfoResBuilder::setItmRegistrationDate);
            CommonUtil.nullSafeSet(institutionEnrollmentRequesterInfoDto.getRti_registration_dates(), IdentityEnrollmenterInfoResBuilder::addAllRtiRegistrationDateList);
        }

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(institutionEnrollmentRequesterInfoDto == null ? ResultCode.NOT_FOUND.getCode() : ResultCode.SUCCESS.getCode())
                .setResultMessage(institutionEnrollmentRequesterInfoDto == null ? ResultCode.NOT_FOUND.getMessage() : ResultCode.SUCCESS.getMessage())
                .setData(IdentityEnrollmenterInfoResBuilder.build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    //교육기관 신청응답 mock 데이터처리
    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage modifyInstitutionEnrollmentRequestStatus(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq identityEnrollmentReplyReq = IdentityEnrollmentReplyReqProto.IdentityEnrollmentReplyReq.newBuilder().mergeFrom(packetReqProto.getData()).build();
        IdentityEnrollmentReplyParam identityEnrollmentReplyParam = IdentityEnrollmentReplyParam.builder().itm_idx(identityEnrollmentReplyReq.getItmIdx()).build();

//        int result = memberMapper.updateIdentityEnrollmentReply(identityEnrollmentReplyParam);

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken())
                .setInstanceId(packetReqProto.getInstanceId())
//                .setResultCode(result == 0 ? ResultCode.MODIFY_FAIL.getCode() : ResultCode.SUCCESS.getCode())
//                .setResultMessage(result == 0 ? ResultCode.MODIFY_FAIL.getMessage() : ResultCode.SUCCESS.getMessage())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(IdentityEnrollmentConfirmResProto.IdentityEnrollmentConfirmRes.newBuilder().build().toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage modifyLoginInstituteRegistration(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {
        LoginInstituteRegistReqProto.LoginInstituteRegistReq loginInstituteRegistReq = LoginInstituteRegistReqProto.LoginInstituteRegistReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LoginInstituteRegistResProto.LoginInstituteRegistRes loginInstituteRegistRes = LoginInstituteRegistResProto.LoginInstituteRegistRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(loginInstituteRegistRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    @Transactional(rollbackFor = {Exception.class})
    public BinaryMessage modifyLoginIdentityRegistration(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        LoginIdentityRegistReqProto.LoginIdentityRegistReq loginIdentityRegistReq = LoginIdentityRegistReqProto.LoginIdentityRegistReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LoginIdentityRegistResProto.LoginIdentityRegistRes loginIdentityRegistRes = LoginIdentityRegistResProto.LoginIdentityRegistRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(loginIdentityRegistRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage modifyIdentityByMemberId(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        IdentityChangeReqProto.IdentityChangeReq identityChangeReq = IdentityChangeReqProto.IdentityChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        IdentityChangeResProto.IdentityChangeRes identityChangeRes = IdentityChangeResProto.IdentityChangeRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(identityChangeRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

}
