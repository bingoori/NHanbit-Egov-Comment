package com.hanbit.web.board;

import org.springframework.stereotype.Component;

@Component
public class ArticleDTO {
	private int articleId, groupId, readCount;
	private String sequenceNo, writerName, password, title, content,postingDate;
	 

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	
	public int getGroupId() {
		return groupId;
	}
	
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

 

	@Override
	public String toString() {
		return "ArticleDTO [articleId=" + articleId + ", groupId=" + groupId + ", readCount=" + readCount
				+ ", sequenceNo=" + sequenceNo + ", writerName=" + writerName + ", password=" + password + ", title="
				+ title + ", content=" + content + ", postingDate=" + postingDate + "]";
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	//sequenceNo 를 이용해서 게시글의
	// 중첩 레벨을 구한다
	public int getLevel(){
		if(sequenceNo == null){
			return -1;
		}
		if(sequenceNo.length() != 16){
			return -1;
		}
		if(sequenceNo .endsWith("999999")){
			return 0;
		}
		if(sequenceNo.endsWith("9999")){
			return 1;
		}
		if(sequenceNo.endsWith("99")){
			return 2;
		}
		return 3;
	}

}
