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
        <option value="120">월드셋 리소스 정보</option>
        <option value="127">월드셋 매핑 정보</option>
        <option value="128">월드셋 자료실 정보</option>
        <option value="112">최근 접속 교육기관 변경</option>
        <option value="113">최근 접속 신분 변경</option>
        <option value="100">신분 생성</option>
        <option value="101" selected>신분 조회</option>
<%--        <option value="102">아바타 생성</option>--%>
        <option value="103">아바타 조회</option>
        <option value="104">아바타 변경</option>
        <option value="105">교육기관 조회</option>
        <option value="106">교육기관 등록요청</option>
        <option value="107">가입신청 리스트</option>
        <option value="108">가입신청 확인</option>
        <option value="109">가입신청인 정보</option>
        <option value="110">가입신청 응답</option>
        <option value="201">소속기관조회</option>
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

    //필수객체 및 에러관련
    const RequestPacketName = "RequestPacket";
    const ResponsePacketName = "ResponsePacket";
    const JwtExceptionName = "JwtException";

    // 시스템--------------------------------------
    //월드셋
    const SysWorldSetInfoReqName = "SysWorldSetInfoReq";
    const SysWorldSetInfoResName = "SysWorldSetInfoRes";
    const SysWorldInterObjSetCreateReqName = "SysWorldInterObjSetCreateReq";
    const SysWorldInterObjSetCreateResName = "SysWorldInterObjSetCreateRes";
    const SysWorldInterObjSetInitReqName = "SysWorldInterObjSetInitReq";
    const SysWorldInterObjSetInitResName = "SysWorldInterObjSetInitRes";

    // 로그인 --------------------------------------------------------
    const LoginInstituteRegistReqName = "LoginInstituteRegistReq";
    const LoginInstituteRegistResName = "LoginInstituteRegistRes";
    const LoginIdentityRegistReqName = "LoginIdentityRegistReq";
    const LoginIdentityRegistResName = "LoginIdentityRegistRes";

    // 신분생성flow--------------------------------------
    //신분
    const IdentityListReqName = "IdentityListReq";
    const IdentityListResName = "IdentityListRes";
    const IdentityCreateReqName = "IdentityCreateReq";
    const IdentityCreateResName = "IdentityCreateRes";

    //아바타
    // const IdentityAvatarCreateReqName = "IdentityAvatarCreateReq";
    // const IdentityAvatarCreateResName = "IdentityAvatarCreateRes";
    const IdentityAvatarListReqName = "IdentityAvatarListReq";
    const IdentityAvatarListResName = "IdentityAvatarListRes";
    const IdentityAvatarChangeReqName = "IdentityAvatarChangeReq";
    const IdentityAvatarChangeResName = "IdentityAvatarChangeRes";

    //교육기관 등록요청
    const IdentityInstitutionInfoReqName = "IdentityInstitutionInfoReq";
    const IdentityInstitutionInfoResName = "IdentityInstitutionInfoRes";
    const IdentityInstitutionEnrollmentReqName = "IdentityInstitutionEnrollmentReq";
    const IdentityInstitutionEnrollmentResName = "IdentityInstitutionEnrollmentRes";

    // 로비 --------------------------------------
    // 홈
    const MyInstitutionListName = "MyInstitutionList";
    const IdentityEnrollmentConfirmReqName = "IdentityEnrollmentConfirmReq";
    const IdentityEnrollmentConfirmResName = "IdentityEnrollmentConfirmRes";
    const IdentityEnrollmenterInfoReqName = "IdentityEnrollmenterInfoReq";
    const IdentityEnrollmenterInfoResName = "IdentityEnrollmenterInfoRes";
    const IdentityEnrollmentListReqName = "IdentityEnrollmentListReq";
    const IdentityEnrollmentListResName = "IdentityEnrollmentListRes";
    const IdentityEnrollmentReplyReqName = "IdentityEnrollmentReplyReq";
    const IdentityEnrollmentReplyResName = "IdentityEnrollmentReplyRes";

    //---------------------------------------------------------------------------------------------------
    // protobuf.load시에 로딩할 protobuf 파일 경로 지정  

    const commonPath = "../proto"
    const protoFileList = [
        commonPath.concat("/sys/request/SysWorldSetInfoReq.proto"),
        commonPath.concat("/sys/response/SysWorldSetInfoRes.proto"),
        commonPath.concat("/sys/request/SysWorldInterObjSetCreateReq.proto"),
        commonPath.concat("/sys/response/SysWorldInterObjSetCreateRes.proto"),
        commonPath.concat("/sys/request/SysWorldInterObjSetInitReq.proto"),
        commonPath.concat("/sys/response/SysWorldInterObjSetInitRes.proto"),

        commonPath.concat("/member/request/LoginInstituteRegistReq.proto"),
        commonPath.concat("/member/response/LoginInstituteRegistRes.proto"),
        commonPath.concat("/member/request/LoginIdentityRegistReq.proto"),
        commonPath.concat("/member/response/LoginIdentityRegistRes.proto"),

        commonPath.concat("/member/request/IdentityListReq.proto"),
        commonPath.concat("/member/response/IdentityListRes.proto"),
        commonPath.concat("/member/request/IdentityCreateReq.proto"),
        commonPath.concat("/member/response/IdentityCreateRes.proto"),
        // commonPath.concat("/member/request/IdentityAvatarCreateReq.proto"),
        // commonPath.concat("/member/response/IdentityAvatarCreateRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarListReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarListRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarChangeReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarChangeRes.proto"),
        commonPath.concat("/member/request/IdentityInstitutionInfoReq.proto"),
        commonPath.concat("/member/response/IdentityInstitutionInfoRes.proto"),
        commonPath.concat("/member/request/IdentityInstitutionEnrollmentReq.proto"),
        commonPath.concat("/member/response/IdentityInstitutionEnrollmentRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentConfirmReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentConfirmRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmenterInfoReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmenterInfoRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentListReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentListRes.proto"),
        commonPath.concat("/member/request/IdentityEnrollmentReplyReq.proto"),
        commonPath.concat("/member/response/IdentityEnrollmentReplyRes.proto"),
        commonPath.concat("/member/request/SWclassIdentityInfo.proto"),
        commonPath.concat("/lobby/home/response/SWclassMyInstitutionList.proto"),
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
                    //신분생성-----------------------------------------------------------------------------------------
                    case 100 :
                        loadMessage(root, IdentityCreateReqName, "Classlink.IdentityCreateReq");
                        loadMessage(root, IdentityCreateResName, "Classlink.IdentityCreateRes");

                        const IdentityCreateReqObj = {
                            InsCode: 'testA',
                            SelectIdentityType: 'T'
                        };

                        Data = setDataToSend(root, IdentityCreateReqName, IdentityCreateReqObj);
                        break;
                    //신분조회-----------------------------------------------------------------------------------------
                    case 101 :
                        loadMessage(root, IdentityListReqName, "Classlink.IdentityListReq");
                        loadMessage(root, IdentityListResName, "Classlink.IdentityListRes");

                        const IdentityListReqObj = {
                            InsCode: 'testA'
                        };

                        Data = setDataToSend(root, IdentityListReqName, IdentityListReqObj);
                        break;
                    //아바타생성-----------------------------------------------------------------------------------------
                    case 102 :
                        loadMessage(root, IdentityAvatarCreateReqName, "Classlink.IdentityAvatarCreateReq");
                        loadMessage(root, IdentityAvatarCreateResName, "Classlink.IdentityAvatarCreateRes");

                        const IdentityAvatarCreateReqObj = {
                            InsCode: 'testA',
                            IdentityType: 'P',
                            AvatarId: '150'
                        };

                        Data = setDataToSend(root, IdentityAvatarCreateReqName, IdentityAvatarCreateReqObj);
                        break;
                    //아바타 조회-----------------------------------------------------------------------------------------
                    case 103 :
                        loadMessage(root, IdentityAvatarListReqName, "Classlink.IdentityAvatarListReq");
                        loadMessage(root, IdentityAvatarListResName, "Classlink.IdentityAvatarListRes");

                        const IdentityAvatarListReqObj = {
                            InsCode: 'testA',
                            IdentityType: 'P',
                        };

                        Data = setDataToSend(root, IdentityAvatarListReqName, IdentityAvatarListReqObj);
                        break;
                    //아바타 변경-----------------------------------------------------------------------------------------
                    case 104 :
                        loadMessage(root, IdentityAvatarChangeReqName, "Classlink.IdentityAvatarChangeReq");
                        loadMessage(root, IdentityAvatarChangeResName, "Classlink.IdentityAvatarChangeRes");

                        const IdentityAvatarChangeReqObj = {
                            InsCode: 'testA',
                            IdentityType: 'P',
                            AvatarId: 155
                        };

                        Data = setDataToSend(root, IdentityAvatarChangeReqName, IdentityAvatarChangeReqObj);
                        break;
                    //교육기관 조회-----------------------------------------------------------------------------------------
                    case 105 :
                        loadMessage(root, IdentityInstitutionInfoReqName, "Classlink.IdentityInstitutionInfoReq");
                        loadMessage(root, IdentityInstitutionInfoResName, "Classlink.IdentityInstitutionInfoRes");

                        const IdentityInstitutionInfoReqObj = {
                            InsCode: 'testA',
                            InsInviteUrl: '/img/url'
                        };

                        Data = setDataToSend(root, IdentityInstitutionInfoReqName, IdentityInstitutionInfoReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 106 :
                        loadMessage(root, IdentityInstitutionEnrollmentReqName, "Classlink.IdentityInstitutionEnrollmentReq");
                        loadMessage(root, IdentityInstitutionEnrollmentResName, "Classlink.IdentityInstitutionEnrollmentRes");

                        const IdentityInstitutionEnrollmentReqObj = {
                            InsCode: 'testA'
                        };

                        Data = setDataToSend(root, IdentityInstitutionEnrollmentReqName, IdentityInstitutionEnrollmentReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 107 :
                        loadMessage(root, IdentityEnrollmentListReqName, "Classlink.IdentityEnrollmentListReq");
                        loadMessage(root, IdentityEnrollmentListResName, "Classlink.IdentityEnrollmentListRes");

                        const IdentityEnrollmentListReqObj = {
                            InsCode: 'testA'
                        };

                        Data = setDataToSend(root, IdentityEnrollmentListReqName, IdentityEnrollmentListReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 108 :
                        loadMessage(root, IdentityEnrollmentConfirmReqName, "Classlink.IdentityEnrollmentConfirmReq");
                        loadMessage(root, IdentityEnrollmentConfirmResName, "Classlink.IdentityEnrollmentConfirmRes");

                        const IdentityEnrollmentConfirmReqObj = {
                            ItmIdx: 7
                        };

                        Data = setDataToSend(root, IdentityEnrollmentConfirmReqName, IdentityEnrollmentConfirmReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 109 :
                        loadMessage(root, IdentityEnrollmenterInfoReqName, "Classlink.IdentityEnrollmenterInfoReq");
                        loadMessage(root, IdentityEnrollmenterInfoResName, "Classlink.IdentityEnrollmenterInfoRes");

                        const IdentityEnrollmenterInfoReqObj = {
                            ItmIdx: 7
                        };

                        Data = setDataToSend(root, IdentityEnrollmenterInfoReqName, IdentityEnrollmenterInfoReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 110 :
                        loadMessage(root, IdentityEnrollmentReplyReqName, "Classlink.IdentityEnrollmentReplyReq");
                        loadMessage(root, IdentityEnrollmentReplyResName, "Classlink.IdentityEnrollmentReplyRes");

                        const IdentityEnrollmentReplyReqObj = {
                            InsCode: 'testA',
                            MemId: 'test7777'
                        };

                        Data = setDataToSend(root, IdentityEnrollmentReplyReqName, IdentityEnrollmentReplyReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 112 :
                        loadMessage(root, LoginInstituteRegistReqName, "Classlink.LoginInstituteRegistReq");
                        loadMessage(root, LoginInstituteRegistResName, "Classlink.LoginInstituteRegistRes");

                        const LoginInstituteRegistReqObj = {
                            LastInsCode : 'testA'
                        };

                        Data = setDataToSend(root, LoginInstituteRegistReqName, LoginInstituteRegistReqObj);
                        break;
                    case 113 :
                        loadMessage(root, LoginIdentityRegistReqName, "Classlink.LoginIdentityRegistReq");
                        loadMessage(root, LoginIdentityRegistResName, "Classlink.LoginIdentityRegistRes");

                        const LoginIdentityRegistReqObj = {
                            InsCode : 'testA',
                            LastIdentityType: 'S'
                        };

                        Data = setDataToSend(root, LoginIdentityRegistReqName, LoginIdentityRegistReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 120 :
                        loadMessage(root, SysWorldSetInfoReqName, "Classlink.SysWorldSetInfoReq");
                        loadMessage(root, SysWorldSetInfoResName, "Classlink.SysWorldSetInfoRes");

                        const SysWorldSetInfoReqObj = {
                            InsCode: 'testA'
                        };

                        Data = setDataToSend(root, SysWorldSetInfoReqName, SysWorldSetInfoReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 127 :
                        loadMessage(root, SysWorldInterObjSetCreateReqName, "Classlink.SysWorldInterObjSetCreateReq");
                        loadMessage(root, SysWorldInterObjSetCreateResName, "Classlink.SysWorldInterObjSetCreateRes");

                        const SysWorldInterObjSetCreateReqObj = {
                            InsCode: 'testA',
                            WorldSetCode : 'WS001',
                            WorldCode : 'CW001'
                        };

                        Data = setDataToSend(root, SysWorldInterObjSetCreateReqName, SysWorldInterObjSetCreateReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 128 :
                        loadMessage(root, SysWorldInterObjSetInitReqName, "Classlink.SysWorldInterObjSetInitReq");
                        loadMessage(root, SysWorldInterObjSetInitResName, "Classlink.SysWorldInterObjSetInitRes");

                        const SysWorldInterObjSetInitReqObj = {
                            InsCode: 'testA',
                            WorldSetCode : 'WS001',
                            WorldCode : 'CW001',
                            CurriculumIdx : 1
                        };

                        Data = setDataToSend(root, SysWorldInterObjSetInitReqName, SysWorldInterObjSetInitReqObj);
                        break;
                    //-----------------------------------------------------------------------------------------
                    case 201 :
                        loadMessage(root, MyInstitutionListName, "Classlink.SWclassMyInstitutionList");
                        break;

                    default:
                        break;
                }

                const RequestPacketObj = {
                    OpCode: OpCode,
                    AccessToken: "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NzE2MjE2MzksInVzZXJfbmFtZSI6InRlc3Q3Nzc3IiwianRpIjoiZjJmMjk5ZjktNzc4ZS00ZDgyLWIyZjQtNGNkYjhkOGI5NDQxIiwiY2xpZW50X2lkIjoiY2xhc3NsaW5rIiwic2NvcGUiOlsiY2xpZW50Il19.cekHcRqzZYxc-Zs14zpdRJ0XdJvfNh-_J4WwGaMlfa8",
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
        //var ws = new WebSocket("ws:112.171.101.31:45170/api");
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
                case 100:
                    const receivedIdentityCreateResData = window[IdentityCreateResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityCreateResData mmmmmmmmmmmm>>", receivedIdentityCreateResData);
                    break;

                case 101:
                    const receivedIdentityListResData = window[IdentityListResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityListResData mmmmmmmmmmmm>>", receivedIdentityListResData);
                    break;

                case 102:
                    const receivedIdentityAvatarCreateResData = window[IdentityAvatarCreateResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityAvatarCreateResData mmmmmmmmmmmm>>", receivedIdentityAvatarCreateResData);
                    break;

                case 103:
                    const receivedIdentityAvatarListResData = window[IdentityAvatarListResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityAvatarListResData mmmmmmmmmmmm>>", receivedIdentityAvatarListResData);
                    break;

                case 104:
                    const receivedIdentityAvatarChangeResData = window[IdentityAvatarChangeResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityAvatarChangeResData mmmmmmmmmmmm>>", receivedIdentityAvatarChangeResData);
                    break;

                case 105:
                    const receivedIdentityInstitutionInfoResData = window[IdentityInstitutionInfoResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityInstitutionInfoResData mmmmmmmmmmmm>>", receivedIdentityInstitutionInfoResData);
                    break;

                case 106:
                    const receivedIdentityInstitutionEnrollmentResData = window[IdentityInstitutionEnrollmentResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityInstitutionEnrollmentResData mmmmmmmmmmmm>>", receivedIdentityInstitutionEnrollmentResData);
                    break;

                case 107:
                    const receivedIdentityEnrollmentListResData = window[IdentityEnrollmentListResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityEnrollmentListResData mmmmmmmmmmmm>>", receivedIdentityEnrollmentListResData);
                    break;

                case 108:
                    const receivedIdentityEnrollmentConfirmResData = window[IdentityEnrollmentConfirmResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityEnrollmentConfirmResData mmmmmmmmmmmm>>", receivedIdentityEnrollmentConfirmResData);
                    break;

                case 109:
                    const receivedIdentityEnrollmenterInfoResData = window[IdentityEnrollmenterInfoResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityEnrollmenterInfoResData mmmmmmmmmmmm>>", receivedIdentityEnrollmenterInfoResData);
                    break;

                case 110:
                    const receivedIdentityEnrollmentReplyResData = window[IdentityEnrollmentReplyResName].decode(receivedPacketData.Data);
                    console.log("receivedIdentityEnrollmentReplyResData mmmmmmmmmmmm>>", receivedIdentityEnrollmentReplyResData);
                    break;

                case 112:
                    const receivedLoginInstituteRegistResData = window[LoginInstituteRegistResName].decode(receivedPacketData.Data);
                    console.log("receivedLoginInstituteRegistResData mmmmmmmmmmmm>>", receivedLoginInstituteRegistResData);
                    break;

                case 113:
                    const receivedLoginIdentityRegistResData = window[LoginIdentityRegistResName].decode(receivedPacketData.Data);
                    console.log("receivedLoginIdentityRegistResData mmmmmmmmmmmm>>", receivedLoginIdentityRegistResData);
                    break;

                case 120:
                    const receivedSysWorldSetInfoResData = window[SysWorldSetInfoResName].decode(receivedPacketData.Data);
                    console.log("receivedSysWorldSetInfoResData mmmmmmmmmmmm>>", receivedSysWorldSetInfoResData);
                    break;

                case 127:
                    const receivedSysWorldInterObjSetCreateResData = window[SysWorldInterObjSetCreateResName].decode(receivedPacketData.Data);
                    console.log("receivedSysWorldInterObjSetCreateResData mmmmmmmmmmmm>>", receivedSysWorldInterObjSetCreateResData);
                    break;

                case 128:
                    const receivedSysWorldInterObjSetInitResData = window[SysWorldInterObjSetInitResName].decode(receivedPacketData.Data);
                    console.log("receivedSysWorldInterObjSetInitResData mmmmmmmmmmmm>>", receivedSysWorldInterObjSetInitResData);
                    break;

                case 201:
                    const receivedMyInstitutionListData = window[MyInstitutionListName].decode(receivedPacketData.Data);
                    console.log("receivedMyInstitutionListData mmmmmmmmmmmm>>", receivedMyInstitutionListData);
                    break;

                case 401:
                    const receivedJwtExceptionData = window[JwtExceptionName].decode(receivedPacketData.Data);
                    console.log("receivedJwtExceptionData mmmmmmmmmmmm>>", receivedJwtExceptionData);
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
