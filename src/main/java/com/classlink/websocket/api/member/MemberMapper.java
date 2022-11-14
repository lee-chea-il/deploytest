package com.classlink.websocket.api.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.classlink.websocket.api.member.domain.param.MemberParam.MemberIdentityParam;
import com.classlink.websocket.api.member.domain.vo.MemberVo;

@Mapper
public interface MemberMapper {
	
	List<MemberVo.IdentityVo> selectMemberIdentityByMemberIdx(@Param("mem_id") String mem_id);

	void insertMemberIdentity(MemberIdentityParam memberIdentityParam);
}
