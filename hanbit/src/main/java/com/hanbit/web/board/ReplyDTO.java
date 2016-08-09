package com.hanbit.web.board;

public class ReplyDTO {
private int replySeq;
private int articleId;
private String reply;
private String writerName;
private String replyDate;

public String getWriterName() {
	return writerName;
}
public void setWriterName(String writerName) {
	this.writerName = writerName;
}
 
public String getReplyDate() {
	return replyDate;
}
public void setReplyDate(String replyDate) {
	this.replyDate = replyDate;
}
public int getReplySeq() {
	return replySeq;
}
public void setReplySeq(int replySeq) {
	this.replySeq = replySeq;
}
public int getArticleId() {
	return articleId;
}
public void setArticleId(int articleId) {
	this.articleId = articleId;
}
public String getReply() {
	return reply;
}
public void setReply(String reply) {
	this.reply = reply;
}

}
