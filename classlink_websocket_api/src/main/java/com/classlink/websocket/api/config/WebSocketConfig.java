package com.classlink.websocket.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.classlink.websocket.api.handler.WebSocketHandler;
import com.classlink.websocket.api.interceptor.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	private final WebSocketHandler webSocketHandler;

	public WebSocketConfig(WebSocketHandler webSocketHandler) {
		this.webSocketHandler = webSocketHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/api").addInterceptors(new HandshakeInterceptor()).setAllowedOrigins("*");

	}

	/*
	 * @Override public void configureMessageBroker(MessageBrokerRegistry
	 * registry) { registry.enableSimpleBroker("/topic");
	 * registry.setApplicationDestinationPrefixes("/"); }
	 * 
	 * @Override public void registerStompEndpoints(StompEndpointRegistry
	 * registry) { registry.addEndpoint("/test").setAllowedOrigins("*"); }
	 */

}
