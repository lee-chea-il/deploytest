package com.classlink.websocket.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
public class ConfigProperties {
	@Value("${server.live}")
	private boolean serverLive;
}

