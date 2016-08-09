package com.hanbit.web.subject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.SubjectMapper;

@Service
public class SubjectServiceImpl implements SubjectService{
	private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);
	@Autowired SqlSession session;
	
	
	@Override
	public List<SubjectDTO> selectAll() {
		logger.info("=== SubjectServiceImpl : selectAll() === ");
		
		SubjectMapper mapper = session.getMapper(SubjectMapper.class);
		return mapper.selectAll();
	}
}
