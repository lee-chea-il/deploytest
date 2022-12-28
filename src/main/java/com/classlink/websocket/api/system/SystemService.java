package com.classlink.websocket.api.system;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldInterObjSetCurriculumCreateResProto;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldInterObjSetCurriculumInitResProto;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldInterObjSetPackageCreateResProto;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldSetInfoResProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldInterObjSetCurriculumCreateReqProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldInterObjSetCurriculumInitReqProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldInterObjSetPackageCreateReqProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldSetInfoReqProto;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.BinaryMessage;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemService {
	
	private final SystemMapper systemMapper;

	public BinaryMessage findSysWorldSetInfo(RequestPacket packetReqProto, String userId) throws InvalidProtocolBufferException {

		SysWorldSetInfoReqProto.SysWorldSetInfoReq sysWorldSetInfoReq = SysWorldSetInfoReqProto.SysWorldSetInfoReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot SwWorldSlot = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot.newBuilder()
				.setCode("7f398633-d4aa-4f02-a5e1-86c412c43cc1")
				.setConnectedWorldSetIdx(2)
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot CwWorldSlot = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot.newBuilder().build();

		List<SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot> SwWorldSlotList = Arrays.asList(SwWorldSlot);

		SysWorldSetInfoResProto.SysWorldSetInfoRes.World SwIndoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder()
				.setIdx(100)
				.setCode("335ea4f2-39ad-422f-a933-97a9662a1bba")
				.setWorldType("SW")
				.addAllWorldSlotList(SwWorldSlotList)
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.World SwOutdoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder()
				.setIdx(0)
				.setCode("")
				.setWorldType("SW")
				.addAllWorldSlotList(Arrays.asList())
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.World CwIndoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder()
				.setIdx(200)
				.setCode("2ab6536b-101c-441d-bfb5-15d811008b3d")
				.setWorldType("CW")
				.addAllWorldSlotList(Arrays.asList())
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.World CwOutdoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder()
				.setIdx(201)
				.setCode("131ad4c2-5c17-401d-9d3e-70312a60bab5")
				.setWorldType("CW")
				.addAllWorldSlotList(Arrays.asList())
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet CwWorldSet = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet.newBuilder()
				.setIdx(2)
				.setCode("2")
				.setIndoor(CwIndoorWorld)
				.setOutdoor(CwOutdoorWorld)
				.build();

		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet SwWorldSet = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet.newBuilder()
				.setIdx(1)
				.setCode("1")
				.setIndoor(SwIndoorWorld)
				.setOutdoor(SwOutdoorWorld)
				.build();

		List<SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet> worldSetList = Arrays.asList(SwWorldSet, CwWorldSet);
		SysWorldSetInfoResProto.SysWorldSetInfoRes sysWorldSetInfoRes = SysWorldSetInfoResProto.SysWorldSetInfoRes.newBuilder().addAllWorldSetList(worldSetList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldSetInfoRes.toByteString())
				.build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSysWorldInterObjSetPackageCreate(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

		SysWorldInterObjSetPackageCreateReqProto.SysWorldInterObjSetPackageCreateReq sysWorldInterObjSetCreateReq = SysWorldInterObjSetPackageCreateReqProto.SysWorldInterObjSetPackageCreateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldInterObjSetPackageCreateResProto.SysWorldInterObjSetPackageCreateRes.InteractionObject interactionObject = SysWorldInterObjSetPackageCreateResProto.SysWorldInterObjSetPackageCreateRes.InteractionObject.newBuilder()
				.setIdx(1)
				.setCode("50bb2114-4625-49bd-8973-3974498bcc78")
				.setDataTableType("ID")
				.setDataIdx(1)
				.setDataType("01")
				.setData("http://112.171.101.31:45290/file/27bd594f-4ff6-4307-b9f8-d72733ef142a.mp4")
				.build();

		List<SysWorldInterObjSetPackageCreateResProto.SysWorldInterObjSetPackageCreateRes.InteractionObject> interactionObjectList = Arrays.asList(interactionObject);

		SysWorldInterObjSetPackageCreateResProto.SysWorldInterObjSetPackageCreateRes sysWorldInterObjSetCreateRes = SysWorldInterObjSetPackageCreateResProto.SysWorldInterObjSetPackageCreateRes.newBuilder().addAllInteractionObjectList(interactionObjectList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldInterObjSetCreateRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSysWorldInterObjSetCurriculumCreate(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

		SysWorldInterObjSetCurriculumCreateReqProto.SysWorldInterObjSetCurriculumCreateReq sysWorldInterObjSetCurriculumCreateReq = SysWorldInterObjSetCurriculumCreateReqProto.SysWorldInterObjSetCurriculumCreateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldInterObjSetCurriculumCreateResProto.SysWorldInterObjSetCurriculumCreateRes.InteractionObject interactionObject = SysWorldInterObjSetCurriculumCreateResProto.SysWorldInterObjSetCurriculumCreateRes.InteractionObject.newBuilder()
				.setIdx(2)
				.setCode("5ab3978a-6e23-42b5-ab03-dead1ea4d683")
				.build();

		List<SysWorldInterObjSetCurriculumCreateResProto.SysWorldInterObjSetCurriculumCreateRes.InteractionObject> interactionObjectList = Arrays.asList(interactionObject);

		SysWorldInterObjSetCurriculumCreateResProto.SysWorldInterObjSetCurriculumCreateRes sysWorldInterObjSetCreateRes = SysWorldInterObjSetCurriculumCreateResProto.SysWorldInterObjSetCurriculumCreateRes.newBuilder().addAllInteractionObjectList(interactionObjectList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldInterObjSetCreateRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSysWorldInterObjSetCurriculumInit(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

		SysWorldInterObjSetCurriculumInitReqProto.SysWorldInterObjSetCurriculumInitReq sysWorldInterObjSetCurriculumInitReq = SysWorldInterObjSetCurriculumInitReqProto.SysWorldInterObjSetCurriculumInitReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldInterObjSetCurriculumInitResProto.SysWorldInterObjSetCurriculumInitRes.InteractionObject interactionObject = SysWorldInterObjSetCurriculumInitResProto.SysWorldInterObjSetCurriculumInitRes.InteractionObject.newBuilder()
				.setIdx(3)
				.setCode("48a2d7b2-0d9c-499a-92a8-55a0fd2fca3e")
				.setDataTableType("ID")
				.setDataType("02")
				.setData("http://112.171.101.31:45290/file/6b2d2026-3c45-47c3-9ab3-9b2ca44313ae.pdf")
				.build();

		List<SysWorldInterObjSetCurriculumInitResProto.SysWorldInterObjSetCurriculumInitRes.InteractionObject> interactionObjectList = Arrays.asList(interactionObject);

		SysWorldInterObjSetCurriculumInitResProto.SysWorldInterObjSetCurriculumInitRes sysWorldInterObjSetInitRes = SysWorldInterObjSetCurriculumInitResProto.SysWorldInterObjSetCurriculumInitRes.newBuilder().addAllInteractionObjectList(interactionObjectList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldInterObjSetInitRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}
}
