<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Hello2</title>
</head>
<body>
  <h1>Thymeleaf Test Page</h1>
  <!--<h3 th:text="${uname}"></h3>-->

  <div class="well">
    <button id="btnOpen" class="btn btn-primary">open socket</button>
    <input type="text" id="msg" value="1212" class="form-control" />
    <button id="btnSend" class="btn btn-primary">Send Message</button>
  </div>

  <!--<p th:text="'Name: ' + ${name}"></p>-->

  <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
  <script src="//cdn.jsdelivr.net/npm/protobufjs@7.1.2/dist/protobuf.js"></script>
  <!--<script type="module" src="./app.js" defer></script>-->
  <script>
			let globalRoot = null;

			let MemberIdentity = null;
			let PacketData = null;

			let createdPacketData = null;
			let encodedPacketData = null;
			let decodedPacketData = null;

			//var root = protobuf.Root.fromJSON({}).addJSON().resolveAll();

			const commonPath = "js/"
			const protoFileList = [ commonPath.concat("memberIdentity.proto"), commonPath.concat("PacketData.proto") ];

			protobuf.load(protoFileList, function(err, root) {

				console.log("root : " + root);
				console.log("err : " + err);
				globalRoot = root;

				MemberIdentity = root.lookupType("tutorial.MemberIdentityData");
				PacketData = root.lookupType("tutorial.PacketData");

				const MemberIdentityObj = {
					MdtIdx : 1,
					IdtCode : 1,
					MemIdx : 7,
					DeleteYn : 'N'
				};

				let verifyMsg = MemberIdentity.verify(MemberIdentityObj);
				if (verifyMsg) {
					throw Error(verifyMsg);
				}

				const createdMemberIdentity = MemberIdentity.create(MemberIdentityObj);
				const encodedMemberIdentity = MemberIdentity.encode(createdMemberIdentity).finish();

				const PacketDataObj = {
					OpCode : 101,
					accessToken : "1234",
					instanceId : "2",
					data : encodedMemberIdentity
				};

				verifyMsg = PacketData.verify(PacketDataObj);
				if (verifyMsg) {
					throw Error(verifyMsg);
				}

				createdPacketData = PacketData.create(PacketDataObj);
				encodedPacketData = PacketData.encode(createdPacketData).finish();
				decodedPacketData = PacketData.decode(encodedPacketData);

			});
			//---------------------------------------------------------------------------------------------------

			// Deserialize again
			// var deserializedDataToSend = msgpack.deserialize(serializedDataToSend);

			$(document).ready(function() {
				$("#btnOpen").on("click", function(evt) {
					connectWS();
					//connectSockJS();
					//connectStomp();
				});

				$("#btnSend").on("click", function(evt) {
					console.log("실행!!");

					let msg = encodedPacketData;

					console.log("serializedDataToSend mmmmmmmmmmmm>>", msg);
					console.log("deserializedDataToSend mmmmmmmmmmmm>>", decodedPacketData);
					console.log("deserializedInnerDataToSend mmmmmmmmmmmm>>", MemberIdentity.decode(decodedPacketData.data));

					socket.send(msg);
					console.log("socket.send 실행!!");

					evt.preventDefault();

					if (!isStomp && socket.readyState !== 1)
						return;

					if (isStomp)
						socket.send("/TTT", {}, JSON.stringify({
							roomid : "message",
							id : 124,
							msg : msg
						}));
				});
			});

			let socket = null;
			let isStomp = false;

			// pure web-socket
			function connectWS() {
				console.log("tttttttttttttt");
				//var ws = new WebSocket("ws:112.171.101.31:45170/api");
				let ws = new WebSocket("ws:localhost:8301/api");
				socket = ws;

				ws.onopen = function() {
					console.log("Info: connection opened.");
				};

				ws.onmessage = function(event) {
					const blob = event.data;
					const fileReader = new FileReader();

					fileReader.onload = function(event) {
						const arrayBuffer = event.target.result;
						console.log(arrayBuffer);
						const deserializedPacketData = PacketData.decode(new Uint8Array(arrayBuffer));
						console.log("receivedDeserializedData mmmmmmmmmmmm>>", deserializedPacketData);
						console.log("receivedDeserializedInnerData mmmmmmmmmmmm>>", MemberIdentity.decode(deserializedPacketData.data));

					};

					fileReader.readAsArrayBuffer(blob);
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
