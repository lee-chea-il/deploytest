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
      <option value="100">신분생성</option>
      <option value="101" selected>신분조회</option>
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
    
      const PacketName = "PacketData";
      const JwtExceptionName = "JwtException";
    
      const IdentityListName = "IdentityList";
      const IdentityCreateName = "IdentityCreate";

    //---------------------------------------------------------------------------------------------------
    // protobuf.load시에 로딩할 protobuf 파일 경로 지정  
    
			const commonPath = "../proto"
			const protoFileList = [ commonPath.concat("/member/response/SWclassIdentityList.proto"),
				commonPath.concat("/member/request/SWclassIdentityCreate.proto"),
				commonPath.concat("/member/request/SWclassIdentityInfo.proto"),
				commonPath.concat("/common/PacketData.proto"),
				commonPath.concat("/jwt/jwtException.proto")];

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
                case 100 :
                  loadMessage(root, IdentityCreateName, "Classlink.SWclassIdentityCreate");
                  
                  const IdentityCreateObj = {
                  		IdtCode : '3',
                  		MemIdx : 7,
                    };
                  
                  Data = setDataToSend(root, IdentityCreateName, IdentityCreateObj);
                  break;
                  
			    	  	case 101 :
			    	  		loadMessage(root, IdentityListName, "Classlink.SWclassIdentityList");
			    	  	  break;
                  
			    	    default:
			    	    	break;
			    	  }
			    	  
              const PacketObj = {
                  OpCode : OpCode,
                  AccessToken : "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgyMjM4NDYsInVzZXJfbmFtZSI6InF3ZXIiLCJqdGkiOiIwYTAwZTc0NS0xNjlkLTRmNDUtYTk3YS1lOWExZDk5ZjdiMjYiLCJjbGllbnRfaWQiOiJjbGFzc2xpbmsiLCJzY29wZSI6WyJjbGllbnQiXX0.plkCZq3-f1rJ3D5hdqo8GsJaomcw8Ivz-LTEQsi4g5k",
                  InstanceId : 2,
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
              break;
              
						case 101:		
							const receivedIdentityListNameData = window[IdentityListName].decode(receivedPacketData.Data);			
	            console.log("receivedIdentityListData mmmmmmmmmmmm>>", receivedIdentityListNameData);
	            break;
	            
	          case 401:   
              const receivedJwtExceptionNameData = window[JwtExceptionName].decode(receivedPacketData.Data);      
              console.log("receivedJwtExceptionNameData mmmmmmmmmmmm>>", receivedJwtExceptionNameData);
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
