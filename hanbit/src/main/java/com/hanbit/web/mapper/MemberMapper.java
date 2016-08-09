package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.member.MemberDTO;


@Repository
public interface MemberMapper {

	public int insert(MemberDTO member);

	public MemberDTO selectById(String id);

	public MemberDTO login(MemberDTO member);

	public int update(MemberDTO param);

	public int delete(String id);
	
	public boolean isMember(String id,String password);
	
	public List<MemberDTO> selectList();
	
	public int count();
}
