package com.classlink.websocket.api.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.classlink.websocket.api.util.JwtTokenParser;

import io.jsonwebtoken.Claims;

@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	@Autowired
	JwtTokenParser jwtTokenParser;

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		// 위의 파라미터 중, attributes 에 값을 저장하면 웹소켓 핸들러 클래스의 WebSocketSession에 전달된다
		System.out.println("Before Handshake");

		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		System.out.println("URI:" + request.getURI());

		HttpServletRequest req = ssreq.getServletRequest();

		String token = req.getParameter("token");
		System.out.println("param, token:" + token);
		
		//Claims claims = jwtTokenParser.parseJwtToken(token);
		
		attributes.put("token", token);
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
		super.afterHandshake(request, response, wsHandler, ex);
	}

}
