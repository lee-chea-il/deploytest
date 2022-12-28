package com.classlink.websocket.api.lobby;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.lobby.domain.dto.proto.*;
import com.classlink.websocket.api.lobby.domain.param.proto.*;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LobbyHomeService {

    private final LobbyHomeMapper lobbyHomeMapper;

    //protobuf 자동생성된 api들

    public BinaryMessage findLobbyHomeStatistics(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeStatisticsReqProto.LobbyHomeStatisticsReq lobbyHomeStatisticsReq = LobbyHomeStatisticsReqProto.LobbyHomeStatisticsReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes.InsStatisticInfo insStatisticInfo = LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes.InsStatisticInfo.newBuilder()
                .setJoinInsCnt(1)
                .setUserCnt(1)
                .setEnrollmentCnt(1)
                .setSearchInsCode(1)
                .setDataCnt(1)
                .setLessonCnt(1)
                .setCurriculumCnt(1)
                .setWorldSetCnt(1)
                .build();

        List<LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes.InsStatisticInfo> monthInsStatisticInfoList = Arrays.asList(insStatisticInfo);
        List<LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes.InsStatisticInfo> yearInsStatisticInfoList = Arrays.asList(insStatisticInfo);

        LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes lobbyHomeStatisticsRes = LobbyHomeStatisticsResProto.LobbyHomeStatisticsRes.newBuilder()
                .addAllMonthInsStatisticInfoList(monthInsStatisticInfoList)
                .addAllYearInsStatisticInfoList(yearInsStatisticInfoList)
                .setStatisticsDetailUrl("클래스").build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeStatisticsRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeStudentInstitutionList(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        LobbyHomeStudentInstitutionListReqProto.LobbyHomeStudentInstitutionListReq lobbyHomeStudentInstitutionListReq = LobbyHomeStudentInstitutionListReqProto.LobbyHomeStudentInstitutionListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution studentInstitution = LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution.newBuilder()
                .setInsCode("testA")
                .setInsName("클래스링크어학원")
                .setInsLogoImgUrl("/img/logo/1123a4e.png")
                .setInsDesc("인성도 최고, 성적도 최고, 학생들이 최고의 결과를 만들 수 있도록 도와드리겠습니다.")
                .setInsImgUrl("/img/img/1583eg.png")
                .setItmAccYn(true)
                .setRtiRegistrationDate("2022-12-21")
                .build();

        List<LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.StudentInstitution> studentInstitutions = Arrays.asList(studentInstitution);

        LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes lobbyHomeStudentInstitutionListRes = LobbyHomeStudentInstitutionListResProto.LobbyHomeStudentInstitutionListRes.newBuilder().addAllStudentInstitutionList(studentInstitutions).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeStudentInstitutionListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeFranchiseInstitutionList(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        LobbyHomeFranchiseInstitutionListReqProto.LobbyHomeFranchiseInstitutionListReq lobbyHomeFranchiseInstitutionListReq = LobbyHomeFranchiseInstitutionListReqProto.LobbyHomeFranchiseInstitutionListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution franchiseInstitution = LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution.newBuilder()
                .setInsCode("testA")
                .setInsName("클래스링크어학원")
                .setInsLogoUrl("/img/logo/1123a4e.png")
                .setTotalUserCnt(97)
                .setChangedUserCnt(20)
                .setRequestedDate("2022-12-21")
                .setIsPermission(true)
                .setLinkUrl("http://classlink.com/franchise/detail/page")
                .build();

        List<LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.FranchiseInstitution> franchiseInstitutions = Arrays.asList(franchiseInstitution);

        LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes lobbyHomeFranchiseInstitutionListRes = LobbyHomeFranchiseInstitutionListResProto.LobbyHomeFranchiseInstitutionListRes.newBuilder().addAllFranchiseInstitutionList(franchiseInstitutions).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeFranchiseInstitutionListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeNoticeList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeNoticeListReqProto.LobbyHomeNoticeListReq lobbyHomeNoticeListReq = LobbyHomeNoticeListReqProto.LobbyHomeNoticeListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeNoticeListResProto.LobbyHomeNoticeListRes.Notice notice = LobbyHomeNoticeListResProto.LobbyHomeNoticeListRes.Notice.newBuilder()
                .setNoticeType("클래스")
                .setNoticeText("클래스")
                .setNoticeTime("클래스")
                .build();

        List<LobbyHomeNoticeListResProto.LobbyHomeNoticeListRes.Notice> notices = Arrays.asList(notice);

        LobbyHomeNoticeListResProto.LobbyHomeNoticeListRes lobbyHomeNoticeListRes = LobbyHomeNoticeListResProto.LobbyHomeNoticeListRes.newBuilder().addAllNoticeList(notices).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeNoticeListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeScheduleList(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        LobbyHomeScheduleListReqProto.LobbyHomeScheduleListReq lobbyHomeScheduleListReq = LobbyHomeScheduleListReqProto.LobbyHomeScheduleListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo scheduleInfo = LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo.newBuilder()
                .setScheduleId(1)
                .setScheduleName("수학과제")
                .setStartTime("2022-12-21")
                .setEndTime("2022-12-22")
                .build();

        List<LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.ScheduleInfo> scheduleInfos = Arrays.asList(scheduleInfo);

        LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes lobbyHomeScheduleListRes = LobbyHomeScheduleListResProto.LobbyHomeScheduleListRes.newBuilder().addAllScheduleInfoList(scheduleInfos).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeScheduleListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeClassInfoList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeClassInfoListReqProto.LobbyHomeClassInfoListReq lobbyHomeClassInfoListReq = LobbyHomeClassInfoListReqProto.LobbyHomeClassInfoListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeClassInfoListResProto.LobbyHomeClassInfoListRes.ClassInfo classInfo = LobbyHomeClassInfoListResProto.LobbyHomeClassInfoListRes.ClassInfo.newBuilder()
                .setLecBidx(1)
                .setLecTitle("클래스")
                .setTeacherName("클래스")
                .setLecTimeStime("클래스")
                .setLecTimeEtime("클래스")
                .build();

        List<LobbyHomeClassInfoListResProto.LobbyHomeClassInfoListRes.ClassInfo> classInfos = Arrays.asList(classInfo);

        LobbyHomeClassInfoListResProto.LobbyHomeClassInfoListRes lobbyHomeClassInfoListRes = LobbyHomeClassInfoListResProto.LobbyHomeClassInfoListRes.newBuilder().addAllClassInfoList(classInfos).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeClassInfoListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeTodayClassDetail(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeTodayClassDetailReqProto.LobbyHomeTodayClassDetailReq lobbyHomeTodayClassDetailReq = LobbyHomeTodayClassDetailReqProto.LobbyHomeTodayClassDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeTodayClassDetailResProto.LobbyHomeTodayClassDetailRes.TodayClass todayClass = LobbyHomeTodayClassDetailResProto.LobbyHomeTodayClassDetailRes.TodayClass.newBuilder()
                .setLecTitle("클래스")
                .setTeacherName("클래스")
                .setTeacherImgUrl("클래스")
                .setLecTimeStime("클래스")
                .setLecTimeEtime("클래스")
                .setLecImgUrl("클래스")
                .setIsLive(true)
                .build();

        LobbyHomeTodayClassDetailResProto.LobbyHomeTodayClassDetailRes lobbyHomeTodayClassDetailRes = LobbyHomeTodayClassDetailResProto.LobbyHomeTodayClassDetailRes.newBuilder().setTodayClassData(todayClass).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeTodayClassDetailRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeLectureCourseList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeLectureCourseListReqProto.LobbyHomeLectureCourseListReq lobbyHomeLectureCourseListReq = LobbyHomeLectureCourseListReqProto.LobbyHomeLectureCourseListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeLectureCourseListResProto.LobbyHomeLectureCourseListRes.LectureCourse lectureCourse = LobbyHomeLectureCourseListResProto.LobbyHomeLectureCourseListRes.LectureCourse.newBuilder()
                .setLecBidx(1)
                .setLecImgUrl("클래스")
                .setLecTitle("클래스")
                .setSubjectTitle("클래스")
                .setClassName("클래스")
                .setTeacherName("클래스")
                .setLecTimeSdate("클래스")
                .setLecTimeStime("클래스")
                .setIsLive(true)
                .build();

        List<LobbyHomeLectureCourseListResProto.LobbyHomeLectureCourseListRes.LectureCourse> lectureCourses = Arrays.asList(lectureCourse);

        LobbyHomeLectureCourseListResProto.LobbyHomeLectureCourseListRes lobbyHomeLectureCourseListRes = LobbyHomeLectureCourseListResProto.LobbyHomeLectureCourseListRes.newBuilder().addAllLectureCourseList(lectureCourses).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeLectureCourseListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyHomeEventForThemeList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyHomeEventForThemeListReqProto.LobbyHomeEventForThemeListReq lobbyHomeEventForThemeListReq = LobbyHomeEventForThemeListReqProto.LobbyHomeEventForThemeListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyHomeEventForThemeListResProto.LobbyHomeEventForThemeListRes.EventForTheme eventForTheme = LobbyHomeEventForThemeListResProto.LobbyHomeEventForThemeListRes.EventForTheme.newBuilder()
                .setEventTheme("클래스")
                .setEventImgUrl("클래스")
                .setEventTitle("클래스")
                .build();

        List<LobbyHomeEventForThemeListResProto.LobbyHomeEventForThemeListRes.EventForTheme> eventForThemes = Arrays.asList(eventForTheme);

        LobbyHomeEventForThemeListResProto.LobbyHomeEventForThemeListRes lobbyHomeEventForThemeListRes = LobbyHomeEventForThemeListResProto.LobbyHomeEventForThemeListRes.newBuilder().addAllEventForThemeList(eventForThemes).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeEventForThemeListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findSwclassInstitutionSystemNoticeList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        SWclassInstitutionSystemNoticeListReqProto.SWclassInstitutionSystemNoticeListReq sWclassInstitutionSystemNoticeListReq = SWclassInstitutionSystemNoticeListReqProto.SWclassInstitutionSystemNoticeListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        SWclassInstitutionSystemNoticeListResProto.SWclassInstitutionSystemNoticeListRes.SystemNotice systemNotice = SWclassInstitutionSystemNoticeListResProto.SWclassInstitutionSystemNoticeListRes.SystemNotice.newBuilder()
                .setBrdId("클래스")
                .setSysNtcImgUrl("클래스")
                .setSysNtcTitle("클래스")
                .setDetailInfoUrl("클래스")
                .build();

        List<SWclassInstitutionSystemNoticeListResProto.SWclassInstitutionSystemNoticeListRes.SystemNotice> systemNotices = Arrays.asList(systemNotice);

        SWclassInstitutionSystemNoticeListResProto.SWclassInstitutionSystemNoticeListRes sWclassInstitutionSystemNoticeListRes = SWclassInstitutionSystemNoticeListResProto.SWclassInstitutionSystemNoticeListRes.newBuilder().addAllSystemNoticeList(systemNotices).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(sWclassInstitutionSystemNoticeListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findSwclassInstitutionInstitutionNoticeList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        SWclassInstitutionInstitutionNoticeListReqProto.SWclassInstitutionInstitutionNoticeListReq sWclassInstitutionInstitutionNoticeListReq = SWclassInstitutionInstitutionNoticeListReqProto.SWclassInstitutionInstitutionNoticeListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        SWclassInstitutionInstitutionNoticeListResProto.SWclassInstitutionInstitutionNoticeListRes.InstitutionNotice institutionNotice = SWclassInstitutionInstitutionNoticeListResProto.SWclassInstitutionInstitutionNoticeListRes.InstitutionNotice.newBuilder()
                .setBrdId("클래스")
                .setInstiNtcType("클래스")
                .setInstiNtcTitle("클래스")
                .setInstiNtcDate("클래스")
                .setDetailInfoUrl("클래스")
                .build();

        List<SWclassInstitutionInstitutionNoticeListResProto.SWclassInstitutionInstitutionNoticeListRes.InstitutionNotice> institutionNotices = Arrays.asList(institutionNotice);

        SWclassInstitutionInstitutionNoticeListResProto.SWclassInstitutionInstitutionNoticeListRes sWclassInstitutionInstitutionNoticeListRes = SWclassInstitutionInstitutionNoticeListResProto.SWclassInstitutionInstitutionNoticeListRes.newBuilder().addAllInstitutionNoticeList(institutionNotices).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(sWclassInstitutionInstitutionNoticeListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findSwclassInstitutionFranchiseNoticeList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        SWclassInstitutionfranchiseNoticeListReqProto.SWclassInstitutionfranchiseNoticeListReq sWclassInstitutionfranchiseNoticeListReq = SWclassInstitutionfranchiseNoticeListReqProto.SWclassInstitutionfranchiseNoticeListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        SWclassInstitutionfranchiseNoticeListResProto.SWclassInstitutionfranchiseNoticeListRes.FranchiseNotice franchiseNotice = SWclassInstitutionfranchiseNoticeListResProto.SWclassInstitutionfranchiseNoticeListRes.FranchiseNotice.newBuilder()
                .setBrdId("클래스")
                .setFranNtcType("클래스")
                .setFranNtcTitle("클래스")
                .setFranNtcDate("클래스")
                .setUserType("클래스")
                .setDetailInfoUrl("클래스")
                .build();

        List<SWclassInstitutionfranchiseNoticeListResProto.SWclassInstitutionfranchiseNoticeListRes.FranchiseNotice> franchiseNotices = Arrays.asList(franchiseNotice);

        SWclassInstitutionfranchiseNoticeListResProto.SWclassInstitutionfranchiseNoticeListRes sWclassInstitutionfranchiseNoticeListRes = SWclassInstitutionfranchiseNoticeListResProto.SWclassInstitutionfranchiseNoticeListRes.newBuilder().addAllFranchiseNoticeList(franchiseNotices).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(sWclassInstitutionfranchiseNoticeListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findSwclassInstitutionAttendance(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        SWclassInstitutionAttendanceReqProto.SWclassInstitutionAttendanceReq sWclassInstitutionAttendanceReq = SWclassInstitutionAttendanceReqProto.SWclassInstitutionAttendanceReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        SWclassInstitutionAttendanceResProto.SWclassInstitutionAttendanceRes.Attendance attendance = SWclassInstitutionAttendanceResProto.SWclassInstitutionAttendanceRes.Attendance.newBuilder()
                .setBrdId("클래스")
                .setInstiLogoImg("클래스")
                .setInsName("클래스")
                .setTemperature("클래스")
                .setAttendanceDate("클래스")
                .setAttendanceOutDate("클래스")
                .setDetailInfoUrl("클래스")
                .build();

        List<SWclassInstitutionAttendanceResProto.SWclassInstitutionAttendanceRes.Attendance> attendances = Arrays.asList(attendance);

        SWclassInstitutionAttendanceResProto.SWclassInstitutionAttendanceRes sWclassInstitutionAttendanceRes = SWclassInstitutionAttendanceResProto.SWclassInstitutionAttendanceRes.newBuilder().addAllAttendanceList(attendances).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(sWclassInstitutionAttendanceRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionClassTeacherList(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

        LobbyInstitutionClassTeacherListReqProto.LobbyInstitutionClassTeacherListReq lobbyInstitutionClassTeacherListReq = LobbyInstitutionClassTeacherListReqProto.LobbyInstitutionClassTeacherListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo teacherInfo = LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo.newBuilder()
                .setTchIdx(1)
                .setTeacherImgUrl("/img/profile/sd5e8ag.png")
                .setTeacherName("홍길동")
                .setClassName("수학 심화A반")
                .setInsName("클래스종합학원")
                .build();

        List<LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.TeacherInfo> teacherInfos = Arrays.asList(teacherInfo);

        LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes lobbyHomeScheduleListRes = LobbyInstitutionClassTeacherListResProto.LobbyInstitutionClassTeacherListRes.newBuilder().addAllTeacherInfoList(teacherInfos).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyHomeScheduleListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionClassTeacherInfo(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyInstitutionClassTeacherInfoReqProto.LobbyInstitutionClassTeacherInfoReq lobbyInstitutionClassTeacherInfoReq = LobbyInstitutionClassTeacherInfoReqProto.LobbyInstitutionClassTeacherInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionClassTeacherInfoResProto.LobbyInstitutionClassTeacherInfoRes lobbyInstitutionClassTeacherInfoRes = LobbyInstitutionClassTeacherInfoResProto.LobbyInstitutionClassTeacherInfoRes.newBuilder()
                .setTeacherImgUrl("클래스")
                .setTeacherNickName("클래스")
                .setTeacherName("클래스")
                .setTeacherEmail("클래스")
                .setTeacherPhone("클래스")
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyInstitutionClassTeacherInfoRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionBoardNoteBox(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyInstitutionBoardNoteBoxReqProto.LobbyInstitutionBoardNoteBoxReq lobbyInstitutionBoardNoteBoxReq = LobbyInstitutionBoardNoteBoxReqProto.LobbyInstitutionBoardNoteBoxReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionBoardNoteBoxResProto.LobbyInstitutionBoardNoteBoxRes.NoteBox noteBox = LobbyInstitutionBoardNoteBoxResProto.LobbyInstitutionBoardNoteBoxRes.NoteBox.newBuilder()
                .setNoteBoxFileName("클래스")
                .setInstName("클래스")
                .setNoteBoxDate("클래스")
                .setDownloadUrl("클래스")
                .build();

        List<LobbyInstitutionBoardNoteBoxResProto.LobbyInstitutionBoardNoteBoxRes.NoteBox> noteBoxes = Arrays.asList(noteBox);

        LobbyInstitutionBoardNoteBoxResProto.LobbyInstitutionBoardNoteBoxRes lobbyInstitutionBoardNoteBoxRes = LobbyInstitutionBoardNoteBoxResProto.LobbyInstitutionBoardNoteBoxRes.newBuilder().addAllNoteBoxeList(noteBoxes).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyInstitutionBoardNoteBoxRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionBoardNotepad(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyInstitutionBoardNotepadReqProto.LobbyInstitutionBoardNotepadReq lobbyInstitutionBoardNotepadReq = LobbyInstitutionBoardNotepadReqProto.LobbyInstitutionBoardNotepadReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionBoardNotepadResProto.LobbyInstitutionBoardNotepadRes.Notepad notepad = LobbyInstitutionBoardNotepadResProto.LobbyInstitutionBoardNotepadRes.Notepad.newBuilder()
                .setNotepadFileName("클래스")
                .setInstiName("클래스")
                .setNotepadDate("클래스")
                .setDownloadUrl("클래스")
                .build();

        List<LobbyInstitutionBoardNotepadResProto.LobbyInstitutionBoardNotepadRes.Notepad> notepads = Arrays.asList(notepad);

        LobbyInstitutionBoardNotepadResProto.LobbyInstitutionBoardNotepadRes lobbyInstitutionBoardNotepadRes = LobbyInstitutionBoardNotepadResProto.LobbyInstitutionBoardNotepadRes.newBuilder().addAllNotepadList(notepads).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyInstitutionBoardNotepadRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionBoardReportBox(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyInstitutionBoardReportBoxReqProto.LobbyInstitutionBoardReportBoxReq lobbyInstitutionBoardReportBoxReq = LobbyInstitutionBoardReportBoxReqProto.LobbyInstitutionBoardReportBoxReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionBoardReportBoxResProto.LobbyInstitutionBoardReportBoxRes.ReportBox reportBox = LobbyInstitutionBoardReportBoxResProto.LobbyInstitutionBoardReportBoxRes.ReportBox.newBuilder()
                .setReportBoxTitle("클래스")
                .setIsSubmission(true)
                .setHwbTimeEDate("클래스")
                .setExaminerName("클래스")
                .build();

        List<LobbyInstitutionBoardReportBoxResProto.LobbyInstitutionBoardReportBoxRes.ReportBox> reportBoxes = Arrays.asList(reportBox);

        LobbyInstitutionBoardReportBoxResProto.LobbyInstitutionBoardReportBoxRes lobbyInstitutionBoardReportBoxRes = LobbyInstitutionBoardReportBoxResProto.LobbyInstitutionBoardReportBoxRes.newBuilder().addAllReportBoxList(reportBoxes).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyInstitutionBoardReportBoxRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyInstitutionBoardQuestionBox(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyInstitutionBoardQuestionBoxReqProto.LobbyInstitutionBoardQuestionBoxReq lobbyInstitutionBoardQuestionBoxReq = LobbyInstitutionBoardQuestionBoxReqProto.LobbyInstitutionBoardQuestionBoxReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyInstitutionBoardQuestionBoxResProto.LobbyInstitutionBoardQuestionBoxRes.QuestionBox questionBox  = LobbyInstitutionBoardQuestionBoxResProto.LobbyInstitutionBoardQuestionBoxRes.QuestionBox.newBuilder()
                .setQuestionTitle("클래스")
                .setIsAnswer(true)
                .setSubject("클래스")
                .setQuestionerName("클래스")
                .setAnswererName("클래스")
                .build();

        List<LobbyInstitutionBoardQuestionBoxResProto.LobbyInstitutionBoardQuestionBoxRes.QuestionBox> questionBoxes = Arrays.asList(questionBox);

        LobbyInstitutionBoardQuestionBoxResProto.LobbyInstitutionBoardQuestionBoxRes lobbyInstitutionBoardQuestionBoxRes = LobbyInstitutionBoardQuestionBoxResProto.LobbyInstitutionBoardQuestionBoxRes.newBuilder().addAllQuestionBoxeList(questionBoxes).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyInstitutionBoardQuestionBoxRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyCalenderSchedule(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyCalenderScheduleReqProto.LobbyCalenderScheduleReq lobbyCalenderScheduleReq = LobbyCalenderScheduleReqProto.LobbyCalenderScheduleReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyCalenderScheduleResProto.LobbyCalenderScheduleRes.Schedule schedule = LobbyCalenderScheduleResProto.LobbyCalenderScheduleRes.Schedule.newBuilder()
                .setScheduleType("클래스")
                .setScheduleText("클래스")
                .setScheduleDate("클래스")
                .build();

        List<LobbyCalenderScheduleResProto.LobbyCalenderScheduleRes.Schedule> schedules = Arrays.asList(schedule);

        LobbyCalenderScheduleResProto.LobbyCalenderScheduleRes lobbyCalenderScheduleRes = LobbyCalenderScheduleResProto.LobbyCalenderScheduleRes.newBuilder().addAllScheduleList(schedules).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyCalenderScheduleRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findLobbyReportUrl(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        LobbyReportUrlReqProto.LobbyReportUrlReq lobbyCalenderUrlReq = LobbyReportUrlReqProto.LobbyReportUrlReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        LobbyReportUrlResProto.LobbyReportUrlRes lobbyReportUrlRes = LobbyReportUrlResProto.LobbyReportUrlRes.newBuilder()
                .setReportUrl("클래스")
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(lobbyReportUrlRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

}
