package com.hanbit.web.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.MemberMapper;



@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired SqlSession session;
	@Autowired MemberDTO member;
	
 
	@Override
	public int join(MemberDTO member) {
		logger.info("@MemberService : Join@ ");
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 경우에 따라서
		// 메시지를 전달해줘야 함
		logger.info("memberService-login() 진입 후 id 체크: {}",member.getId());
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		//MemberMapper 인터페이스를 .class 로 만들어 MemberMapper.xml로 만들어(class로 컴파일하라)
		logger.info(member.toString()+"@MemberDTO");
		member = mapper.login(member);
		
		if(member != null){
			logger.info("memberService-login() 성공 후 id = {}",member.getId());
			return member;
		}else{
			logger.info("memberService-login() 실패 후 : NULL");
			return null;
		}
		
		
	}

	@Override
	public int update(MemberDTO param) {
		// 회원 수정
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		logger.info("전달받은 입력값{}{}",param);
		logger.info(mapper.toString()+"@UpdateDTO"); 
		return mapper.update(param);
	}

	@Override
	public int remove(MemberDTO member) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		logger.info("전달받은 입력값{}",member);
		logger.info("ServiceImpl (Remove)");
		
		return mapper.delete(member.getId());
	}

	@Override
	public MemberDTO detail(String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		logger.info(mapper.toString()+" @detail@id= "+id); 
 
		return mapper.selectById(id);
	}

	@Override
	public boolean isMember(String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		logger.info(mapper.toString()+" @isMember@id= "+id); 
		MemberDTO temp = mapper.selectById(id);
		boolean result = false;
		if(temp != null){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public List<MemberDTO> getList() {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectList();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
