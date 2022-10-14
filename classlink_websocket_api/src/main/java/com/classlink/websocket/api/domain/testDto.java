package com.classlink.websocket.api.domain;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping
public class testDto extends PacketHeader {
	private String name;
	private int age;
}
