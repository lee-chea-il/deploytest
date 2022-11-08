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
    <input type="number" id="opCode" value="101" class="form-control" />
    <button id="btnSend" class="btn btn-primary">Send Message</button>
  </div>
  <div>Result</div>

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  <script src="//cdn.jsdelivr.net/npm/protobufjs@7.1.2/dist/protobuf.js"></script>
  <script src="js/util.js"></script>
  <script>

			const IdentityName = "Identity";
			const PacketName = "Packet";

			const commonPath = "../proto"
			const protoFileList = [ commonPath.concat("/member/Identity.proto"), commonPath.concat("/common/PacketData.proto") ];


			//---------------------------------------------------------------------------------------------------

			$(document).ready(function() {
				$("#btnOpen").on("click", function(evt) {
					connectWS();
				});

				$("#btnSend").on("click", function(evt) {
					
					 let OpCode = parseInt(document.getElementById("opCode").value);
					
			     protobuf.load(protoFileList, function(err, root) {
			    	  console.log("Info: protobuf files onloaded.");
			    	  
			        loadMessage(root, IdentityName, "tutorial.IdentityData");
			        loadMessage(root, PacketName, "tutorial.PacketData");

			        const PacketDataObj = {
			          OpCode : OpCode,
			          accessToken : "1234",
			          instanceId : "2"
			        //data : encodedMemberIdentity
			        };

			        setDataToSend(root, PacketName, PacketDataObj);
			        
		          console.log("Info: send triggered.");
		          let message = getEncodedData(PacketName);

		          console.log("deserializedDataToSend mmmmmmmmmmmm>>", getDecodedData(PacketName));
		          console.log("deserializedInnerDataToSend mmmmmmmmmmmm>>", Identity.decode(getDecodedData(PacketName).data));

		          socket.send(message);
		          
		          if (socket.readyState !== 1)
		            return;
		          });

			      });
				
			});

			let socket = null;

			// pure web-socket
			function connectWS() {
				//var ws = new WebSocket("ws:112.171.101.31:45170/api");
				let ws = new WebSocket("ws:localhost:8301/api");
				socket = ws;

				ws.onopen = function() {
					console.log("Info: connection opened.");
				};

				ws.onmessage = async function(event) {
					console.log("Info: onmessage triggered.");
					
					const blob = event.data;
					
					await readBlobDataAsync(blob, PacketName);
					
					let OpCode = parseInt(document.getElementById("opCode").value);
					
					switch(OpCode) {
						case 101:
							const receivedIdentityData = Identity.decode(deserializedPacketData.data);
	            console.log("receivedDeserializedInnerData mmmmmmmmmmmm>>", receivedIdentityData);
	            break;
						default:
							break;
					}
					
				  
				};

				ws.onclose = function(event) {
					console.log("Info: connection closed.");
					//setTimeout( function(){ connect(); }, 1000); // retry connection!!
				};
				
				ws.onerror = function(err) {
					console.log("Error:", err);
				};
			}
		</script>
</body>
</html>
