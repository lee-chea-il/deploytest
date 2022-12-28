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
	public void sysWorldSetInfo(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldSetInfo(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SYS_WORLD_INTER_OBJ_SET_PACKAGE_CREATE)
	public void sysWorldInterObjSetPackageCreate(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldInterObjSetPackageCreate(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SYS_WORLD_INTER_OBJ_SET_CURRICULUM_CREATE)
	public void sysWorldInterObjSetCurriculumCreate(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldInterObjSetCurriculumCreate(packetReqProto, memId));
	}

	@OpCodeMapping(value = OpCode.SYS_WORLD_INTER_OBJ_SET_CURRICULUM_INIT)
	public void sysWorldInterObjSetCurriculumInit(WebSocketSession session, RequestPacket packetReqProto, String memId) throws IOException {
		session.sendMessage(systemService.findSysWorldInterObjSetCurriculumInit(packetReqProto, memId));
	}



}
