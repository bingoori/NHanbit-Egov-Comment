package com.hanbit.web.record;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.*;

import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.mapper.RecordMapper;
import com.hanbit.web.member.MemberController;
import com.hanbit.web.util.ExamDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml")
public class RecordServiceImplTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private RecordDTO record;
	
	@Autowired
	private GradeDTO grade;
	
	@Autowired
	private Command command;
	@Autowired
	SqlSession session;
	@Autowired
	RecordCommand recordCommand;
   
 
	public final void testInsert() {
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		//grade.setExamDate(examDate);
		grade.setExamDate(ExamDate.getEndOfMonth());
		grade.setId("song");
		grade.setScore(81);
		grade.setSubject(3);
		int check = mapper.input(grade);
		assertThat(check, is(not(0)));
	}

	public final void testGetList() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		list = mapper.selectList(command);
		assertThat(list.size(), is(not(0)));
	}

	public final void testGetByName() {

		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		recordCommand.setName("우길동");
		recordCommand.setExamDate("2016-03-31");
		list = mapper.selectByName(recordCommand);
		assertThat(list.size(), is(not(0)));
	}

	public final void testGetById() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		recordCommand.setId("woo");
		recordCommand.setExamDate("2016-03-31");
		/*
		 * command.setId("hong"); command.setPassword("1");
		 */
		list = mapper.selectById(recordCommand);
		assertThat(list.size(), is(not(0)));
	}

	public final void testGetByIdWithExamDate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		record.setId("woo");
		record.setExamDate("2016-03-31");
		list = mapper.selectByIdWithExamDate(record);
		assertThat(list.get(0).getId(), is(equalTo("woo")));
	}

	public final void testCount() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int check = mapper.count();
		assertThat(check, is(not(0)));
	}


	public final void testUpdate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		record.setId("woo");
		record.setExamDate("2016-03-31");
		record.setSubject("java");
		record.setScore(80);
		int check = mapper.update(record);
		assertThat(check, is(not(0)));
	}
	
	@Test
	public final void testDelete() {
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		grade.setScoreSeq(31);
		int check = mapper.delete(grade);
		assertThat(check, is(not(0)));
	}

}
