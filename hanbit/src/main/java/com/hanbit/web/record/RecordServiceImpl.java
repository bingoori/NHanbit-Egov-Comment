package com.hanbit.web.record;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.board.ArticleController;
import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.mapper.RecordMapper;


@Service
public class RecordServiceImpl implements RecordService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired SqlSession session;
	@Autowired RecordDTO record;
	@Autowired GradeDTO grade;
	
	@Override
	public int insert(GradeDTO grade) {
		logger.info("=== RecordServiceImpl insert()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.input(grade);
		 
	}

	@Override
	public List<RecordDTO> getList(Command command) {
		logger.info("=== RecordServiceImpl getList()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectList(command);
	}

	@Override
	public List<RecordDTO> getByName(Command command) {
		logger.info("=== RecordServiceImpl getByName()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectByName(command);
	}

	@Override
	public List<RecordDTO> getById(Command command) {
		logger.info("=== RecordServiceImpl getById()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectById(command);
	}
	@Override
	public List<RecordDTO> getByIdWithExamDate(RecordDTO record) {
		logger.info("=== RecordServiceImpl getByIdWithExamDate()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectByIdWithExamDate(record);
	}
	@Override
	public int count() {
		logger.info("=== RecordServiceImpl count()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.count();
	}

	@Override
	public int update(RecordDTO record) {
		logger.info("=== RecordServiceImpl update()===");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.update(record);
	}

	@Override
	public int delete(GradeDTO grade) {
		logger.info("=== RecordServiceImpl delete()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.delete(grade);
	}



}
