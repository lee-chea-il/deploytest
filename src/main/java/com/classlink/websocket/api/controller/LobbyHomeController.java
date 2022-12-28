package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.lobby.LobbyHomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LobbyHomeController {
	
	private final LobbyHomeService lobbyHomeService;


	@OpCodeMapping(value = OpCode.LOBBY_HOME_STATISTICS)
	public void lobbyHomeStatistics(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeStatistics(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_STUDENT_INSTITUTION_LIST)
	public void lobbyHomeStudentInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeStudentInstitutionList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_FRANCHISE_INSTITUTION_LIST)
	public void lobbyHomeFranchiseInstitutionList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeFranchiseInstitutionList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_NOTICE_LIST)
	public void lobbyHomeNoticeList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeNoticeList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_SCHEDULE_LIST)
	public void lobbyHomeScheduleList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeScheduleList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_CLASS_INFO_LIST)
	public void lobbyHomeClassInfoList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeClassInfoList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_TODAY_CLASS_DETAIL)
	public void lobbyHomeTodayClassDetail(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeTodayClassDetail(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_LECTURE_COURSE_LIST)
	public void lobbyHomeLectureCourseList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeLectureCourseList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_HOME_EVENT_FOR_THEME_LIST)
	public void lobbyHomeEventForThemeList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyHomeEventForThemeList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SWCLASS_INSTITUTION_SYSTEM_NOTICE_LIST)
	public void swclassInstitutionSystemNoticeList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findSwclassInstitutionSystemNoticeList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SWCLASS_INSTITUTION_INSTITUTION_NOTICE_LIST)
	public void swclassInstitutionInstitutionNoticeList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findSwclassInstitutionInstitutionNoticeList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SWCLASS_INSTITUTION_FRANCHISE_NOTICE_LIST)
	public void swclassInstitutionFranchiseNoticeList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findSwclassInstitutionFranchiseNoticeList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SWCLASS_INSTITUTION_ATTENDANCE)
	public void swclassInstitutionAttendance(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findSwclassInstitutionAttendance(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_CLASS_TEACHER_LIST)
	public void lobbyInstitutionClassTeacherList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionClassTeacherList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_CLASS_TEACHER_INFO)
	public void lobbyInstitutionClassTeacherInfo(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionClassTeacherInfo(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_BOARD_NOTE_BOX)
	public void lobbyInstitutionBoardNoteBox(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionBoardNoteBox(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_BOARD_NOTEPAD)
	public void lobbyInstitutionBoardNotepad(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionBoardNotepad(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_BOARD_REPORT_BOX)
	public void lobbyInstitutionBoardReportBox(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionBoardReportBox(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_INSTITUTION_BOARD_QUESTION_BOX)
	public void lobbyInstitutionBoardQuestionBox(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyInstitutionBoardQuestionBox(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_CALENDER_SCHEDULE)
	public void lobbyCalenderSchedule(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyCalenderSchedule(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.LOBBY_REPORT_URL)
	public void lobbyLobbyReportUrl(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(lobbyHomeService.findLobbyReportUrl(packetReqProto, memId));
	}

}
