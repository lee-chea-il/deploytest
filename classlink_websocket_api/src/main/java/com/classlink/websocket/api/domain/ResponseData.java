package com.classlink.websocket.api.domain;

import lombok.Data;

@Data
public class ResponseData extends PacketHeader {
	public Object Data;
}
