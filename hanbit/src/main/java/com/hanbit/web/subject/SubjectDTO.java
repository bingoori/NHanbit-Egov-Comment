package com.hanbit.web.subject;

import org.springframework.stereotype.Component;

@Component
public class SubjectDTO {
 private int subjSeq;
 private String subjName,profId,profName;
public String getProfId() {
	return profId;
}
public void setProfId(String profId) {
	this.profId = profId;
}
public String getProfName() {
	return profName;
}
public void setProfName(String profName) {
	this.profName = profName;
}
public int getSubjSeq() {
	return subjSeq;
}
public void setSubjSeq(int subjSeq) {
	this.subjSeq = subjSeq;
}
public String getSubjName() {
	return subjName;
}
public void setSubjName(String subjName) {
	this.subjName = subjName;
}

}
