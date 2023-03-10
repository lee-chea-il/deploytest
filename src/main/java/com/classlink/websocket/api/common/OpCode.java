package com.classlink.websocket.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpCode {
	
	DEFAULT(0),
    //월드셋--------------------------------------------------------------------
    SYS_WORLD_SET_INFO(120),
    SYS_WORLD_INTER_OBJ_SET_PACKAGE_CREATE(127),
    SYS_WORLD_INTER_OBJ_SET_CURRICULUM_CREATE(201),
    SYS_WORLD_INTER_OBJ_SET_CURRICULUM_INIT(128),
    //로그인
    LOGIN_INSTITUTE_REGIST(112),
    LOGIN_IDENTITY_REGIST(113),
    // 신분생성 flow--------------------------------------------------------------------
    IDENTITY_CREATE(100),
    IDENTITY_LIST(101),
    IDENTITY_CHANGE(102),
    IDENTITY_INSTITUTION_ENROLLMENT(106),
    IDENTITY_INSTITUTION_INFO(105),
    IDENTITY_ENROLLMENT_LIST(107),
    IDENTITY_ENROLLMENT_CONFIRM(108),
    IDENTITY_ENROLLMENT_INFO(109),
    IDENTITY_ENROLLMENT_REPLY(110),
    IDENTITY_AVATAR_LIST(103),
    IDENTITY_AVATAR_CHANGE(104),
    IDENTITY_PROFILE_DETAIL(129),
    IDENTITY_PROFILE_UPDATE(111),

    //로비--------------------------------------------------------------------
    LOBBY_HOME_STATISTICS(132),
    LOBBY_HOME_STUDENT_INSTITUTION_LIST(117),
    LOBBY_HOME_FRANCHISE_INSTITUTION_LIST(118),
    LOBBY_HOME_NOTICE_LIST(133),
    LOBBY_HOME_SCHEDULE_LIST(134),
    LOBBY_HOME_CLASS_INFO_LIST(114),
    LOBBY_HOME_TODAY_CLASS_DETAIL(115),
    LOBBY_HOME_LECTURE_COURSE_LIST(116),
    LOBBY_HOME_EVENT_FOR_THEME_LIST(135),
    SWCLASS_INSTITUTION_SYSTEM_NOTICE_LIST(136),
    SWCLASS_INSTITUTION_INSTITUTION_NOTICE_LIST(137),
    SWCLASS_INSTITUTION_FRANCHISE_NOTICE_LIST(138),
    SWCLASS_INSTITUTION_ATTENDANCE(139),
    LOBBY_INSTITUTION_CLASS_TEACHER_LIST(119),
    LOBBY_INSTITUTION_CLASS_TEACHER_INFO(140),
    LOBBY_INSTITUTION_BOARD_NOTE_BOX(141),
    LOBBY_INSTITUTION_BOARD_NOTEPAD(142),
    LOBBY_INSTITUTION_BOARD_REPORT_BOX(143),
    LOBBY_INSTITUTION_BOARD_QUESTION_BOX(144),
    LOBBY_CALENDER_SCHEDULE(145),
    LOBBY_REPORT_URL(146),

    //CW--------------------------------------------------------------------
    CW_EXAM_QUIZ_LIST(149),
    CW_EXAM_QUIZ_ACTIVATE(150),
    QUIZ_ANSWER_DONE(151),
    CW_EXAM_NOTE_EXAM_ACTIVE(152),
    CW_EXAM_NOTE_EXAM_ANSWER_DONE(153),
    CW_QUESTION_BOX_CREATE(156),
    CW_QUESTION_BOX_LIST(157),
    CW_QUESTION_BOX_QUESTION_DETAIL(158),
    CW_INFO_BASIC_INFO(159),
    CW_CURRICULUM_LIST(202),
    CW_CURRICULUM_CHANGE(160),
    CW_MESSENGER_CHAT_USER_INFO(200),
    CW_MY_INFO_CHANGE(161);

	private final int code;

}
