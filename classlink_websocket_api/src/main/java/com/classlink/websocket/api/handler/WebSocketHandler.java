package com.classlink.websocket.api.handler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.classlink.websocket.api.common.OpCodeAnnotation;
import com.classlink.websocket.api.domain.testDto;
import com.classlink.websocket.api.util.JwtTokenParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();

	@Autowired
	JwtTokenParser jwtTokenParser;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		/*
		 * CLIENTS.put(session.getId(), session); Map<String, Object> map =
		 * session.getAttributes(); String token = map.get("token").toString();
		 * 
		 * try { Claims claims = jwtTokenParser.parseJwtToken(token); } catch (Exception
		 * ex) { System.out.println("여기오나? : "+ token); session.close(); }
		 */
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		CLIENTS.remove(session.getId());

	}

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {

		// Reflections 클래스는 원하는 클래스를 찾기 위해 사용
		// 파라미터값은 클래스를 찾을때 출발 패키지
		// "" -> classpath 모든 패키지 검색
		Reflections reflector = new Reflections("com.classlink.websocket.api.Controller");

		// getTypesAnnotatedWith():
		// 파라미터값으로 넘긴 어노테이션이 붙은 클래스를 찾는다.
		// 반환값: Controller 어노테이션이 선언된 클래스 목록

		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Controller.class);
		String key = null;

		for (Class<?> clazz : list) {
			// getAnnotation(): 클래스로부터 어노테이션 추출
			key = clazz.getMethods()[0].getAnnotation(OpCodeAnnotation.class).value();
			System.out.println(clazz.getName() + "(" + key + ") -> 객체 준비 완료");
		}
	}
}