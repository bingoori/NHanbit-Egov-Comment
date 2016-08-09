package com.hanbit.web.global;

import org.springframework.stereotype.Component;

/**
 * URL => http://localhost:9090/school/member/login.do Context Path :
 * http://localhost:9090/school WebContent : / URI(Get 방식) :
 * member/login_form.do?id=hong&password=1 URI(Post 방식) : member/login.do 쿼리스트링
 * 구분자 : ? 파라미터 구분자 : & 쿼리스트링 : id=hong&password=1
 * 
 * URI 는 프로젝트 내부에서 유일한 값(ID) 이어야 하며, 이 URI를 분해해서 서블릿에게 명령을 내리는 구조로 이뤄진다.
 */
@Component
public class Command {
	private int pageSize,groupSize,pageNO,startPage,endPage,startRow,endRow,totalPages,count;
		
		
	private String pkg,command,keyField,keyWord,view;
	public Command() {}
	public Command(String pkg,String command, String strPageNO,
			String keyField,String keyWord, int count) {
		this.pageSize = Constants.PAGESIZE;
		//pageSize 는 고정 10
		this.groupSize = Constants.GROUPSIZE;
		// groupSize 는 고정 5
		this.pkg = pkg;
		this.command = command;
		this.pageNO = Integer.parseInt(strPageNO);
		this.keyField = keyField;
		this.keyWord = keyWord;
		int nmg = count%pageSize;
		//count 는 총 등록된 글의 개수
		if (nmg  != 0) {
			totalPages = (count/pageSize)+1;
		} else {
			totalPages = count/pageSize;
		}
		this.startRow = (pageNO - 1 )*pageSize;
		this.endRow = pageNO * pageSize;
		this.startPage = pageNO - ((pageNO-1)%groupSize);
		int end = startPage + groupSize - 1;
		if (end > totalPages) {
			end = totalPages;
		}
		this.endPage = end;
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public int getPageNO() {
		return pageNO;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public String getPkg() {
		return pkg;
	}
	public String getCommand() {
		return command;
	}
	public String getKeyField() {
		return keyField;
	}
 
	public String getView() {
		return view;
	}
	public int getCount() {
		return count;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
 
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return "Command [pageSize=" + pageSize + ", groupSize=" + groupSize + ", pageNO=" + pageNO + ", startPage="
				+ startPage + ", endPage=" + endPage + ", startRow=" + startRow + ", endRow=" + endRow + ", totalPages="
				+ totalPages + ", count=" + count + ", pkg=" + pkg + ", command=" + command + ", keyField=" + keyField
				+ ", keyWord=" + keyWord + ", view=" + view + "]";
	}
	

}