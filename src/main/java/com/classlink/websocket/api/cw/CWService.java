package com.classlink.websocket.api.cw;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.cw.domain.dto.proto.*;
import com.classlink.websocket.api.cw.domain.param.proto.*;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CWService {

    private final CWMapper cwMapper;

    public BinaryMessage findCwExamQuizList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWExamQuizListReqProto.CWExamQuizListReq cwExamQuizListReq = CWExamQuizListReqProto.CWExamQuizListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWExamQuizListResProto.CWExamQuizListRes.QuizSet quizSet = CWExamQuizListResProto.CWExamQuizListRes.QuizSet.newBuilder()
                .setDataTableType("클래스")
                .setIdx(1)
                .setCategory("클래스")
                .setTitle("클래스")
                .setLimitTime(1)
                .setLevel(1)
                .build();

        List<CWExamQuizListResProto.CWExamQuizListRes.QuizSet> quizSets = Arrays.asList(quizSet);

        CWExamQuizListResProto.CWExamQuizListRes cwExamQuizListRes = CWExamQuizListResProto.CWExamQuizListRes.newBuilder().addAllQuizSetList(quizSets).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwExamQuizListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwExamQuizActivate(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWExamQuizActivateReqProto.CWExamQuizActivateReq cwExamQuizActivateReq = CWExamQuizActivateReqProto.CWExamQuizActivateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWExamQuizActivateResProto.CWExamQuizActivateRes cwExamQuizActivateRes = CWExamQuizActivateResProto.CWExamQuizActivateRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwExamQuizActivateRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage addQuizAnswerDone(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        QuizAnswerDoneReqProto.QuizAnswerDoneReq quizAnswerDoneReq = QuizAnswerDoneReqProto.QuizAnswerDoneReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        QuizAnswerDoneResProto.QuizAnswerDoneRes quizAnswerDoneRes = QuizAnswerDoneResProto.QuizAnswerDoneRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(quizAnswerDoneRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwExamNoteExamActive(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWExamNoteExamActiveReqProto.CWExamNoteExamActiveReq cwExamNoteExamActiveReq = CWExamNoteExamActiveReqProto.CWExamNoteExamActiveReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizExample quizExample = CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizExample.newBuilder()
                .setExample("클래스")
                .setIsCorrect(true)
                .build();

        List<CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizExample> quizExamples = Arrays.asList(quizExample);

        CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizInfo quizInfo = CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizInfo.newBuilder()
                .setIdx(1)
                .setQuestionType(1)
                .setQuestion("클래스")
                .addAllExampleList(quizExamples)
                .build();

        List<CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.QuizInfo> quizInfos = Arrays.asList(quizInfo);

        CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes cwExamNoteExamActiveRes = CWExamNoteExamActiveResProto.CWExamNoteExamActiveRes.newBuilder().addAllQuizInfoList(quizInfos).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwExamNoteExamActiveRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage addCwExamNoteExamAnswerDone(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWExamNoteExamAnswerDoneReqProto.CWExamNoteExamAnswerDoneReq cwExamNoteExamAnswerDoneReq = CWExamNoteExamAnswerDoneReqProto.CWExamNoteExamAnswerDoneReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWExamNoteExamAnswerDoneResProto.CWExamNoteExamAnswerDoneRes cwExamNoteExamAnswerDoneRes = CWExamNoteExamAnswerDoneResProto.CWExamNoteExamAnswerDoneRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwExamNoteExamAnswerDoneRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage addCwQuestionBoxCreate(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWQuestionBoxCreateReqProto.CWQuestionBoxCreateReq cwQuestionBoxCreateReq = CWQuestionBoxCreateReqProto.CWQuestionBoxCreateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWQuestionBoxCreateResProto.CWQuestionBoxCreateRes cwQuestionBoxCreateRes = CWQuestionBoxCreateResProto.CWQuestionBoxCreateRes.newBuilder()
                .setQuestionIdx(1)
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwQuestionBoxCreateRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwQuestionBoxList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWQuestionBoxListReqProto.CWQuestionBoxListReq cwQuestionBoxListReq = CWQuestionBoxListReqProto.CWQuestionBoxListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWQuestionBoxListResProto.CWQuestionBoxListRes.QuestionInfo questionInfo = CWQuestionBoxListResProto.CWQuestionBoxListRes.QuestionInfo.newBuilder()
                .setQuestionIdx(1)
                .setTitle("클래스")
                .setTeacherName("클래스")
                .setRegistDate("클래스")
                .setStatus(1)
                .build();

        List<CWQuestionBoxListResProto.CWQuestionBoxListRes.QuestionInfo> questionInfos = Arrays.asList(questionInfo);

        CWQuestionBoxListResProto.CWQuestionBoxListRes cwQuestionBoxListRes = CWQuestionBoxListResProto.CWQuestionBoxListRes.newBuilder().addAllQuestionInfoList(questionInfos).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwQuestionBoxListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwQuestionBoxQuestionDetail(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWQuestionBoxQuestionDetailReqProto.CWQuestionBoxQuestionDetailReq cwQuestionBoxQuestionDetailReq = CWQuestionBoxQuestionDetailReqProto.CWQuestionBoxQuestionDetailReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWQuestionBoxQuestionDetailResProto.CWQuestionBoxQuestionDetailRes.QuestionDetail questionDetail = CWQuestionBoxQuestionDetailResProto.CWQuestionBoxQuestionDetailRes.QuestionDetail.newBuilder()
                .setQuestionIdx(1)
                .setTitle("클래스")
                .setQuestion("클래스")
                .setTeacherName("클래스")
                .setRegistDate("클래스")
                .setStatus(1)
                .build();

        CWQuestionBoxQuestionDetailResProto.CWQuestionBoxQuestionDetailRes cwQuestionBoxQuestionDetailRes = CWQuestionBoxQuestionDetailResProto.CWQuestionBoxQuestionDetailRes.newBuilder().setQuestionDetailData(questionDetail).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwQuestionBoxQuestionDetailRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwInfoBasicInfo(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWInfoBasicInfoReqProto.CWInfoBasicInfoReq cwInfoBasicInfoReq = CWInfoBasicInfoReqProto.CWInfoBasicInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWInfoBasicInfoResProto.CWInfoBasicInfoRes.StudentInfo studentInfo = CWInfoBasicInfoResProto.CWInfoBasicInfoRes.StudentInfo.newBuilder()
                .setMemIdx(1)
                .setName("클래스")
                .setNickName("클래스")
                .setImgUrl("클래스")
                .setIsOnline(true)
                .setIsMute(true)
                .setIsHold(true)
                .setIsPresentationEnable(true)
                .build();

        List<Integer> studentInfoIdxes = Arrays.asList(studentInfo.getMemIdx());
        List<CWInfoBasicInfoResProto.CWInfoBasicInfoRes.StudentInfo> studentInfos = Arrays.asList(studentInfo);

        CWInfoBasicInfoResProto.CWInfoBasicInfoRes.TeacherInfo teacherInfo = CWInfoBasicInfoResProto.CWInfoBasicInfoRes.TeacherInfo.newBuilder()
                .setMemIdx(1)
                .setName("클래스")
                .setNickName("클래스")
                .setImgUrl("클래스")
                .setIsSubteacher(true)
                .setIsOnline(true)
                .build();

        List<CWInfoBasicInfoResProto.CWInfoBasicInfoRes.TeacherInfo> teacherInfos = Arrays.asList(teacherInfo);

        CWInfoBasicInfoResProto.CWInfoBasicInfoRes.GroupInfo groupInfo = CWInfoBasicInfoResProto.CWInfoBasicInfoRes.GroupInfo.newBuilder()
                .setGroupIdx(1)
                .setGroupName("클래스")
                .setIsPresentationEnable(true)
                .addAllStudentIdxList(studentInfoIdxes)
                .build();

        List<CWInfoBasicInfoResProto.CWInfoBasicInfoRes.GroupInfo> groupInfos = Arrays.asList(groupInfo);

        CWInfoBasicInfoResProto.CWInfoBasicInfoRes.ClassInfo classInfo = CWInfoBasicInfoResProto.CWInfoBasicInfoRes.ClassInfo.newBuilder()
                .setIdx(1)
                .setName("클래스")
                .addAllStudentInfoList(studentInfos)
                .addAllTeacherInfoList(teacherInfos)
                .addAllGroupInfoList(groupInfos)
                .setCurriculumIdx(1)
                .setCurriculumName("클래스")
                .setIsMute(true)
                .setIsHold(true)
                .build();

        CWInfoBasicInfoResProto.CWInfoBasicInfoRes cwInfoBasicInfoRes = CWInfoBasicInfoResProto.CWInfoBasicInfoRes.newBuilder().setClassInfoData(classInfo).build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwInfoBasicInfoRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwCurriculumList(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWCurriculumListReqProto.CWCurriculumListReq cwCurriculumListReq = CWCurriculumListReqProto.CWCurriculumListReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo commCurriculum = CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo.newBuilder()
                .setIdx(1)
                .setName("클래스")
                .setTeacherIdx(1)
                .setTeacherName("클래스")
                .setClassName("클래스")
                .build();

        List<CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo> commCurriculums = Arrays.asList(commCurriculum);

        CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo myCurriculum = CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo.newBuilder()
                .setIdx(1)
                .setName("클래스")
                .setTeacherIdx(1)
                .setTeacherName("클래스")
                .setClassName("클래스")
                .build();

        List<CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo> myCurriculums = Arrays.asList(myCurriculum);

        CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo currentClassCurriculum = CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo.newBuilder()
                .setIdx(1)
                .setName("클래스")
                .setTeacherIdx(1)
                .setTeacherName("클래스")
                .setClassName("클래스")
                .build();

        List<CWCurriculumListResProto.CWCurriculumListRes.CurriculumInfo> currentClassCurriculums = Arrays.asList(currentClassCurriculum);

        CWCurriculumListResProto.CWCurriculumListRes cwCurriculumListRes = CWCurriculumListResProto.CWCurriculumListRes.newBuilder()
                .setSelectCurriculumIdx(1)
                .addAllCommCurriculumList(commCurriculums)
                .addAllMyCurriculumList(myCurriculums)
                .addAllCurrentClassCurriculumList(currentClassCurriculums)
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwCurriculumListRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwCurriculumChange(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWCurriculumChangeReqProto.CWCurriculumChangeReq cwCurriculumChangeReq = CWCurriculumChangeReqProto.CWCurriculumChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWCurriculumChangeResProto.CWCurriculumChangeRes cwCurriculumChangeRes = CWCurriculumChangeResProto.CWCurriculumChangeRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwCurriculumChangeRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage findCwMessengerChatUserInfo(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWMessengerChatUserInfoReqProto.CWMessengerChatUserInfoReq cwMessengerChatUserInfoReq = CWMessengerChatUserInfoReqProto.CWMessengerChatUserInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWMessengerChatUserInfoResProto.CWMessengerChatUserInfoRes cwMessengerChatUserInfoRes = CWMessengerChatUserInfoResProto.CWMessengerChatUserInfoRes.newBuilder()
                .setMemName("클래스")
                .setMemNickName("클래스")
                .setMemImgUrl("클래스")
                .build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwMessengerChatUserInfoRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

    public BinaryMessage modifyCwMyInfoChange(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

        CWMyInfoChangeReqProto.CWMyInfoChangeReq cwMyInfoChangeReq = CWMyInfoChangeReqProto.CWMyInfoChangeReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

        CWMyInfoChangeResProto.CWMyInfoChangeRes cwMyInfoChangeRes = CWMyInfoChangeResProto.CWMyInfoChangeRes.newBuilder().build();

        ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
                .setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
                .setResultCode(ResultCode.SUCCESS.getCode())
                .setResultMessage(ResultCode.SUCCESS.getMessage())
                .setData(cwMyInfoChangeRes.toByteString())
                .build();

        return new BinaryMessage(packetResProto.toByteArray());
    }

}
