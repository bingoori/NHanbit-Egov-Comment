package com.hanbit.web.member;

import java.util.List;

public interface MemberService {
	
	public final static String NAME = "홍길동";

	public int join(MemberDTO member);

	public MemberDTO login(MemberDTO member);

	public MemberDTO detail(String id);

	public int update(MemberDTO param);

	public int remove(MemberDTO member);
	
	public boolean isMember(String id);
	public List<MemberDTO> getList();
	public int count();
}
