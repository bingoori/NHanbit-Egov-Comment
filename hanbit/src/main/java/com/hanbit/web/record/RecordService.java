package com.hanbit.web.record;

import java.util.List;

import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;

public interface RecordService {

	public int insert(GradeDTO grade);
	
	public List<RecordDTO> getList(Command command);
	
	public List<RecordDTO> getByName(Command command);
	
	public List<RecordDTO> getById(Command command);
	
	public List<RecordDTO> getByIdWithExamDate(RecordDTO record);
		
	public int count();
	
	public int update(RecordDTO record);
	
	public int delete(GradeDTO grade);

	  
}
