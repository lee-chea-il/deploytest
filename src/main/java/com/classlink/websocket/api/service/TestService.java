package com.classlink.websocket.api.service;

import java.io.IOException;

import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.domain.PacketHeader;
import com.classlink.websocket.api.domain.PacketData;
import com.classlink.websocket.api.domain.testDto;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class TestService {
	public BinaryMessage test(BinaryMessage message) throws StreamReadException, DatabindException, IOException {

		ObjectMapper param = new ObjectMapper(new MessagePackFactory());
		byte[] byte1 = message.getPayload().array();
		
		PacketData bindClass = PacketData.builder().data(testDto.builder().getClass()).opCode(0).token(null).build();
		PacketData deserializedParam = param.readValue(byte1, bindClass.getClass());
		byte[] parambytes = param.writeValueAsBytes(deserializedParam.getData());
		
		log.info("param opCode? ="+ deserializedParam.getOpCode());
		log.info("param token? ="+ deserializedParam.getToken());
		log.info("param data? =" + deserializedParam.getData());
		
		testDto testdto = param.readValue(parambytes, testDto.class);
		log.info("param name? ="+testdto.getName());
		

		ObjectMapper result = new ObjectMapper(new MessagePackFactory());
		testDto asdf = testDto.builder().age(20).name("김연아").build();

		PacketData temp = PacketData.builder().opCode(201).token("asdfasdfasdf").data(testdto).build();
		byte[] bytes = result.writeValueAsBytes(temp);
		return new BinaryMessage(bytes);
	}

	public BinaryMessage test1(BinaryMessage message) throws StreamReadException, DatabindException, IOException {

		ObjectMapper param = new ObjectMapper(new MessagePackFactory());
		byte[] byte1 = message.getPayload().array();
		
		PacketData bindClass = PacketData.builder().data(testDto.builder().getClass()).opCode(0).token(null).build();
		PacketData deserializedParam = param.readValue(byte1, bindClass.getClass());
		byte[] parambytes = param.writeValueAsBytes(deserializedParam.getData());
		
		log.info("param opCode? ="+ deserializedParam.getOpCode());
		log.info("param token? ="+ deserializedParam.getToken());
		log.info("param data? =" + deserializedParam.getData());
		
		testDto testdto = param.readValue(parambytes, testDto.class);
		log.info("param name? ="+testdto.getName());
		

		ObjectMapper result = new ObjectMapper(new MessagePackFactory());
		testDto asdf = testDto.builder().age(20).name("김연아").build();

		PacketData temp = PacketData.builder().opCode(202).token("asdfasdfd").data(testdto).build();
		byte[] bytes = result.writeValueAsBytes(temp);
		return new BinaryMessage(bytes);
	}
}
