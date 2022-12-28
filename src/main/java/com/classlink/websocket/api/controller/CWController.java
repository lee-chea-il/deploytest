package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.cw.CWService;
import com.classlink.websocket.api.system.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CWController {
	
	private final CWService cwService;

	@OpCodeMapping(value = OpCode.CW_EXAM_QUIZ_LIST)
	public void cwExamQuizList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwExamQuizList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_EXAM_QUIZ_ACTIVATE)
	public void cwExamQuizActivate(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwExamQuizActivate(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.QUIZ_ANSWER_DONE)
	public void quizAnswerDone(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.addQuizAnswerDone(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_EXAM_NOTE_EXAM_ACTIVE)
	public void cwExamNoteExamActive(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwExamNoteExamActive(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_EXAM_NOTE_EXAM_ANSWER_DONE)
	public void cwExamNoteExamAnswerDone(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.addCwExamNoteExamAnswerDone(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_QUESTION_BOX_CREATE)
	public void cwQuestionBoxCreate(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.addCwQuestionBoxCreate(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_QUESTION_BOX_LIST)
	public void cwQuestionBoxList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwQuestionBoxList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_QUESTION_BOX_QUESTION_DETAIL)
	public void cwQuestionBoxQuestionDetail(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwQuestionBoxQuestionDetail(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_INFO_BASIC_INFO)
	public void cwInfoBasicInfo(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwInfoBasicInfo(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_CURRICULUM_LIST)
	public void cwCurriculumList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwCurriculumList(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_CURRICULUM_CHANGE)
	public void cwCurriculumChange(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwCurriculumChange(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_MESSENGER_CHAT_USER_INFO)
	public void cwMessengerChatUserInfo(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.findCwMessengerChatUserInfo(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.CW_MY_INFO_CHANGE)
	public void cwMyInfoChange(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(cwService.modifyCwMyInfoChange(packetReqProto, memId));
	}





}
