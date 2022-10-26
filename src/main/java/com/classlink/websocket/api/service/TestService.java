package com.classlink.websocket.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.domain.Packet.PacketData;
import com.classlink.websocket.api.domain.TestProtoBuffDto.Person;
import com.classlink.websocket.api.domain.WebSocketMessagePackTestClass.WebSocketMessagePackTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {
	/*
	 * public BinaryMessage test(BinaryMessage message) throws StreamReadException,
	 * DatabindException, IOException {
	 * 
	 * ObjectMapper param = new ObjectMapper(new MessagePackFactory()); byte[] byte1
	 * = message.getPayload().array();
	 * 
	 * PacketData deserializedParam = param.readValue(byte1, PacketData.class);
	 * 
	 * log.info("param opCode? =" + deserializedParam.getOpCode());
	 * log.info("param token? =" + deserializedParam.getAccessToken());
	 * //log.info("param data? =" + deserializedParam.getMessagePackData());
	 * 
	 * //testDto testdto = param.readValue(deserializedParam.getMessagePackData(),
	 * testDto.class); //log.info("param name? =" + testdto.getName());
	 * 
	 * ObjectMapper result = new ObjectMapper(new MessagePackFactory()); testDto
	 * asdf = testDto.builder().age(20).name("김연아").build(); byte[] dto =
	 * result.writeValueAsBytes(asdf); PacketData temp =
	 * PacketData.builder().opCode(202).accessToken("asdfasdfd").messagePackData(dto
	 * ).build(); byte[] bytes = result.writeValueAsBytes(temp); return new
	 * BinaryMessage(bytes); }
	 * 
	 * public BinaryMessage test1(BinaryMessage message) throws StreamReadException,
	 * DatabindException, IOException {
	 * 
	 * ObjectMapper param = new ObjectMapper(new MessagePackFactory()); byte[] byte1
	 * = message.getPayload().array();
	 * 
	 * PacketData deserializedParam = param.readValue(byte1, PacketData.class);
	 * 
	 * log.info("param opCode? =" + deserializedParam.getOpCode());
	 * log.info("param token? =" + deserializedParam.getAccessToken());
	 * log.info("param data? =" + deserializedParam.getMessagePackData());
	 * 
	 * testDto testdto = param.readValue(deserializedParam.getMessagePackData(),
	 * testDto.class); log.info("param name? =" + testdto.getName());
	 * 
	 * ObjectMapper result = new ObjectMapper(new MessagePackFactory()); testDto
	 * asdf = testDto.builder().age(20).name("김연아").build(); byte[] dto =
	 * result.writeValueAsBytes(asdf); PacketData temp =
	 * PacketData.builder().opCode(202).accessToken("asdfasdfd").messagePackData(dto
	 * ).build(); byte[] bytes = result.writeValueAsBytes(temp); return new
	 * BinaryMessage(bytes); }
	 */
	public BinaryMessage testPacketDto(PacketData param) throws InvalidProtocolBufferException {
		//data 부분 역직렬화
		WebSocketMessagePackTest deserialized = WebSocketMessagePackTest.newBuilder().mergeFrom(param.getData())
				.build();

		log.info("name ? =" + deserialized.getName());
		log.info("age ? =" + deserialized.getAge());
		log.info("height ? =" + deserialized.getHeight());
		log.info("weight ? =" + deserialized.getWeight());
		log.info("birthday ? =" + deserialized.getTestInnerClass().getBirthday(0));
		log.info("toByteArray ? =" + deserialized.toByteArray().toString());
		
		//PacketData 직렬화
		PacketData result = PacketData.newBuilder().setOpCode(205).setAccessToken(param.getAccessToken())
				.setInstanceId(param.getInstanceId()).setData(deserialized.toByteString()).build();

		return new BinaryMessage(result.toByteArray());
	}
}
