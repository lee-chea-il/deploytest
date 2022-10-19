package com.classlink.websocket.api.handler;

import java.lang.reflect.Method;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.domain.PacketHeader;
import com.classlink.websocket.api.util.JwtTokenParser;
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

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		CLIENTS.remove(session.getId());
	}

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
		log.info("start? =" + 0);
		// Reflections 클래스는 원하는 클래스를 찾기 위해 사용
		// 파라미터값은 클래스를 찾을때 출발 패키지
		// "" -> classpath 모든 패키지 검색
		Reflections reflector = new Reflections(new ConfigurationBuilder().forPackages("com.classlink.websocket.api.controller"));
		
		// getTypesAnnotatedWith():
		// 파라미터값으로 넘긴 어노테이션이 붙은 클래스를 찾는다.
		// 반환값: Controller 어노테이션이 선언된 클래스 목록
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Controller.class);

		ObjectMapper param = new ObjectMapper(new MessagePackFactory());
		byte[] byte1 = message.getPayload().array();
		boolean stop = false;
		PacketHeader deserializedParam;
		
		try {
			deserializedParam = param.readValue(byte1, PacketHeader.class);
			
			for (Class<?> clazz : list) {
				int cnt = 0;
				Method[] methods = clazz.getDeclaredMethods();

				for (Method method : methods) {
					if (method.isAnnotationPresent(OpCodeMapping.class)) {
						int key = method.getDeclaredAnnotation(OpCodeMapping.class).value();
						
						if (key == deserializedParam.getOpCode()) {
							// method 호출
							method.invoke(clazz.getConstructor().newInstance(), session, message);
							log.info(clazz.getName() + "(" + key + ") -> 객체 준비 완료");
							stop = true;
							break;
						}
					}
				}
				if (stop) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}