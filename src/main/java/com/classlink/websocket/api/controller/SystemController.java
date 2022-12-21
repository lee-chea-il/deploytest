package com.classlink.websocket.api.controller;

import com.classlink.websocket.api.common.OpCode;
import com.classlink.websocket.api.common.OpCodeMapping;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.system.SystemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SystemController {
	
	private final SystemService systemService;

	@OpCodeMapping(value = OpCode.SYS_WORLD_SET_INFO)
	public void SysWorldSetInfo(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldSetInfo(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SYS_WORLD_OBJ_SET_CREATE_LIST)
	public void SysWorldObjCreateSetList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldObjCreateSet(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SYS_WORLD_OBJ_SET_INIT_LIST)
	public void SysWorldObjSetInitList(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldObjSetInit(packetReqProto, memId));
	}

}
