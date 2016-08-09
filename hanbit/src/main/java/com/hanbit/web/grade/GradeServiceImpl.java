package com.hanbit.web.grade;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.GradeMapper;


@Service
public class GradeServiceImpl implements GradeService {

	private static final Logger logger = LoggerFactory.getLogger(GradeServiceImpl.class);
 
 
	@Autowired SqlSession session;
	@Autowired GradeDTO grade;
 


	@Override 
	public List<GradeDTO> getList() {
		 logger.info("gradeService : input() 진입 후 아이디 = {}",grade.getId());
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
		/*return mapper.selectGradeAll();*/
		 return null;

	}

	@Override
	public GradeDTO getGradeByHak(int hak) {
		 logger.info("gradeService : getGradeByHak() 진입");
		 GradeMapper mapper = session.getMapper(GradeMapper.class);
		return null;

	}

	@Override
	public List<GradeDTO> getGradesByName(String name) {
		
		 logger.info("gradeService : getGradesByName() 진입");
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
		return null;
	}

	@Override
	public int update(int hak, int java, int jsp, int sql, int spring) {
		// 성적표 수정 U
		logger.info("gradeService : update() 진입 후 아이디 = {}",grade.getId());
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
 
		return 0;
	}

	@Override
	public int delete(String id) {
		logger.info("gradeService : delete() 진입 " );
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
		return 0;
	}

	@Override
	public int getCount() {
		logger.info("gradeService : getCount() 진입 " );
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
	
		return 0;

	}

	@Override
	public GradeDTO getGradeById(String id) {
		logger.info("gradeService : getGradeById() 진입 " );
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
	
		return null;
		
	}

	@Override
	public List<GradeDTO> selectGradeAll() {
		logger.info("gradeService : selectGradeAll() 진입 " );
		// GradeMapper mapper = session.getMapper(GradeMapper.class);
	
		return null;
	}

	@Override
	public int input(GradeDTO grade) {
		logger.info("gradeService : input() 진입");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.input(grade);
	}

}
