package com.hanbit.web.record;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hanbit.web.global.Command;

@Component
@Qualifier("recordCommand") 
//default @Command 이므로 상속받은 Command와 같은
// 어노테이션이 지정되지 않도록 따로 만들어 준다
public class RecordCommand extends Command{
	
	private String id;
	private String name;
	private String examDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
}
