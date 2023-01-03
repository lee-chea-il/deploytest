<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Hello2</title>
</head>
<body>
<h1>WebSocket API Test Page</h1>

<div class="well">
    <button id="btnOpen" class="btn btn-primary">open socket</button>
    <select id="OpCode" class="form-control">
        <%--SysWorld 관련--%>
        <option value="120">WorldSet 정보</option>
        <option value="127">Interaction Package Create</option>
        <option value="201">Interaction Curriculum Create</option>
        <option value="128">Interaction Object Init</option>
        <%--로그인 관련--%>
        <option value="112">최근 접속 교육기관 update</option>
        <option value="113">최근 접속 신분 update</option>
        <%--신분생성flow 관련--%>
        <option value="100">신분 생성</option>
        <option value="101" selected>신분 조회</option>
        <option value="102">신분 선택</option>
        <option value="106">교육기관 등록 요청</option>
        <option value="105">입력한 교육기관 정보 확인</option>
        <option value="107">가입 신청 리스트</option>
        <option value="108">가입 신청 확인</option>
        <option value="109">가입 신청인 정보</option>
        <option value="110">가입 신청 응답</option>
        <option value="103">아바타 조회</option>
        <option value="104">아바타 변경</option>
        <option value="129">사용자 정보 조회</option>
        <option value="111">사용자 정보 입력</option>
        <%--lobby관련--%>
        <option value="132">통계</option>
        <option value="117">학생 소속 교육기관 목록</option>
        <option value="118">프랜차이즈장 보유 교육기관 목록</option>
        <option value="133">알림</option>
        <option value="134">기간별 일정 목록</option>
        <option value="114">기간별 수업 목록</option>
        <option value="115">오늘의 수업 상세보기</option>
        <option value="116">강의 코스 목록</option>
        <option value="135">테마별 이벤트</option>
        <option value="136">시스템 공지 리스트</option>
        <option value="137">교육기관 공지 리스트</option>
        <option value="138">프렌차이즈 공지 리스트</option>
        <option value="139">출결</option>
        <option value="119">선생님 목록</option>
        <option value="140">선생님 정보</option>
        <option value="141">노트함</option>
        <option value="142">필기함</option>
        <option value="143">과제함</option>
        <option value="144">질문함</option>
        <option value="145">일정</option>
        <option value="146">리포트</option>
        <%--cw관련--%>
        <option value="149">퀴즈 문제 은행 리스트</option>
        <option value="150">퀴즈 활성화</option>
        <option value="152">쪽지 시험 활성화</option>
        <option value="156">질문 등록</option>
        <option value="157">내 질문 리스트</option>
        <option value="158">내 질문</option>
        <option value="159">수업반 기본 정보</option>
        <option value="202">커리큘럼 리스트</option>
        <option value="160">커리큘럼 변경 적용</option>
        <option value="200">채팅창 유저 정보</option>
        <option value="161">내 정보</option>
    </select>
    <button id="btnSend" class="btn btn-primary">Send Message</button>
</div>
<div>Result</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/protobufjs@7.1.2/dist/protobuf.js"></script>
<script src="js/util.js"></script>
<script>

    //---------------------------------------------------------------------------------------------------
    // window[]를 통해서 브라우저상에 전역변수(global)로 지정할때 사용하는 변수

    //packet,jwt
    const RequestPacketName = "RequestPacket";
    const ResponsePacketName = "ResponsePacket";
    const JwtExceptionName = "JwtException";

    // 시스템--------------------------------------
    //월드셋
    const SysWorldSetInfoReqName = "SysWorldSetInfoReq";
    const SysWorldSetInfoResName = "SysWorldSetInfoRes";

    const SysWorldInterObjSetPackageCreateReqName = "SysWorldInterObjSetPackageCreateReq";
    const SysWorldInterObjSetPackageCreateResName = "SysWorldInterObjSetPackageCreateRes";

    const SysWorldInterObjSetCurriculumCreateReqName = "SysWorldInterObjSetCurriculumCreateReq";
    const SysWorldInterObjSetCurriculumCreateResName = "SysWorldInterObjSetCurriculumCreateRes";

    const SysWorldInterObjSetCurriculumInitReqName = "SysWorldInterObjSetCurriculumInitReq";
    const SysWorldInterObjSetCurriculumInitResName = "SysWorldInterObjSetCurriculumInitRes";

    // SW 및 로비 --------------------------------------------------------
    const LoginInstituteRegistReqName = "LoginInstituteRegistReq";
    const LoginInstituteRegistResName = "LoginInstituteRegistRes";
    const LoginIdentityRegistReqName = "LoginIdentityRegistReq";
    const LoginIdentityRegistResName = "LoginIdentityRegistRes";
    const IdentityCreateReqName = "IdentityCreateReq";
    const IdentityCreateResName = "IdentityCreateRes";
    const IdentityListReqName = "IdentityListReq";
    const IdentityListResName = "IdentityListRes";
    const IdentityChangeReqName = "IdentityChangeReq";
    const IdentityChangeResName = "IdentityChangeRes";
    const IdentityInstitutionEnrollmentReqName = "IdentityInstitutionEnrollmentReq";
    const IdentityInstitutionEnrollmentResName = "IdentityInstitutionEnrollmentRes";
    const IdentityInstitutionInfoReqName = "IdentityInstitutionInfoReq";
    const IdentityInstitutionInfoResName = "IdentityInstitutionInfoRes";
    const IdentityEnrollmentListReqName = "IdentityEnrollmentListReq";
    const IdentityEnrollmentListResName = "IdentityEnrollmentListRes";
    const IdentityEnrollmentConfirmReqName = "IdentityEnrollmentConfirmReq";
    const IdentityEnrollmentConfirmResName = "IdentityEnrollmentConfirmRes";
    const IdentityEnrollmentInfoReqName = "IdentityEnrollmentInfoReq";
    const IdentityEnrollmentInfoResName = "IdentityEnrollmentInfoRes";
    const IdentityEnrollmentReplyReqName = "IdentityEnrollmentReplyReq";
    const IdentityEnrollmentReplyResName = "IdentityEnrollmentReplyRes";
    const IdentityAvatarListReqName = "IdentityAvatarListReq";
    const IdentityAvatarListResName = "IdentityAvatarListRes";
    const IdentityAvatarChangeReqName = "IdentityAvatarChangeReq";
    const IdentityAvatarChangeResName = "IdentityAvatarChangeRes";
    const IdentityProfileDetailReqName = "IdentityProfileDetailReq";
    const IdentityProfileDetailResName = "IdentityProfileDetailRes";
    const IdentityProfileUpdateReqName = "IdentityProfileUpdateReq";
    const IdentityProfileUpdateResName = "IdentityProfileUpdateRes";
    const LobbyHomeStatisticsReqName = "LobbyHomeStatisticsReq";
    const LobbyHomeStatisticsResName = "LobbyHomeStatisticsRes";
    const LobbyHomeStudentInstitutionListReqName = "LobbyHomeStudentInstitutionListReq";
    const LobbyHomeStudentInstitutionListResName = "LobbyHomeStudentInstitutionListRes";
    const LobbyHomeFranchiseInstitutionListReqName = "LobbyHomeFranchiseInstitutionListReq";
    const LobbyHomeFranchiseInstitutionListResName = "LobbyHomeFranchiseInstitutionListRes";
    const LobbyHomeNoticeListReqName = "LobbyHomeNoticeListReq";
    const LobbyHomeNoticeListResName = "LobbyHomeNoticeListRes";
    const LobbyHomeScheduleListReqName = "LobbyHomeScheduleListReq";
    const LobbyHomeScheduleListResName = "LobbyHomeScheduleListRes";
    const LobbyHomeClassInfoListReqName = "LobbyHomeClassInfoListReq";
    const LobbyHomeClassInfoListResName = "LobbyHomeClassInfoListRes";
    const LobbyHomeTodayClassDetailReqName = "LobbyHomeTodayClassDetailReq";
    const LobbyHomeTodayClassDetailResName = "LobbyHomeTodayClassDetailRes";
    const LobbyHomeLectureCourseListReqName = "LobbyHomeLectureCourseListReq";
    const LobbyHomeLectureCourseListResName = "LobbyHomeLectureCourseListRes";
    const LobbyHomeEventForThemeListReqName = "LobbyHomeEventForThemeListReq";
    const LobbyHomeEventForThemeListResName = "LobbyHomeEventForThemeListRes";
    const SWclassInstitutionSystemNoticeListReqName = "SWclassInstitutionSystemNoticeListReq";
    const SWclassInstitutionSystemNoticeListResName = "SWclassInstitutionSystemNoticeListRes";
    const SWclassInstitutionInstitutionNoticeListReqName = "SWclassInstitutionInstitutionNoticeListReq";
    const SWclassInstitutionInstitutionNoticeListResName = "SWclassInstitutionInstitutionNoticeListRes";
    const SWclassInstitutionfranchiseNoticeListReqName = "SWclassInstitutionfranchiseNoticeListReq";
    const SWclassInstitutionfranchiseNoticeListResName = "SWclassInstitutionfranchiseNoticeListRes";
    const SWclassInstitutionAttendanceReqName = "SWclassInstitutionAttendanceReq";
    const SWclassInstitutionAttendanceResName = "SWclassInstitutionAttendanceRes";
    const LobbyInstitutionClassTeacherListReqName = "LobbyInstitutionClassTeacherListReq";
    const LobbyInstitutionClassTeacherListResName = "LobbyInstitutionClassTeacherListRes";
    const LobbyInstitutionClassTeacherInfoReqName = "LobbyInstitutionClassTeacherInfoReq";
    const LobbyInstitutionClassTeacherInfoResName = "LobbyInstitutionClassTeacherInfoRes";
    const LobbyInstitutionBoardNoteBoxReqName = "LobbyInstitutionBoardNoteBoxReq";
    const LobbyInstitutionBoardNoteBoxResName = "LobbyInstitutionBoardNoteBoxRes";
    const LobbyInstitutionBoardNotepadReqName = "LobbyInstitutionBoardNotepadReq";
    const LobbyInstitutionBoardNotepadResName = "LobbyInstitutionBoardNotepadRes";
    const LobbyInstitutionBoardReportBoxReqName = "LobbyInstitutionBoardReportBoxReq";
    const LobbyInstitutionBoardReportBoxResName = "LobbyInstitutionBoardReportBoxRes";
    const LobbyInstitutionBoardQuestionBoxReqName = "LobbyInstitutionBoardQuestionBoxReq";
    const LobbyInstitutionBoardQuestionBoxResName = "LobbyInstitutionBoardQuestionBoxRes";
    const LobbyCalenderScheduleReqName = "LobbyCalenderScheduleReq";
    const LobbyCalenderScheduleResName = "LobbyCalenderScheduleRes";
    const LobbyReportUrlReqName = "LobbyReportUrlReq";
    const LobbyReportUrlResName = "LobbyReportUrlRes";

    //cw
    const CWExamQuizListReqName = "CWExamQuizListReq";
    const CWExamQuizListResName = "CWExamQuizListRes";
    const CWExamQuizActivateReqName = "CWExamQuizActivateReq";
    const CWExamQuizActivateResName = "CWExamQuizActivateRes";
    const QuizAnswerDoneResName = "QuizAnswerDoneRes";
    const CWExamNoteExamActiveReqName = "CWExamNoteExamActiveReq";
    const CWExamNoteExamActiveResName = "CWExamNoteExamActiveRes";
    const CWExamNoteExamAnswerDoneResName = "CWExamNoteExamAnswerDoneRes";
    const CWQuestionBoxCreateReqName = "CWQuestionBoxCreateReq";
    const CWQuestionBoxCreateResName = "CWQuestionBoxCreateRes";
    const CWQuestionBoxListReqName = "CWQuestionBoxListReq";
    const CWQuestionBoxListResName = "CWQuestionBoxListRes";
    const CWQuestionBoxQuestionDetailReqName = "CWQuestionBoxQuestionDetailReq";
    const CWQuestionBoxQuestionDetailResName = "CWQuestionBoxQuestionDetailRes";
    const CWInfoBasicInfoReqName = "CWInfoBasicInfoReq";
    const CWInfoBasicInfoResName = "CWInfoBasicInfoRes";
    const CWCurriculumListReqName = "CWCurriculumListReq";
    const CWCurriculumListResName = "CWCurriculumListRes";
    const CWCurriculumChangeReqName = "CWCurriculumChangeReq";
    const CWCurriculumChangeResName = "CWCurriculumChangeRes";
    const CWMessengerChatUserInfoReqName = "CWMessengerChatUserInfoReq";
    const CWMessengerChatUserInfoResName = "CWMessengerChatUserInfoRes";
    const CWMyInfoChangeReqName = "CWMyInfoChangeReq";
    const CWMyInfoChangeResName = "CWMyInfoChangeRes";

    //---------------------------------------------------------------------------------------------------
    // protobuf.load시에 로딩할 protobuf 파일 경로 지정  

    const commonPath = "../proto"
    const protoFileList = [

        //월드셋관련
        commonPath.concat("/system/request/SysWorldSetInfoReq.proto"),
        commonPath.concat("/system/response/SysWorldSetInfoRes.proto"),
        commonPath.concat("/system/request/SysWorldInterObjSetPackageCreateReq.proto"),
        commonPath.concat("/system/response/SysWorldInterObjSetPackageCreateRes.proto"),
        commonPath.concat("/system/request/SysWorldInterObjSetCurriculumCreateReq.proto"),
        commonPath.concat("/system/response/SysWorldInterObjSetCurriculumCreateRes.proto"),
        commonPath.concat("/system/request/SysWorldInterObjSetCurriculumInitReq.proto"),
        commonPath.concat("/system/response/SysWorldInterObjSetCurriculumInitRes.proto"),

        //회원관련
        commonPath.concat("/member/request/LoginInstituteRegistReq.proto"),
        commonPath.concat("/member/response/LoginInstituteRegistRes.proto"),
        commonPath.concat("/member/request/LoginIdentityRegistReq.proto"),
        commonPath.concat("/member/response/LoginIdentityRegistRes.proto"),
        commonPath.concat("/member/request/IdentityCreateReq.proto"),
        commonPath.concat("/member/response/IdentityCreateRes.proto"),
        commonPath.concat("/member/request/IdentityListReq.proto"),
        commonPath.concat("/member/response/IdentityListRes.proto"),
        commonPath.concat("/member/request/IdentityChangeReq.proto"),
        commonPath.concat("/member/response/IdentityChangeRes.proto"),
        commonPath.concat("/member/request/IdentityInstitutionEnrollmentReq.proto"),
        commonPath.concat("/member/response/IdentityInstitutionEnrollmentRes.proto"),
        commonPath.concat("/member/request/IdentityInstitutionInfoReq.proto"),
        commonPath.concat("/member/response/IdentityInstitutionInfoRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentListReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentListRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentConfirmReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentConfirmRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentInfoReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentInfoRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentReplyReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentReplyRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarListReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarListRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarChangeReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarChangeRes.proto"),
        commonPath.concat("/member/request/IdentityProfileDetailReq.proto"),
        commonPath.concat("/member/response/IdentityProfileDetailRes.proto"),
        commonPath.concat("/member/request/IdentityProfileUpdateReq.proto"),
        commonPath.concat("/member/response/IdentityProfileUpdateRes.proto"),

        //로비
        commonPath.concat("/lobby/request/LobbyHomeStatisticsReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeStatisticsRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeStudentInstitutionListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeStudentInstitutionListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeFranchiseInstitutionListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeFranchiseInstitutionListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeNoticeListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeNoticeListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeScheduleListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeScheduleListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeClassInfoListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeClassInfoListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeTodayClassDetailReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeTodayClassDetailRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeLectureCourseListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeLectureCourseListRes.proto"),
        commonPath.concat("/lobby/request/LobbyHomeEventForThemeListReq.proto"),
        commonPath.concat("/lobby/response/LobbyHomeEventForThemeListRes.proto"),
        commonPath.concat("/lobby/request/SWclassInstitutionSystemNoticeListReq.proto"),
        commonPath.concat("/lobby/response/SWclassInstitutionSystemNoticeListRes.proto"),
        commonPath.concat("/lobby/request/SWclassInstitutionInstitutionNoticeListReq.proto"),
        commonPath.concat("/lobby/response/SWclassInstitutionInstitutionNoticeListRes.proto"),
        commonPath.concat("/lobby/request/SWclassInstitutionfranchiseNoticeListReq.proto"),
        commonPath.concat("/lobby/response/SWclassInstitutionfranchiseNoticeListRes.proto"),
        commonPath.concat("/lobby/request/SWclassInstitutionAttendanceReq.proto"),
        commonPath.concat("/lobby/response/SWclassInstitutionAttendanceRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionClassTeacherListReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionClassTeacherListRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionClassTeacherInfoReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionClassTeacherInfoRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionBoardNoteBoxReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionBoardNoteBoxRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionBoardNotepadReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionBoardNotepadRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionBoardReportBoxReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionBoardReportBoxRes.proto"),
        commonPath.concat("/lobby/request/LobbyInstitutionBoardQuestionBoxReq.proto"),
        commonPath.concat("/lobby/response/LobbyInstitutionBoardQuestionBoxRes.proto"),
        commonPath.concat("/lobby/request/LobbyCalenderScheduleReq.proto"),
        commonPath.concat("/lobby/response/LobbyCalenderScheduleRes.proto"),
        commonPath.concat("/lobby/request/LobbyReportUrlReq.proto"),
        commonPath.concat("/lobby/response/LobbyReportUrlRes.proto"),

        //cw
        commonPath.concat("/cw/request/CWExamQuizListReq.proto"),
        commonPath.concat("/cw/response/CWExamQuizListRes.proto"),
        commonPath.concat("/cw/request/CWExamQuizActivateReq.proto"),
        commonPath.concat("/cw/response/CWExamQuizActivateRes.proto"),
        commonPath.concat("/cw/response/QuizAnswerDoneRes.proto"),
        commonPath.concat("/cw/request/CWExamNoteExamActiveReq.proto"),
        commonPath.concat("/cw/response/CWExamNoteExamActiveRes.proto"),
        commonPath.concat("/cw/response/CWExamNoteExamAnswerDoneRes.proto"),
        commonPath.concat("/cw/request/CWQuestionBoxCreateReq.proto"),
        commonPath.concat("/cw/response/CWQuestionBoxCreateRes.proto"),
        commonPath.concat("/cw/request/CWQuestionBoxListReq.proto"),
        commonPath.concat("/cw/response/CWQuestionBoxListRes.proto"),
        commonPath.concat("/cw/request/CWQuestionBoxQuestionDetailReq.proto"),
        commonPath.concat("/cw/response/CWQuestionBoxQuestionDetailRes.proto"),
        commonPath.concat("/cw/request/CWInfoBasicInfoReq.proto"),
        commonPath.concat("/cw/response/CWInfoBasicInfoRes.proto"),
        commonPath.concat("/cw/request/CWCurriculumListReq.proto"),
        commonPath.concat("/cw/response/CWCurriculumListRes.proto"),
        commonPath.concat("/cw/request/CWCurriculumChangeReq.proto"),
        commonPath.concat("/cw/response/CWCurriculumChangeRes.proto"),
        commonPath.concat("/cw/request/CWMessengerChatUserInfoReq.proto"),
        commonPath.concat("/cw/response/CWMessengerChatUserInfoRes.proto"),
        commonPath.concat("/cw/request/CWMyInfoChangeReq.proto"),
        commonPath.concat("/cw/response/CWMyInfoChangeRes.proto"),

        //packet,jwt
        commonPath.concat("/common/RequestPacket.proto"),
        commonPath.concat("/common/ResponsePacket.proto"),
        commonPath.concat("/jwt/jwtException.proto")
    ];

    //---------------------------------------------------------------------------------------------------
    // 아래 전체코드 flow
    // 1.브라우저가 로딩되고나서 open socket 버튼 클릭시, connectWS()함수를 통해서 websocket 연결
    // 2.Send Message 클릭시, document.getElementById("OpCode").value를 통해서 OpCode를 input 박스에서 가져옴
    // 3.switch문을 통해서 OpCode에 따라 Packet에 데이터를 담거나 꺼낼때 사용하는 proto파일의 message를 전역변수에 담고,
    // 추가적으로 데이터를 Packet에 담아야하는 경우 setDataToSend를 통해서 데이터를 serialize한다.
    // 4.PacketObj에 Data담는곳에 serialize한 데이터를 담는다.
    // 5.PacketObj를 setDataToSend를 serialize해서 socket.send()에 담아서 서버에 전송한다.

    $(document).ready(function () {
        $("#btnOpen").on("click", function (evt) {
            connectWS();
        });

        $("#btnSend").on("click", function (evt) {
            console.clear();

            let OpCode = getOpCodeFromSelectBox();

            let Data = new Uint8Array([]);

            protobuf.load(protoFileList, function (err, root) {
                console.log("INFO: protobuf files loaded.");

                loadMessage(root, RequestPacketName, "Classlink.RequestPacket");
                loadMessage(root, ResponsePacketName, "Classlink.ResponsePacket");
                loadMessage(root, JwtExceptionName, "Classlink.JwtException");

                switch (OpCode) {
//WorldSet 정보-----------------------------------------------------------------------------------------
                    case 120 :
                        loadMessage(root, SysWorldSetInfoReqName, 'Classlink.SysWorldSetInfoReq');
                        loadMessage(root, SysWorldSetInfoResName, 'Classlink.SysWorldSetInfoRes');

                        const SysWorldSetInfoReqObj = {
                            InsCode : 'InsCode',
                        };

                        Data = setDataToSend(root, SysWorldSetInfoReqName, SysWorldSetInfoReqObj);
                        break;
//Interaction Object Create-----------------------------------------------------------------------------------------
                    case 127 :
                        loadMessage(root, SysWorldInterObjSetPackageCreateReqName, 'Classlink.SysWorldInterObjSetPackageCreateReq');
                        loadMessage(root, SysWorldInterObjSetPackageCreateResName, 'Classlink.SysWorldInterObjSetPackageCreateRes');

                        const SysWorldInterObjSetPackageCreateReqObj = {
                            InsCode : 'InsCode',
                            WorldIdx : 1,
                        };

                        Data = setDataToSend(root, SysWorldInterObjSetPackageCreateReqName, SysWorldInterObjSetPackageCreateReqObj);
                        break;
//Interaction Object Create-----------------------------------------------------------------------------------------
                    case 201 :
                        loadMessage(root, SysWorldInterObjSetCurriculumCreateReqName, 'Classlink.SysWorldInterObjSetCurriculumCreateReq');
                        loadMessage(root, SysWorldInterObjSetCurriculumCreateResName, 'Classlink.SysWorldInterObjSetCurriculumCreateRes');

                        const SysWorldInterObjSetCurriculumCreateReqObj = {
                            InsCode : 'InsCode',
                            WorldIdx : 2, // 추가
                        };

                        Data = setDataToSend(root, SysWorldInterObjSetCurriculumCreateReqName, SysWorldInterObjSetCurriculumCreateReqObj);
                        break;
//Interaction Object Init-----------------------------------------------------------------------------------------
                    case 128 :
                        loadMessage(root, SysWorldInterObjSetCurriculumInitReqName, 'Classlink.SysWorldInterObjSetCurriculumInitReq');
                        loadMessage(root, SysWorldInterObjSetCurriculumInitResName, 'Classlink.SysWorldInterObjSetCurriculumInitRes');

                        const SysWorldInterObjSetCurriculumInitReqObj = {
                            InsCode :'InsCode',
                            WorldIdx :1,
                            CurriculumIdx :3,

                        };

                        Data = setDataToSend(root, SysWorldInterObjSetCurriculumInitReqName, SysWorldInterObjSetCurriculumInitReqObj);
                        break;

//최근 접속 교육기관 update-----------------------------------------------------------------------------------------
                    case 112 :
                        loadMessage(root, LoginInstituteRegistReqName, 'Classlink.LoginInstituteRegistReq');
                        loadMessage(root, LoginInstituteRegistResName, 'Classlink.LoginInstituteRegistRes');

                        const LoginInstituteRegistReqObj = {
                            LastInsCode: 'LastInsCode',
                        };

                        Data = setDataToSend(root, LoginInstituteRegistReqName, LoginInstituteRegistReqObj);
                        break;

//최근 접속 신분 update-----------------------------------------------------------------------------------------
                    case 113 :
                        loadMessage(root, LoginIdentityRegistReqName, 'Classlink.LoginIdentityRegistReq');
                        loadMessage(root, LoginIdentityRegistResName, 'Classlink.LoginIdentityRegistRes');

                        const LoginIdentityRegistReqObj = {
                            LastIdentityType: 'LastIdentityType',
                            InsCode: 'InsCode',
                        };

                        Data = setDataToSend(root, LoginIdentityRegistReqName, LoginIdentityRegistReqObj);
                        break;

//신분 생성-----------------------------------------------------------------------------------------
                    case 100 :
                        loadMessage(root, IdentityCreateReqName, 'Classlink.IdentityCreateReq');
                        loadMessage(root, IdentityCreateResName, 'Classlink.IdentityCreateRes');

                        const IdentityCreateReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, IdentityCreateReqName, IdentityCreateReqObj);
                        break;

//신분 조회-----------------------------------------------------------------------------------------
                    case 101 :
                        loadMessage(root, IdentityListReqName, 'Classlink.IdentityListReq');
                        loadMessage(root, IdentityListResName, 'Classlink.IdentityListRes');

                        const IdentityListReqObj = {
                            InsCode: 'InsCode',
                        };

                        Data = setDataToSend(root, IdentityListReqName, IdentityListReqObj);
                        break;

//신분 선택-----------------------------------------------------------------------------------------
                    case 102 :
                        loadMessage(root, IdentityChangeReqName, 'Classlink.IdentityChangeReq');
                        loadMessage(root, IdentityChangeResName, 'Classlink.IdentityChangeRes');

                        const IdentityChangeReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, IdentityChangeReqName, IdentityChangeReqObj);
                        break;

//교육기관 등록 요청-----------------------------------------------------------------------------------------
                    case 106 :
                        loadMessage(root, IdentityInstitutionEnrollmentReqName, 'Classlink.IdentityInstitutionEnrollmentReq');
                        loadMessage(root, IdentityInstitutionEnrollmentResName, 'Classlink.IdentityInstitutionEnrollmentRes');

                        const IdentityInstitutionEnrollmentReqObj = {
                            InsCode: 'InsCode',
                        };

                        Data = setDataToSend(root, IdentityInstitutionEnrollmentReqName, IdentityInstitutionEnrollmentReqObj);
                        break;

//입력한 교육기관 정보 확인-----------------------------------------------------------------------------------------
                    case 105 :
                        loadMessage(root, IdentityInstitutionInfoReqName, 'Classlink.IdentityInstitutionInfoReq');
                        loadMessage(root, IdentityInstitutionInfoResName, 'Classlink.IdentityInstitutionInfoRes');

                        const IdentityInstitutionInfoReqObj = {
                            InsCode: 'InsCode',
                            InsInviteUrl: 'InsInviteUrl',
                        };

                        Data = setDataToSend(root, IdentityInstitutionInfoReqName, IdentityInstitutionInfoReqObj);
                        break;

//가입 신청 리스트-----------------------------------------------------------------------------------------
                    case 107 :
                        loadMessage(root, IdentityEnrollmentListReqName, 'Classlink.IdentityEnrollmentListReq');
                        loadMessage(root, IdentityEnrollmentListResName, 'Classlink.IdentityEnrollmentListRes');

                        const IdentityEnrollmentListReqObj = {
                            InsCode: 'InsCode',
                        };

                        Data = setDataToSend(root, IdentityEnrollmentListReqName, IdentityEnrollmentListReqObj);
                        break;

//가입 신청 확인-----------------------------------------------------------------------------------------
                    case 108 :
                        loadMessage(root, IdentityEnrollmentConfirmReqName, 'Classlink.IdentityEnrollmentConfirmReq');
                        loadMessage(root, IdentityEnrollmentConfirmResName, 'Classlink.IdentityEnrollmentConfirmRes');

                        const IdentityEnrollmentConfirmReqObj = {
                            ItmIdx: 1,
                        };

                        Data = setDataToSend(root, IdentityEnrollmentConfirmReqName, IdentityEnrollmentConfirmReqObj);
                        break;

//가입 신청인 정보-----------------------------------------------------------------------------------------
                    case 109 :
                        loadMessage(root, IdentityEnrollmentInfoReqName, 'Classlink.IdentityEnrollmentInfoReq');
                        loadMessage(root, IdentityEnrollmentInfoResName, 'Classlink.IdentityEnrollmentInfoRes');

                        const IdentityEnrollmentInfoReqObj = {
                            ItmIdx: 1,
                        };

                        Data = setDataToSend(root, IdentityEnrollmentInfoReqName, IdentityEnrollmentInfoReqObj);
                        break;

//가입 신청 응답-----------------------------------------------------------------------------------------
                    case 110 :
                        loadMessage(root, IdentityEnrollmentReplyReqName, 'Classlink.IdentityEnrollmentReplyReq');
                        loadMessage(root, IdentityEnrollmentReplyResName, 'Classlink.IdentityEnrollmentReplyRes');

                        const IdentityEnrollmentReplyReqObj = {
                            ItmIdx: 1,
                            IsPermission: 'IsPermission',
                        };

                        Data = setDataToSend(root, IdentityEnrollmentReplyReqName, IdentityEnrollmentReplyReqObj);
                        break;

//아바타 조회-----------------------------------------------------------------------------------------
                    case 103 :
                        loadMessage(root, IdentityAvatarListReqName, 'Classlink.IdentityAvatarListReq');
                        loadMessage(root, IdentityAvatarListResName, 'Classlink.IdentityAvatarListRes');

                        const IdentityAvatarListReqObj = {
                            InsCode: 'InsCode',
                        };

                        Data = setDataToSend(root, IdentityAvatarListReqName, IdentityAvatarListReqObj);
                        break;

//아바타 변경-----------------------------------------------------------------------------------------
                    case 104 :
                        loadMessage(root, IdentityAvatarChangeReqName, 'Classlink.IdentityAvatarChangeReq');
                        loadMessage(root, IdentityAvatarChangeResName, 'Classlink.IdentityAvatarChangeRes');

                        const IdentityAvatarChangeReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'S',
                            AvatarId: 1,
                        };

                        Data = setDataToSend(root, IdentityAvatarChangeReqName, IdentityAvatarChangeReqObj);
                        break;

//사용자 정보 조회-----------------------------------------------------------------------------------------
                    case 129 :
                        loadMessage(root, IdentityProfileDetailReqName, 'Classlink.IdentityProfileDetailReq');
                        loadMessage(root, IdentityProfileDetailResName, 'Classlink.IdentityProfileDetailRes');

                        const IdentityProfileDetailReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                        };

                        Data = setDataToSend(root, IdentityProfileDetailReqName, IdentityProfileDetailReqObj);
                        break;

//사용자 정보 입력-----------------------------------------------------------------------------------------
                    case 111 :
                        loadMessage(root, IdentityProfileUpdateReqName, 'Classlink.IdentityProfileUpdateReq');
                        loadMessage(root, IdentityProfileUpdateResName, 'Classlink.IdentityProfileUpdateRes');

                        const IdentityProfileUpdateReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                            MemName: 'MemName',
                            MemNickName: 'MemNickName',
                            MemEmail: 'MemEmail',
                            MemPhone: 'MemPhone',
                        };

                        Data = setDataToSend(root, IdentityProfileUpdateReqName, IdentityProfileUpdateReqObj);
                        break;

//통계-----------------------------------------------------------------------------------------
                    case 132 :
                        loadMessage(root, LobbyHomeStatisticsReqName, 'Classlink.LobbyHomeStatisticsReq');
                        loadMessage(root, LobbyHomeStatisticsResName, 'Classlink.LobbyHomeStatisticsRes');

                        const LobbyHomeStatisticsReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                        };

                        Data = setDataToSend(root, LobbyHomeStatisticsReqName, LobbyHomeStatisticsReqObj);
                        break;

//학생 소속 교육기관 목록-----------------------------------------------------------------------------------------
                    case 117 :
                        loadMessage(root, LobbyHomeStudentInstitutionListReqName, 'Classlink.LobbyHomeStudentInstitutionListReq');
                        loadMessage(root, LobbyHomeStudentInstitutionListResName, 'Classlink.LobbyHomeStudentInstitutionListRes');

                        const LobbyHomeStudentInstitutionListReqObj = {};

                        Data = setDataToSend(root, LobbyHomeStudentInstitutionListReqName, LobbyHomeStudentInstitutionListReqObj);
                        break;

//프랜차이즈장 보유 교육기관 목록-----------------------------------------------------------------------------------------
                    case 118 :
                        loadMessage(root, LobbyHomeFranchiseInstitutionListReqName, 'Classlink.LobbyHomeFranchiseInstitutionListReq');
                        loadMessage(root, LobbyHomeFranchiseInstitutionListResName, 'Classlink.LobbyHomeFranchiseInstitutionListRes');

                        const LobbyHomeFranchiseInstitutionListReqObj = {};

                        Data = setDataToSend(root, LobbyHomeFranchiseInstitutionListReqName, LobbyHomeFranchiseInstitutionListReqObj);
                        break;

//알림-----------------------------------------------------------------------------------------
                    case 133 :
                        loadMessage(root, LobbyHomeNoticeListReqName, 'Classlink.LobbyHomeNoticeListReq');
                        loadMessage(root, LobbyHomeNoticeListResName, 'Classlink.LobbyHomeNoticeListRes');

                        const LobbyHomeNoticeListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyHomeNoticeListReqName, LobbyHomeNoticeListReqObj);
                        break;

//기간별 일정 목록-----------------------------------------------------------------------------------------
                    case 134 :
                        loadMessage(root, LobbyHomeScheduleListReqName, 'Classlink.LobbyHomeScheduleListReq');
                        loadMessage(root, LobbyHomeScheduleListResName, 'Classlink.LobbyHomeScheduleListRes');

                        const LobbyHomeScheduleListReqObj = {
                            StartTime: 'StartTime',
                            EndTime: 'EndTime',
                        };

                        Data = setDataToSend(root, LobbyHomeScheduleListReqName, LobbyHomeScheduleListReqObj);
                        break;

//기간별 수업 목록-----------------------------------------------------------------------------------------
                    case 114 :
                        loadMessage(root, LobbyHomeClassInfoListReqName, 'Classlink.LobbyHomeClassInfoListReq');
                        loadMessage(root, LobbyHomeClassInfoListResName, 'Classlink.LobbyHomeClassInfoListRes');

                        const LobbyHomeClassInfoListReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                            StartDate: 'StartDate',
                            EndDate: 'EndDate',
                        };

                        Data = setDataToSend(root, LobbyHomeClassInfoListReqName, LobbyHomeClassInfoListReqObj);
                        break;

//오늘의 수업 상세보기-----------------------------------------------------------------------------------------
                    case 115 :
                        loadMessage(root, LobbyHomeTodayClassDetailReqName, 'Classlink.LobbyHomeTodayClassDetailReq');
                        loadMessage(root, LobbyHomeTodayClassDetailResName, 'Classlink.LobbyHomeTodayClassDetailRes');

                        const LobbyHomeTodayClassDetailReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                        };

                        Data = setDataToSend(root, LobbyHomeTodayClassDetailReqName, LobbyHomeTodayClassDetailReqObj);
                        break;

//강의 코스 목록-----------------------------------------------------------------------------------------
                    case 116 :
                        loadMessage(root, LobbyHomeLectureCourseListReqName, 'Classlink.LobbyHomeLectureCourseListReq');
                        loadMessage(root, LobbyHomeLectureCourseListResName, 'Classlink.LobbyHomeLectureCourseListRes');

                        const LobbyHomeLectureCourseListReqObj = {
                            InsCode: 'InsCode',
                            IdentityType: 'IdentityType',
                        };

                        Data = setDataToSend(root, LobbyHomeLectureCourseListReqName, LobbyHomeLectureCourseListReqObj);
                        break;

//테마별 이벤트-----------------------------------------------------------------------------------------
                    case 135 :
                        loadMessage(root, LobbyHomeEventForThemeListReqName, 'Classlink.LobbyHomeEventForThemeListReq');
                        loadMessage(root, LobbyHomeEventForThemeListResName, 'Classlink.LobbyHomeEventForThemeListRes');

                        const LobbyHomeEventForThemeListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyHomeEventForThemeListReqName, LobbyHomeEventForThemeListReqObj);
                        break;

//시스템 공지 리스트-----------------------------------------------------------------------------------------
                    case 136 :
                        loadMessage(root, SWclassInstitutionSystemNoticeListReqName, 'Classlink.SWclassInstitutionSystemNoticeListReq');
                        loadMessage(root, SWclassInstitutionSystemNoticeListResName, 'Classlink.SWclassInstitutionSystemNoticeListRes');

                        const SWclassInstitutionSystemNoticeListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, SWclassInstitutionSystemNoticeListReqName, SWclassInstitutionSystemNoticeListReqObj);
                        break;

//교육기관 공지 리스트-----------------------------------------------------------------------------------------
                    case 137 :
                        loadMessage(root, SWclassInstitutionInstitutionNoticeListReqName, 'Classlink.SWclassInstitutionInstitutionNoticeListReq');
                        loadMessage(root, SWclassInstitutionInstitutionNoticeListResName, 'Classlink.SWclassInstitutionInstitutionNoticeListRes');

                        const SWclassInstitutionInstitutionNoticeListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, SWclassInstitutionInstitutionNoticeListReqName, SWclassInstitutionInstitutionNoticeListReqObj);
                        break;

//프렌차이즈 공지 리스트-----------------------------------------------------------------------------------------
                    case 138 :
                        loadMessage(root, SWclassInstitutionfranchiseNoticeListReqName, 'Classlink.SWclassInstitutionfranchiseNoticeListReq');
                        loadMessage(root, SWclassInstitutionfranchiseNoticeListResName, 'Classlink.SWclassInstitutionfranchiseNoticeListRes');

                        const SWclassInstitutionfranchiseNoticeListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, SWclassInstitutionfranchiseNoticeListReqName, SWclassInstitutionfranchiseNoticeListReqObj);
                        break;

//출결-----------------------------------------------------------------------------------------
                    case 139 :
                        loadMessage(root, SWclassInstitutionAttendanceReqName, 'Classlink.SWclassInstitutionAttendanceReq');
                        loadMessage(root, SWclassInstitutionAttendanceResName, 'Classlink.SWclassInstitutionAttendanceRes');

                        const SWclassInstitutionAttendanceReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, SWclassInstitutionAttendanceReqName, SWclassInstitutionAttendanceReqObj);
                        break;

//선생님 목록-----------------------------------------------------------------------------------------
                    case 119 :
                        loadMessage(root, LobbyInstitutionClassTeacherListReqName, 'Classlink.LobbyInstitutionClassTeacherListReq');
                        loadMessage(root, LobbyInstitutionClassTeacherListResName, 'Classlink.LobbyInstitutionClassTeacherListRes');

                        const LobbyInstitutionClassTeacherListReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyInstitutionClassTeacherListReqName, LobbyInstitutionClassTeacherListReqObj);
                        break;

//선생님 정보-----------------------------------------------------------------------------------------
                    case 140 :
                        loadMessage(root, LobbyInstitutionClassTeacherInfoReqName, 'Classlink.LobbyInstitutionClassTeacherInfoReq');
                        loadMessage(root, LobbyInstitutionClassTeacherInfoResName, 'Classlink.LobbyInstitutionClassTeacherInfoRes');

                        const LobbyInstitutionClassTeacherInfoReqObj = {
                            TchIdx: 1,
                        };

                        Data = setDataToSend(root, LobbyInstitutionClassTeacherInfoReqName, LobbyInstitutionClassTeacherInfoReqObj);
                        break;

//노트함-----------------------------------------------------------------------------------------
                    case 141 :
                        loadMessage(root, LobbyInstitutionBoardNoteBoxReqName, 'Classlink.LobbyInstitutionBoardNoteBoxReq');
                        loadMessage(root, LobbyInstitutionBoardNoteBoxResName, 'Classlink.LobbyInstitutionBoardNoteBoxRes');

                        const LobbyInstitutionBoardNoteBoxReqObj = {
                            InsCode: 'InsCode', //조회방식 미정
                            TarIdentityType: 'TarIdentityType',//조회방식 미정
                        };

                        Data = setDataToSend(root, LobbyInstitutionBoardNoteBoxReqName, LobbyInstitutionBoardNoteBoxReqObj);
                        break;

//필기함-----------------------------------------------------------------------------------------
                    case 142 :
                        loadMessage(root, LobbyInstitutionBoardNotepadReqName, 'Classlink.LobbyInstitutionBoardNotepadReq');
                        loadMessage(root, LobbyInstitutionBoardNotepadResName, 'Classlink.LobbyInstitutionBoardNotepadRes');

                        const LobbyInstitutionBoardNotepadReqObj = {
                            InsCode: 'InsCode', //조회방식 미정
                            TarIdentityType: 'TarIdentityType', //조회방식 미정
                        };

                        Data = setDataToSend(root, LobbyInstitutionBoardNotepadReqName, LobbyInstitutionBoardNotepadReqObj);
                        break;

//과제함-----------------------------------------------------------------------------------------
                    case 143 :
                        loadMessage(root, LobbyInstitutionBoardReportBoxReqName, 'Classlink.LobbyInstitutionBoardReportBoxReq');
                        loadMessage(root, LobbyInstitutionBoardReportBoxResName, 'Classlink.LobbyInstitutionBoardReportBoxRes');

                        const LobbyInstitutionBoardReportBoxReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyInstitutionBoardReportBoxReqName, LobbyInstitutionBoardReportBoxReqObj);
                        break;

//질문함-----------------------------------------------------------------------------------------
                    case 144 :
                        loadMessage(root, LobbyInstitutionBoardQuestionBoxReqName, 'Classlink.LobbyInstitutionBoardQuestionBoxReq');
                        loadMessage(root, LobbyInstitutionBoardQuestionBoxResName, 'Classlink.LobbyInstitutionBoardQuestionBoxRes');

                        const LobbyInstitutionBoardQuestionBoxReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyInstitutionBoardQuestionBoxReqName, LobbyInstitutionBoardQuestionBoxReqObj);
                        break;

//일정-----------------------------------------------------------------------------------------
                    case 145 :
                        loadMessage(root, LobbyCalenderScheduleReqName, 'Classlink.LobbyCalenderScheduleReq');
                        loadMessage(root, LobbyCalenderScheduleResName, 'Classlink.LobbyCalenderScheduleRes');

                        const LobbyCalenderScheduleReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyCalenderScheduleReqName, LobbyCalenderScheduleReqObj);
                        break;

//리포트-----------------------------------------------------------------------------------------
                    case 146 :
                        loadMessage(root, LobbyReportUrlReqName, 'Classlink.LobbyReportUrlReq');
                        loadMessage(root, LobbyReportUrlResName, 'Classlink.LobbyReportUrlRes');

                        const LobbyReportUrlReqObj = {
                            InsCode: 'InsCode',
                            TarIdentityType: 'TarIdentityType',
                        };

                        Data = setDataToSend(root, LobbyReportUrlReqName, LobbyReportUrlReqObj);
                        break;
//CW 관련--------------------------------------------------------------------------------------------------------------------------------------
//퀴즈 문제 은행 리스트-----------------------------------------------------------------------------------------
                    case 149 :
                        loadMessage(root, CWExamQuizListReqName, 'Classlink.CWExamQuizListReq');
                        loadMessage(root, CWExamQuizListResName, 'Classlink.CWExamQuizListRes');

                        const CWExamQuizListReqObj = {

                        };

                        Data = setDataToSend(root, CWExamQuizListReqName, CWExamQuizListReqObj);
                        break;
//퀴즈 활성화-----------------------------------------------------------------------------------------
                    case 150 :
                        loadMessage(root, CWExamQuizActivateReqName, 'Classlink.CWExamQuizActivateReq');
                        loadMessage(root, CWExamQuizActivateResName, 'Classlink.CWExamQuizActivateRes');

                        const CWExamQuizActivateReqObj = {
                            DataTableType :'DataTableType',
                            QuizSetIdx :1,
                            QuestionCount :1,
                            LimitTime :1,
                            IsShowCorrectAnswer :true,
                        };

                        Data = setDataToSend(root, CWExamQuizActivateReqName, CWExamQuizActivateReqObj);
                        break;
//쪽지 시험 활성화-----------------------------------------------------------------------------------------
                    case 152 :
                        loadMessage(root, CWExamNoteExamActiveReqName, 'Classlink.CWExamNoteExamActiveReq');
                        loadMessage(root, CWExamNoteExamActiveResName, 'Classlink.CWExamNoteExamActiveRes');

                        const CWExamNoteExamActiveReqObj = {
                            DataTableType : 'DataTableType',
                            QuizSetIdx : 1,
                        };

                        Data = setDataToSend(root, CWExamNoteExamActiveReqName, CWExamNoteExamActiveReqObj);
                        break;
//질문 등록-----------------------------------------------------------------------------------------
                    case 156 :
                        loadMessage(root, CWQuestionBoxCreateReqName, 'Classlink.CWQuestionBoxCreateReq');
                        loadMessage(root, CWQuestionBoxCreateResName, 'Classlink.CWQuestionBoxCreateRes');

                        const CWQuestionBoxCreateReqObj = {
                            Title : 'Title',
                            Question : 'Question',
                            TeacherIdx : 1,
//repeated FileMetaInfo FileMetaInfoList : 4,
                        };

                        Data = setDataToSend(root, CWQuestionBoxCreateReqName, CWQuestionBoxCreateReqObj);
                        break;
//내 질문 리스트-----------------------------------------------------------------------------------------
                    case 157 :
                        loadMessage(root, CWQuestionBoxListReqName, 'Classlink.CWQuestionBoxListReq');
                        loadMessage(root, CWQuestionBoxListResName, 'Classlink.CWQuestionBoxListRes');

                        const CWQuestionBoxListReqObj = {

                        };

                        Data = setDataToSend(root, CWQuestionBoxListReqName, CWQuestionBoxListReqObj);
                        break;
//내 질문-----------------------------------------------------------------------------------------
                    case 158 :
                        loadMessage(root, CWQuestionBoxQuestionDetailReqName, 'Classlink.CWQuestionBoxQuestionDetailReq');
                        loadMessage(root, CWQuestionBoxQuestionDetailResName, 'Classlink.CWQuestionBoxQuestionDetailRes');

                        const CWQuestionBoxQuestionDetailReqObj = {
                            QuestionIdx : 1,
                        };

                        Data = setDataToSend(root, CWQuestionBoxQuestionDetailReqName, CWQuestionBoxQuestionDetailReqObj);
                        break;
//수업반 기본 정보-----------------------------------------------------------------------------------------
                    case 159 :
                        loadMessage(root, CWInfoBasicInfoReqName, 'Classlink.CWInfoBasicInfoReq');
                        loadMessage(root, CWInfoBasicInfoResName, 'Classlink.CWInfoBasicInfoRes');

                        const CWInfoBasicInfoReqObj = {

                            LecBidx : 1,

                        };

                        Data = setDataToSend(root, CWInfoBasicInfoReqName, CWInfoBasicInfoReqObj);
                        break;
//커리큘럼 리스트-----------------------------------------------------------------------------------------
                    case 202 :
                        loadMessage(root, CWCurriculumListReqName, 'Classlink.CWCurriculumListReq');
                        loadMessage(root, CWCurriculumListResName, 'Classlink.CWCurriculumListRes');

                        const CWCurriculumListReqObj = {

                            LecBidx : 1,

                        };

                        Data = setDataToSend(root, CWCurriculumListReqName, CWCurriculumListReqObj);
                        break;
//커리큘럼 변경 적용-----------------------------------------------------------------------------------------
                    case 160 :
                        loadMessage(root, CWCurriculumChangeReqName, 'Classlink.CWCurriculumChangeReq');
                        loadMessage(root, CWCurriculumChangeResName, 'Classlink.CWCurriculumChangeRes');

                        const CWCurriculumChangeReqObj = {
                            CurriculumIdx : 1,
                        };

                        Data = setDataToSend(root, CWCurriculumChangeReqName, CWCurriculumChangeReqObj);
                        break;
//채팅창 유저 정보-----------------------------------------------------------------------------------------
                    case 200 :
                        loadMessage(root, CWMessengerChatUserInfoReqName, 'Classlink.CWMessengerChatUserInfoReq');
                        loadMessage(root, CWMessengerChatUserInfoResName, 'Classlink.CWMessengerChatUserInfoRes');

                        const CWMessengerChatUserInfoReqObj = {
                            MemIdx : 1,
                            IdentityType : 'IdentityType',
                        };

                        Data = setDataToSend(root, CWMessengerChatUserInfoReqName, CWMessengerChatUserInfoReqObj);
                        break;
//내 정보-----------------------------------------------------------------------------------------
                    case 161 :
                        loadMessage(root, CWMyInfoChangeReqName, 'Classlink.CWMyInfoChangeReq');
                        loadMessage(root, CWMyInfoChangeResName, 'Classlink.CWMyInfoChangeRes');

                        const CWMyInfoChangeReqObj = {
                            IdentityType : 'IdentityType',
                            NickName : 'NickName',
                            Email : 'Email',
                            Phone: 'Phone',
                        };

                        Data = setDataToSend(root, CWMyInfoChangeReqName, CWMyInfoChangeReqObj);
                        break;

                }

                const RequestPacketObj = {
                    OpCode: OpCode,
                    AccessToken: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NzIzMDgzNTgsInVzZXJfbmFtZSI6InRlc3Q3Nzc3IiwianRpIjoiNTdjOTFmY2YtODlhYi00YWVlLThhOTMtOGQ1ZGY5MDg1MzliIiwiY2xpZW50X2lkIjoiY2xhc3NsaW5rIiwic2NvcGUiOlsiY2xpZW50Il19.mDtGORT9yMbF4Gg9XUNBWmgjfR7IxXx36V99TnCNoik",
                    InstanceId: '2',
                    Data: Data
                };

                console.log("INFO: send triggered.");
                socket.send(setDataToSend(root, RequestPacketName, RequestPacketObj));
                console.time("TIME");

                if (socket.readyState !== 1)
                    return;
            });

        });

    });

    //---------------------------------------------------------------------------------------------------
    // connectWS 전체적인 설명
    // 1. new WebSocket()을 통해서 서버와 소켓연결을 하고 socket변수에 담는다(나중에 socket.send할때 사용하기위함)
    // 2. websocket이 연결이되면 ws.onopen()에 연결된 함수가 실행된다.
    // 3. websocket을 통해 send를하면 ws:localhost:8301/api로 데이터를 보내고, ws:localhost:8301/api에 연결된 브라우저에게
    // 스프링이 데이터를 보내는데, 그 데이터를 ws.onmessage에서 switch문에 opCode를 가져와서
    // 분기되서 받아볼수있다.
    // (자세한 부분은 readBlobDataAsync함수를 살펴보기!)
    // 4. ws.onclose는 소켓통신이 중단되면 실행되는 함수이다.

    let socket = null;

    let data = null;

    // pure web-socket
    function connectWS() {
        // var ws = new WebSocket("ws:112.171.101.31:45170/api");
        const ws = new WebSocket("ws:localhost:8301/api");
        socket = ws;

        ws.onopen = function () {
            console.log("INFO: connection opened.");
        };

        ws.onmessage = async function (event) {
            console.timeEnd("TIME");
            console.log("INFO: onmessage triggered.");

            let blob = event.data;

            const receivedPacketData = await readBlobDataAsync(blob, ResponsePacketName);

            switch (receivedPacketData.OpCode) {
//WorldSet 정보-----------------------------------------------------------------------------------------
                case 120 :
                    const receivedSysWorldSetInfoResData = window[SysWorldSetInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedSysWorldSetInfoResData mmmmmmmmmmmm>>', receivedSysWorldSetInfoResData);
                    break;
//Interaction Object Create-----------------------------------------------------------------------------------------
                case 127 :
                    const receivedSysWorldInterObjSetPackageCreateResData = window[SysWorldInterObjSetPackageCreateResName].decode(receivedPacketData.Data);
                    console.log('receivedSysWorldInterObjSetPackageCreateResData mmmmmmmmmmmm>>', receivedSysWorldInterObjSetPackageCreateResData);
                    break;
//Interaction Object Create-----------------------------------------------------------------------------------------
                case 201 :
                    const receivedSysWorldInterObjSetCurriculumCreateResData = window[SysWorldInterObjSetCurriculumCreateResName].decode(receivedPacketData.Data);
                    console.log('receivedSysWorldInterObjSetCurriculumCreateResData mmmmmmmmmmmm>>', receivedSysWorldInterObjSetCurriculumCreateResData);
                    break;
//Interaction Object Init-----------------------------------------------------------------------------------------
                case 128 :
                    const receivedSysWorldInterObjSetCurriculumInitResData = window[SysWorldInterObjSetCurriculumInitResName].decode(receivedPacketData.Data);
                    console.log('receivedSysWorldInterObjSetCurriculumInitResData mmmmmmmmmmmm>>', receivedSysWorldInterObjSetCurriculumInitResData);
                    break;

//최근 접속 교육기관 update-----------------------------------------------------------------------------------------
                case 112 :
                    const receivedLoginInstituteRegistResData = window[LoginInstituteRegistResName].decode(receivedPacketData.Data);
                    console.log('receivedLoginInstituteRegistResData mmmmmmmmmmmm>>', receivedLoginInstituteRegistResData);
                    break;

//최근 접속 신분 update-----------------------------------------------------------------------------------------
                case 113 :
                    const receivedLoginIdentityRegistResData = window[LoginIdentityRegistResName].decode(receivedPacketData.Data);
                    console.log('receivedLoginIdentityRegistResData mmmmmmmmmmmm>>', receivedLoginIdentityRegistResData);
                    break;

//신분 생성-----------------------------------------------------------------------------------------
                case 100 :
                    const receivedIdentityCreateResData = window[IdentityCreateResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityCreateResData mmmmmmmmmmmm>>', receivedIdentityCreateResData);
                    break;

//신분 조회-----------------------------------------------------------------------------------------
                case 101 :
                    const receivedIdentityListResData = window[IdentityListResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityListResData mmmmmmmmmmmm>>', receivedIdentityListResData);
                    break;

//신분 선택-----------------------------------------------------------------------------------------
                case 102 :
                    const receivedIdentityChangeResData = window[IdentityChangeResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityChangeResData mmmmmmmmmmmm>>', receivedIdentityChangeResData);
                    break;

//교육기관 등록 요청-----------------------------------------------------------------------------------------
                case 106 :
                    const receivedIdentityInstitutionEnrollmentResData = window[IdentityInstitutionEnrollmentResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityInstitutionEnrollmentResData mmmmmmmmmmmm>>', receivedIdentityInstitutionEnrollmentResData);
                    break;

//입력한 교육기관 정보 확인-----------------------------------------------------------------------------------------
                case 105 :
                    const receivedIdentityInstitutionInfoResData = window[IdentityInstitutionInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityInstitutionInfoResData mmmmmmmmmmmm>>', receivedIdentityInstitutionInfoResData);
                    break;

//가입 신청 리스트-----------------------------------------------------------------------------------------
                case 107 :
                    const receivedIdentityEnrollmentListResData = window[IdentityEnrollmentListResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityEnrollmentListResData mmmmmmmmmmmm>>', receivedIdentityEnrollmentListResData);
                    break;

//가입 신청 확인-----------------------------------------------------------------------------------------
                case 108 :
                    const receivedIdentityEnrollmentConfirmResData = window[IdentityEnrollmentConfirmResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityEnrollmentConfirmResData mmmmmmmmmmmm>>', receivedIdentityEnrollmentConfirmResData);
                    break;

//가입 신청인 정보-----------------------------------------------------------------------------------------
                case 109 :
                    const receivedIdentityEnrollmentInfoResData = window[IdentityEnrollmentInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityEnrollmentInfoResData mmmmmmmmmmmm>>', receivedIdentityEnrollmentInfoResData);
                    break;

//가입 신청 응답-----------------------------------------------------------------------------------------
                case 110 :
                    const receivedIdentityEnrollmentReplyResData = window[IdentityEnrollmentReplyResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityEnrollmentReplyResData mmmmmmmmmmmm>>', receivedIdentityEnrollmentReplyResData);
                    break;

//아바타 조회-----------------------------------------------------------------------------------------
                case 103 :
                    const receivedIdentityAvatarListResData = window[IdentityAvatarListResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityAvatarListResData mmmmmmmmmmmm>>', receivedIdentityAvatarListResData);
                    break;

//아바타 변경-----------------------------------------------------------------------------------------
                case 104 :
                    const receivedIdentityAvatarChangeResData = window[IdentityAvatarChangeResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityAvatarChangeResData mmmmmmmmmmmm>>', receivedIdentityAvatarChangeResData);
                    break;

//사용자 정보 조회-----------------------------------------------------------------------------------------
                case 129 :
                    const receivedIdentityProfileDetailResData = window[IdentityProfileDetailResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityProfileDetailResData mmmmmmmmmmmm>>', receivedIdentityProfileDetailResData);
                    break;

//사용자 정보 입력-----------------------------------------------------------------------------------------
                case 111 :
                    const receivedIdentityProfileUpdateResData = window[IdentityProfileUpdateResName].decode(receivedPacketData.Data);
                    console.log('receivedIdentityProfileUpdateResData mmmmmmmmmmmm>>', receivedIdentityProfileUpdateResData);
                    break;

//통계-----------------------------------------------------------------------------------------
                case 132 :
                    const receivedLobbyHomeStatisticsResData = window[LobbyHomeStatisticsResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeStatisticsResData mmmmmmmmmmmm>>', receivedLobbyHomeStatisticsResData);
                    break;

//학생 소속 교육기관 목록-----------------------------------------------------------------------------------------
                case 117 :
                    const receivedLobbyHomeStudentInstitutionListResData = window[LobbyHomeStudentInstitutionListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeStudentInstitutionListResData mmmmmmmmmmmm>>', receivedLobbyHomeStudentInstitutionListResData);
                    break;

//프랜차이즈장 보유 교육기관 목록-----------------------------------------------------------------------------------------
                case 118 :
                    const receivedLobbyHomeFranchiseInstitutionListResData = window[LobbyHomeFranchiseInstitutionListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeFranchiseInstitutionListResData mmmmmmmmmmmm>>', receivedLobbyHomeFranchiseInstitutionListResData);
                    break;

//알림-----------------------------------------------------------------------------------------
                case 133 :
                    const receivedLobbyHomeNoticeListResData = window[LobbyHomeNoticeListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeNoticeListResData mmmmmmmmmmmm>>', receivedLobbyHomeNoticeListResData);
                    break;

//기간별 일정 목록-----------------------------------------------------------------------------------------
                case 134 :
                    const receivedLobbyHomeScheduleListResData = window[LobbyHomeScheduleListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeScheduleListResData mmmmmmmmmmmm>>', receivedLobbyHomeScheduleListResData);
                    break;

//기간별 수업 목록-----------------------------------------------------------------------------------------
                case 114 :
                    const receivedLobbyHomeClassInfoListResData = window[LobbyHomeClassInfoListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeClassInfoListResData mmmmmmmmmmmm>>', receivedLobbyHomeClassInfoListResData);
                    break;

//오늘의 수업 상세보기-----------------------------------------------------------------------------------------
                case 115 :
                    const receivedLobbyHomeTodayClassDetailResData = window[LobbyHomeTodayClassDetailResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeTodayClassDetailResData mmmmmmmmmmmm>>', receivedLobbyHomeTodayClassDetailResData);
                    break;

//강의 코스 목록-----------------------------------------------------------------------------------------
                case 116 :
                    const receivedLobbyHomeLectureCourseListResData = window[LobbyHomeLectureCourseListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeLectureCourseListResData mmmmmmmmmmmm>>', receivedLobbyHomeLectureCourseListResData);
                    break;

//테마별 이벤트-----------------------------------------------------------------------------------------
                case 135 :
                    const receivedLobbyHomeEventForThemeListResData = window[LobbyHomeEventForThemeListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyHomeEventForThemeListResData mmmmmmmmmmmm>>', receivedLobbyHomeEventForThemeListResData);
                    break;

//시스템 공지 리스트-----------------------------------------------------------------------------------------
                case 136 :
                    const receivedSWclassInstitutionSystemNoticeListResData = window[SWclassInstitutionSystemNoticeListResName].decode(receivedPacketData.Data);
                    console.log('receivedSWclassInstitutionSystemNoticeListResData mmmmmmmmmmmm>>', receivedSWclassInstitutionSystemNoticeListResData);
                    break;

//교육기관 공지 리스트-----------------------------------------------------------------------------------------
                case 137 :
                    const receivedSWclassInstitutionInstitutionNoticeListResData = window[SWclassInstitutionInstitutionNoticeListResName].decode(receivedPacketData.Data);
                    console.log('receivedSWclassInstitutionInstitutionNoticeListResData mmmmmmmmmmmm>>', receivedSWclassInstitutionInstitutionNoticeListResData);
                    break;

//프렌차이즈 공지 리스트-----------------------------------------------------------------------------------------
                case 138 :
                    const receivedSWclassInstitutionfranchiseNoticeListResData = window[SWclassInstitutionfranchiseNoticeListResName].decode(receivedPacketData.Data);
                    console.log('receivedSWclassInstitutionfranchiseNoticeListResData mmmmmmmmmmmm>>', receivedSWclassInstitutionfranchiseNoticeListResData);
                    break;

//출결-----------------------------------------------------------------------------------------
                case 139 :
                    const receivedSWclassInstitutionAttendanceResData = window[SWclassInstitutionAttendanceResName].decode(receivedPacketData.Data);
                    console.log('receivedSWclassInstitutionAttendanceResData mmmmmmmmmmmm>>', receivedSWclassInstitutionAttendanceResData);
                    break;

//선생님 목록-----------------------------------------------------------------------------------------
                case 119 :
                    const receivedLobbyInstitutionClassTeacherListResData = window[LobbyInstitutionClassTeacherListResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionClassTeacherListResData mmmmmmmmmmmm>>', receivedLobbyInstitutionClassTeacherListResData);
                    break;

//선생님 정보-----------------------------------------------------------------------------------------
                case 140 :
                    const receivedLobbyInstitutionClassTeacherInfoResData = window[LobbyInstitutionClassTeacherInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionClassTeacherInfoResData mmmmmmmmmmmm>>', receivedLobbyInstitutionClassTeacherInfoResData);
                    break;

//노트함-----------------------------------------------------------------------------------------
                case 141 :
                    const receivedLobbyInstitutionBoardNoteBoxResData = window[LobbyInstitutionBoardNoteBoxResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionBoardNoteBoxResData mmmmmmmmmmmm>>', receivedLobbyInstitutionBoardNoteBoxResData);
                    break;

//필기함-----------------------------------------------------------------------------------------
                case 142 :
                    const receivedLobbyInstitutionBoardNotepadResData = window[LobbyInstitutionBoardNotepadResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionBoardNotepadResData mmmmmmmmmmmm>>', receivedLobbyInstitutionBoardNotepadResData);
                    break;

//과제함-----------------------------------------------------------------------------------------
                case 143 :
                    const receivedLobbyInstitutionBoardReportBoxResData = window[LobbyInstitutionBoardReportBoxResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionBoardReportBoxResData mmmmmmmmmmmm>>', receivedLobbyInstitutionBoardReportBoxResData);
                    break;

//질문함-----------------------------------------------------------------------------------------
                case 144 :
                    const receivedLobbyInstitutionBoardQuestionBoxResData = window[LobbyInstitutionBoardQuestionBoxResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyInstitutionBoardQuestionBoxResData mmmmmmmmmmmm>>', receivedLobbyInstitutionBoardQuestionBoxResData);
                    break;

//일정-----------------------------------------------------------------------------------------
                case 145 :
                    const receivedLobbyCalenderScheduleResData = window[LobbyCalenderScheduleResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyCalenderScheduleResData mmmmmmmmmmmm>>', receivedLobbyCalenderScheduleResData);
                    break;

//리포트-----------------------------------------------------------------------------------------
                case 146 :
                    const receivedLobbyReportUrlResData = window[LobbyReportUrlResName].decode(receivedPacketData.Data);
                    console.log('receivedLobbyReportUrlResData mmmmmmmmmmmm>>', receivedLobbyReportUrlResData);
                    break;
//cw-------------------------------------------------------------------------------------------------------------------------------
//퀴즈 문제 은행 리스트-----------------------------------------------------------------------------------------
                case 149 :
                    const receivedCWExamQuizListResData = window[CWExamQuizListResName].decode(receivedPacketData.Data);
                    console.log('receivedCWExamQuizListResData mmmmmmmmmmmm>>', receivedCWExamQuizListResData);
                    break;
//퀴즈 활성화-----------------------------------------------------------------------------------------
                case 150 :
                    const receivedCWExamQuizActivateResData = window[CWExamQuizActivateResName].decode(receivedPacketData.Data);
                    console.log('receivedCWExamQuizActivateResData mmmmmmmmmmmm>>', receivedCWExamQuizActivateResData);
                    break;
//쪽지 시험 활성화-----------------------------------------------------------------------------------------
                case 152 :
                    const receivedCWExamNoteExamActiveResData = window[CWExamNoteExamActiveResName].decode(receivedPacketData.Data);
                    console.log('receivedCWExamNoteExamActiveResData mmmmmmmmmmmm>>', receivedCWExamNoteExamActiveResData);
                    break;
//질문 등록-----------------------------------------------------------------------------------------
                case 156 :
                    const receivedCWQuestionBoxCreateResData = window[CWQuestionBoxCreateResName].decode(receivedPacketData.Data);
                    console.log('receivedCWQuestionBoxCreateResData mmmmmmmmmmmm>>', receivedCWQuestionBoxCreateResData);
                    break;
//내 질문 리스트-----------------------------------------------------------------------------------------
                case 157 :
                    const receivedCWQuestionBoxListResData = window[CWQuestionBoxListResName].decode(receivedPacketData.Data);
                    console.log('receivedCWQuestionBoxListResData mmmmmmmmmmmm>>', receivedCWQuestionBoxListResData);
                    break;
//내 질문-----------------------------------------------------------------------------------------
                case 158 :
                    const receivedCWQuestionBoxQuestionDetailResData = window[CWQuestionBoxQuestionDetailResName].decode(receivedPacketData.Data);
                    console.log('receivedCWQuestionBoxQuestionDetailResData mmmmmmmmmmmm>>', receivedCWQuestionBoxQuestionDetailResData);
                    break;
//수업반 기본 정보-----------------------------------------------------------------------------------------
                case 159 :
                    const receivedCWInfoBasicInfoResData = window[CWInfoBasicInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedCWInfoBasicInfoResData mmmmmmmmmmmm>>', receivedCWInfoBasicInfoResData);
                    break;
//커리큘럼 리스트-----------------------------------------------------------------------------------------
                case 202 :
                    const receivedCWCurriculumListResData = window[CWCurriculumListResName].decode(receivedPacketData.Data);
                    console.log('receivedCWCurriculumListResData mmmmmmmmmmmm>>', receivedCWCurriculumListResData);
                    break;
//커리큘럼 변경 적용-----------------------------------------------------------------------------------------
                case 160 :
                    const receivedCWCurriculumChangeResData = window[CWCurriculumChangeResName].decode(receivedPacketData.Data);
                    console.log('receivedCWCurriculumChangeResData mmmmmmmmmmmm>>', receivedCWCurriculumChangeResData);
                    break;
//채팅창 유저 정보-----------------------------------------------------------------------------------------
                case 200 :
                    const receivedCWMessengerChatUserInfoResData = window[CWMessengerChatUserInfoResName].decode(receivedPacketData.Data);
                    console.log('receivedCWMessengerChatUserInfoResData mmmmmmmmmmmm>>', receivedCWMessengerChatUserInfoResData);
                    break;
//내 정보-----------------------------------------------------------------------------------------
                case 161 :
                    const receivedCWMyInfoChangeResData = window[CWMyInfoChangeResName].decode(receivedPacketData.Data);
                    console.log('receivedCWMyInfoChangeResData mmmmmmmmmmmm>>', receivedCWMyInfoChangeResData);
                    break;

                default:
                    break;
            }
        };

        ws.onclose = function (event) {
            console.log("INFO: connection closed.");
            //setTimeout( function(){ connect(); }, 1000); // retry connection!!
        };

        ws.onerror = function (err) {
            console.log("Error:", err);
        };
    }
</script>
</body>
</html>
