package com.hanbit.web.grade;

import org.springframework.stereotype.Component;

/**
 *@package : grade
 *@file : GradeBean.java
 *@author sdwoo90@gmail.com
 *@date 2016. 3. 14.
 *@story
 */
@Component
public class GradeDTO {
	private String id,examDate;
	private int subject,score,scoreSeq;
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
	public int getSubject() {
		return subject;
	}
	public void setSubject(int subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScoreSeq() {
		return scoreSeq;
	}
	public void setScoreSeq(int scoreSeq) {
		this.scoreSeq = scoreSeq;
	}
 
  
}
