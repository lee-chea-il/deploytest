<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Hello2</title>
</head>
<body>
  <h1>WebSocket API Test Page</h1>

  <div class="well">
    <button id="btnOpen" class="btn btn-primary">open socket</button>
    <select id="OpCode" class="form-control">
      <option value="100">신분 생성</option>
      <option value="101" selected>신분 조회</option>
      <option value="102" >아바타 생성</option>
      <option value="103" >아바타 조회</option>
      <option value="104" >아바타 변경</option>
      <option value="105" >교육기관 조회</option>
      <option value="106" >교육기관 등록요청</option>
      <option value="201" >소속기관조회</option>
    </select>
    <button id="btnSend" class="btn btn-primary">Send Message</button>
  </div>
  <div>Result</div>

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  <script src="//cdn.jsdelivr.net/npm/protobufjs@7.1.2/dist/protobuf.js"></script>
  <script src="js/util.js"></script>
  <script>
  
    //---------------------------------------------------------------------------------------------------
    // window[]를 통해서 브라우저상에 전역변수(global)로 지정할때 사용하는 변수  
    
      //필수객체 및 에러관련 
      const PacketName = "PacketData";
      const JwtExceptionName = "JwtException";
    
      //신분
      const IdentityListReqName = "IdentityListReq";
      const IdentityListResName = "IdentityListRes";
      const IdentityCreateReqName = "IdentityCreateReq";
      const IdentityCreateResName = "IdentityCreateRes";
      
      //아바타
      const IdentityAvatarCreateReqName = "IdentityAvatarCreateReq";
      const IdentityAvatarCreateResName = "IdentityAvatarCreateRes";
      const IdentityAvatarDetailReqName = "IdentityAvatarDetailReq";
      const IdentityAvatarDetailResName = "IdentityAvatarDetailRes";
      const IdentityAvatarChangeReqName = "IdentityAvatarChangeReq";
      const IdentityAvatarChangeResName = "IdentityAvatarChangeRes";
      
      //교육기관 등록요청
      const IdentityInstitutionInfoReqName = "IdentityInstitutionInfoReq";
      const IdentityInstitutionInfoResName = "IdentityInstitutionInfoRes";
      const IdentityInstitutionEnrollmentRequestReqName = "IdentityInstitutionEnrollmentRequestReq";
      const IdentityInstitutionEnrollmentRequestResName = "IdentityInstitutionEnrollmentRequestRes";
      
      //로비
      const MyInstitutionListName = "MyInstitutionList";

    //---------------------------------------------------------------------------------------------------
    // protobuf.load시에 로딩할 protobuf 파일 경로 지정  
    
			const commonPath = "../proto"
			const protoFileList = [ 
				commonPath.concat("/member/response/IdentityListRes.proto"),
				commonPath.concat("/member/request/IdentityListReq.proto"),
				commonPath.concat("/member/request/IdentityCreateReq.proto"),
				commonPath.concat("/member/response/IdentityCreateRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarCreateReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarCreateRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarDetailReq.proto"),
        commonPath.concat("/member/response/IdentityAvatarDetailRes.proto"),
        commonPath.concat("/member/request/IdentityAvatarChangeReq.proto"),
				commonPath.concat("/member/response/IdentityAvatarChangeRes.proto"),
				commonPath.concat("/member/request/IdentityInstitutionInfoReq.proto"),
				commonPath.concat("/member/response/IdentityInstitutionInfoRes.proto"),
				commonPath.concat("/member/request/IdentityInstitutionEnrollmentRequestReq.proto"),
        commonPath.concat("/member/response/IdentityInstitutionEnrollmentRequestRes.proto"),
				commonPath.concat("/member/request/SWclassIdentityInfo.proto"),
				commonPath.concat("/lobby/home/response/SWclassMyInstitutionList.proto"),
				commonPath.concat("/common/PacketData.proto"),
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
			
			$(document).ready(function() {
				$("#btnOpen").on("click", function(evt) {
					connectWS();
				});

				$("#btnSend").on("click", function(evt) {
					 console.clear();
					
					 let OpCode = getOpCodeFromSelectBox();
					 
					 let Data = new Uint8Array([]);
					
			     protobuf.load(protoFileList, function(err, root) {
			    	  console.log("INFO: protobuf files loaded.");
			    	  
			    	  loadMessage(root, PacketName, "Classlink.PacketData");
			    	  loadMessage(root, JwtExceptionName, "Classlink.JwtException");

			    	  switch (OpCode) {
			    	    //신분생성-----------------------------------------------------------------------------------------
                case 100 :
                  loadMessage(root, IdentityCreateReqName, "Classlink.IdentityCreateReq");
                  loadMessage(root, IdentityCreateResName, "Classlink.IdentityCreateRes");
                  
                  const IdentityCreateReqObj = {
                  		InsCode : 'testA',
                  		IdentityType : 'T'
                    };
                  
                  Data = setDataToSend(root, IdentityCreateReqName, IdentityCreateReqObj);
                  break;
                //신분조회-----------------------------------------------------------------------------------------
			    	  	case 101 :
			    	  		loadMessage(root, IdentityListReqName, "Classlink.IdentityListReq");
			    	  		loadMessage(root, IdentityListResName, "Classlink.IdentityListRes");
			    	  		
			    	  		
			    	  		const IdentityListReqObj = {
                      InsCode : ''
                    };
                  
                  Data = setDataToSend(root, IdentityListReqName, IdentityListReqObj);
			    	  	  break;
			    	  	//아바타생성-----------------------------------------------------------------------------------------
			    	  	case 102 :
                  loadMessage(root, IdentityAvatarCreateReqName, "Classlink.IdentityAvatarCreateReq");
                  loadMessage(root, IdentityAvatarCreateResName, "Classlink.IdentityAvatarCreateRes");
                  
                  const IdentityAvatarCreateReqObj = {
                      InsCode : 'testA',
                      IdentityType : 'P',
                      AvatarId : '150'
                    };
                  
                  Data = setDataToSend(root, IdentityAvatarCreateReqName, IdentityAvatarCreateReqObj);
                  break;
                //아바타 조회-----------------------------------------------------------------------------------------
			    	  	case 103 :
                  loadMessage(root, IdentityAvatarDetailReqName, "Classlink.IdentityAvatarDetailReq");
                  loadMessage(root, IdentityAvatarDetailResName, "Classlink.IdentityAvatarDetailRes");
                  
                  const IdentityAvatarDetailReqObj = {
                      //InsCode : 'testA',
                      IdentityType : 'P',
                    };
                  
                  Data = setDataToSend(root, IdentityAvatarDetailReqName, IdentityAvatarDetailReqObj);
                  break;
                //아바타 변경-----------------------------------------------------------------------------------------
			    	  	case 104 :
                  loadMessage(root, IdentityAvatarChangeReqName, "Classlink.IdentityAvatarChangeReq");
                  loadMessage(root, IdentityAvatarChangeResName, "Classlink.IdentityAvatarChangeRes");
                  
                  const IdentityAvatarChangeReqObj = {
                      InsCode : 'testA',
                      IdentityType : 'P',
                      AvatarId : '155'
                    };
                  
                  Data = setDataToSend(root, IdentityAvatarChangeReqName, IdentityAvatarChangeReqObj);
                  break;
                //-----------------------------------------------------------------------------------------
                case 105 :
                  loadMessage(root, IdentityInstitutionInfoReqName, "Classlink.IdentityInstitutionInfoReq");
                  loadMessage(root, IdentityInstitutionInfoResName, "Classlink.IdentityInstitutionInfoRes");
                  
                  const IdentityInstitutionInfoReqObj = {
                      InsCode : 'testA',
                      InsInviteUrl : '/img/url'
                    };
                  
                  Data = setDataToSend(root, IdentityInstitutionInfoReqName, IdentityInstitutionInfoReqObj);
                  break;
                //-----------------------------------------------------------------------------------------
                case 106 :
                  loadMessage(root, IdentityInstitutionEnrollmentRequestReqName, "Classlink.IdentityInstitutionEnrollmentRequestReq");
                  loadMessage(root, IdentityInstitutionEnrollmentRequestResName, "Classlink.IdentityInstitutionEnrollmentRequestRes");
                  
                  const IdentityInstitutionEnrollmentRequestReqObj = {
                      InsCode : 'testA'
                    };
                  
                  Data = setDataToSend(root, IdentityInstitutionEnrollmentRequestReqName, IdentityInstitutionEnrollmentRequestReqObj);
                  break;
                //-----------------------------------------------------------------------------------------  
                case 201 :
                  loadMessage(root, MyInstitutionListName, "Classlink.SWclassMyInstitutionList");
                  break;
                  
			    	    default:
			    	    	break;
			    	  }
			    	  
              const PacketObj = {
                  OpCode : OpCode,
                  AccessToken : "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NzAwMzQwNzcsInVzZXJfbmFtZSI6InRlc3Q3Nzc3IiwianRpIjoiMTA0NmMyZTAtNWI5Ni00YzRkLWEzYTItNDg3N2M0NTQyOTkxIiwiY2xpZW50X2lkIjoiY2xhc3NsaW5rIiwic2NvcGUiOlsiY2xpZW50Il19.WsJ679RyHKaIJRV1inHdQHrqzoSB9fLaq8F2Rv3wLUA",
                  InstanceId : '2',
                  Data : Data
                };
		          
              console.log("INFO: send triggered.");
              socket.send(setDataToSend(root, PacketName, PacketObj));
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

				ws.onopen = function() {
					console.log("INFO: connection opened.");
				};

				ws.onmessage = async function(event) {
					console.timeEnd("TIME");
					console.log("INFO: onmessage triggered.");
					
					let blob = event.data;
					
					const receivedPacketData = await readBlobDataAsync(blob, PacketName);
					
					switch(receivedPacketData.OpCode) {
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
              const receivedIdentityAvatarDetailResData = window[IdentityAvatarDetailResName].decode(receivedPacketData.Data);      
              console.log("receivedIdentityAvatarDetailResData mmmmmmmmmmmm>>", receivedIdentityAvatarDetailResData);
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
              const receivedIdentityInstitutionEnrollmentRequestResData = window[IdentityInstitutionEnrollmentRequestResName].decode(receivedPacketData.Data);      
              console.log("receivedIdentityInstitutionEnrollmentRequestResData mmmmmmmmmmmm>>", receivedIdentityInstitutionEnrollmentRequestResData);
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

				ws.onclose = function(event) {
					console.log("INFO: connection closed.");
					//setTimeout( function(){ connect(); }, 1000); // retry connection!!
				};
				
				ws.onerror = function(err) {
					console.log("Error:", err);
				};
			}
		</script>
</body>
</html>
