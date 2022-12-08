package com.classlink.websocket.api.handler;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.jwt.JwtExceptionResponseController;
import com.classlink.websocket.api.util.BeanUtils;
import com.classlink.websocket.api.util.JwtTokenParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();

	@Autowired
	JwtTokenParser jwtTokenParser;
	
	@Autowired
	JwtExceptionResponseController jwtExceptionResponseController;

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
		Reflections reflector = new Reflections(
				new ConfigurationBuilder().forPackages("com.classlink.websocket.api.controller"));

		// getTypesAnnotatedWith():
		// 파라미터값으로 넘긴 어노테이션이 붙은 클래스를 찾는다.
		// 반환값: Controller 어노테이션이 선언된 클래스 목록
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Controller.class);

		boolean stop = false;
		int opCode = 0;
		String userId = null;
		try {
			RequestPacket deserializedParam = RequestPacket.newBuilder().mergeFrom(message.getPayload().array())
					.build();
			log.info(String.valueOf(deserializedParam.getOpCode()));
			log.info(deserializedParam.getAccessToken());
			log.info(String.valueOf(deserializedParam.getInstanceId()));
			log.info(deserializedParam.getData().toString());

			// 토큰 유효성 검사
			if (jwtTokenParser.checkClaim(deserializedParam.getAccessToken())) {
				// 토큰이 유효할때 호출할 opCode 및 userId 처리
				opCode = deserializedParam.getOpCode();
				userId = jwtTokenParser.getUserId(deserializedParam.getAccessToken());
			} else {
				// 토큰이 유효하지 않을때 호출할 opCode 처리 및 message 전송
				jwtExceptionResponseController.tokenException(session, deserializedParam);
			}

			for (Class<?> clazz : list) {
				int cnt = 0;
				Method[] methods = clazz.getDeclaredMethods();

				for (Method method : methods) {
					if (method.isAnnotationPresent(OpCodeMapping.class)) {
						OpCode key = method.getDeclaredAnnotation(OpCodeMapping.class).value();

						if (key.getCode() == opCode) {
							// method 호출
							log.info("clazz name : " + clazz.getName());
							log.info("clazz getSimpleName : " + clazz.getSimpleName());
							log.info("clazz getTypeName : " + clazz.getTypeName());
							log.info("clazz : " + BeanUtils.getBean(clazz));

							method.invoke(BeanUtils.getBean(clazz), session, deserializedParam, userId);
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