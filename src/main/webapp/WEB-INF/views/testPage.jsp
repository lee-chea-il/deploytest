<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/protobufjs@7.1.2/dist/protobuf.js"></script>
	<!--<script type="module" src="./app.js" defer></script>-->
	<script>
		console.log(protobuf);
		var message = null;
		var buffer = null;

		var globalRoot = null;
		var Person = null;

		var timestampStart = null;
		var Timestamp = null;

		var PersonSerializedData = null;
		var PersonDeserializedData = null;
		var PersonToObject = null;

		var root = protobuf.Root.fromJSON({}).addJSON().resolveAll();

		protobuf.load("js/testProto.proto", function(err, root) {
			console.log(root);
			globalRoot = root;

			Person = root.lookupType("tutorial.Person");

			console.log(Person);

			var PersonObj = {
				OpCode : 121,
				name : "suyeong",
				email : "qkdptwls_@naver.com",
			};

			var verifyMsg = Person.verify(PersonObj);
			if (verifyMsg) {
				throw Error(verifyMsg);
			}

			message = Person.create(PersonObj);

			PersonSerializedData = Person.encode(message).finish();

			PersonToObject = Person.toObject(message, {
				enums : String, // enums as string names
				longs : String, // longs as strings (requires long.js)
				bytes : String, // bytes as base64 encoded strings
				defaults : true, // includes default values
				arrays : true, // populates empty arrays (repeated fields) even if defaults=false
				objects : true, // populates empty objects (map fields) even if defaults=false
				oneofs : true, // includes virtual oneof fields set to the present field's name
			});
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

				let msg = PersonSerializedData;
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

		var socket = null;
		var isStomp = false;

		// pure web-socket
		function connectWS() {
			console.log("tttttttttttttt");
			//var ws = new WebSocket("ws:112.171.101.31:45170/api?token=11234");
			var ws = new WebSocket("ws:localhost:8301/api");
			socket = ws;

			ws.onopen = function() {
				console.log("Info: connection opened.");
			};

			ws.onmessage = function(event) {
				const blob = event.data;
				const fileReader = new FileReader();

				fileReader.onload = function(event) {
					const arrayBuffer = event.target.result;
					const deserializedData = getObjectFromArrayBuffer(arrayBuffer);
					console.log("receivedDeserializedData", deserializedData);
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
