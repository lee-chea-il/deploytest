package com.classlink.websocket.api.system;

import com.classlink.websocket.api.common.ResultCode;
import com.classlink.websocket.api.common.domain.proto.RequestPacketProto.RequestPacket;
import com.classlink.websocket.api.common.domain.proto.ResponsePacketProto.ResponsePacket;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldInterObjSetCreateResProto;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldInterObjSetInitResProto;
import com.classlink.websocket.api.system.domain.dto.proto.SysWorldSetInfoResProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldInterObjSetCreateReqProto;
import com.classlink.websocket.api.system.domain.param.proto.SysWorldInterObjSetInitReqProto;
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

		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot worldSlot = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot.newBuilder().setWorldSlotCode("SL001").setConnectedWorldSetCode("WS001").build();
		List<SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSlot> worldSlotList = Arrays.asList(worldSlot);
		SysWorldSetInfoResProto.SysWorldSetInfoRes.World indoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder().setWorldCode("CW001").setWorldType("01").addAllWorldSlots(worldSlotList).build();
		SysWorldSetInfoResProto.SysWorldSetInfoRes.World outdoorWorld = SysWorldSetInfoResProto.SysWorldSetInfoRes.World.newBuilder().setWorldCode("CW002").setWorldType("02").addAllWorldSlots(worldSlotList).build();
		SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet worldSet = SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet.newBuilder().setWorldSetCode("WS001").setIndoor(indoorWorld).setOutdoor(outdoorWorld).build();
		List<SysWorldSetInfoResProto.SysWorldSetInfoRes.WorldSet> worldSetList = Arrays.asList(worldSet);
		SysWorldSetInfoResProto.SysWorldSetInfoRes sysWorldSetInfoRes = SysWorldSetInfoResProto.SysWorldSetInfoRes.newBuilder().addAllWorldSets(worldSetList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldSetInfoRes.toByteString())
				.build();
		
		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSysWorldObjCreateSet(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

		SysWorldInterObjSetCreateReqProto.SysWorldInterObjSetCreateReq sysWorldInterObjSetCreateReq = SysWorldInterObjSetCreateReqProto.SysWorldInterObjSetCreateReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldInterObjSetCreateResProto.SysWorldInterObjSetCreateRes.InteractionObject interactionObject = SysWorldInterObjSetCreateResProto.SysWorldInterObjSetCreateRes.InteractionObject.newBuilder()
				.setInteractionObjectCode("OB0001")
				.setIdxType("ID")
				.setIdx(1)
				.setDataType("01")
				.setData("/video/education.mp4")
				.build();

		List<SysWorldInterObjSetCreateResProto.SysWorldInterObjSetCreateRes.InteractionObject> interactionObjectList = Arrays.asList(interactionObject);

		SysWorldInterObjSetCreateResProto.SysWorldInterObjSetCreateRes sysWorldInterObjSetCreateRes = SysWorldInterObjSetCreateResProto.SysWorldInterObjSetCreateRes.newBuilder().addAllInteractionObjectList(interactionObjectList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldInterObjSetCreateRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}

	public BinaryMessage findSysWorldObjSetInit(RequestPacket packetReqProto, String memId) throws InvalidProtocolBufferException {

		SysWorldInterObjSetInitReqProto.SysWorldInterObjSetInitReq sysWorldInterObjSetInitReq = SysWorldInterObjSetInitReqProto.SysWorldInterObjSetInitReq.newBuilder().mergeFrom(packetReqProto.getData()).build();

		SysWorldInterObjSetInitResProto.SysWorldInterObjSetInitRes.InteractionObject interactionObject = SysWorldInterObjSetInitResProto.SysWorldInterObjSetInitRes.InteractionObject.newBuilder()
				.setInteractionObjectCode("OB0001")
				.setIdxType("ID")
				.setIdx(1)
				.setDataType("01")
				.setData("/video/education.mp4")
				.build();

		List<SysWorldInterObjSetInitResProto.SysWorldInterObjSetInitRes.InteractionObject> interactionObjectList = Arrays.asList(interactionObject);

		SysWorldInterObjSetInitResProto.SysWorldInterObjSetInitRes sysWorldInterObjSetInitRes = SysWorldInterObjSetInitResProto.SysWorldInterObjSetInitRes.newBuilder().addAllInteractionObjectList(interactionObjectList).build();

		ResponsePacket packetResProto = ResponsePacket.newBuilder().setOpCode(packetReqProto.getOpCode())
				.setAccessToken(packetReqProto.getAccessToken()).setInstanceId(packetReqProto.getInstanceId())
				.setResultCode(ResultCode.SUCCESS.getCode())
				.setResultMessage(ResultCode.SUCCESS.getMessage())
				.setData(sysWorldInterObjSetInitRes.toByteString())
				.build();

		return new BinaryMessage(packetResProto.toByteArray());
	}
}
