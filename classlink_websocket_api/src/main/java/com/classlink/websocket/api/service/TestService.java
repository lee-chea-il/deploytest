package com.classlink.websocket.api.service;

import java.io.IOException;

import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import com.classlink.websocket.api.domain.testDto;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestService {
	public BinaryMessage test(BinaryMessage message) throws StreamReadException, DatabindException, IOException {
		ObjectMapper param = new ObjectMapper(new MessagePackFactory());
		System.out.println(message.getPayload().array());
		byte[] byte1 = message.getPayload().array();

		testDto deserializedParam = param.readValue(byte1, testDto.class);
		System.out.println("param opCode? =" + deserializedParam.getName());
		System.out.println("param name? =" + deserializedParam.getName());
		System.out.println("param age? =" + deserializedParam.getName());

		ObjectMapper result = new ObjectMapper(new MessagePackFactory());

		testDto temp = testDto.builder().age(20).name("김연아").build();
		byte[] bytes = result.writeValueAsBytes(temp);
		System.out.println(bytes);
		// Deserialize the byte array to a Java object
		testDto deserialized = result.readValue(bytes, testDto.class);
		System.out.println(deserialized.getName());
		return new BinaryMessage(bytes);
	}
}
