package com.classlink.websocket.api.util;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;

import com.classlink.websocket.api.config.ApplicationContextProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtils {
	public static Object getBean(Class<?> classType) {
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
		log.info("registerd beans" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
		return applicationContext.getBean(classType);
	}
}
