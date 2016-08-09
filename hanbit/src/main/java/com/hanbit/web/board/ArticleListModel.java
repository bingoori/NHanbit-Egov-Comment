package com.hanbit.web.board;

import java.util.Collections;
import java.util.List;


/**
 * @package com.hanbit.web.board
 * @file ArticleListModel.java
 * @author sdwoo90@gmail.com
 * @Date : 2016. 4. 11.
 * @Story : 게시글 목록(페이징처리기능)
 */
public class ArticleListModel {
	/**
	 * articleList - 화면에 보여줄 게시글 목록
	 * requestPage - 사용자가 요청한 페이지 번호
	 * totalPageCount - 전체 페이지 개수
	 * startRow - 현재 게시글 목록의 시작 행(전체 게시글 기준)
	 * endRow - 현재 게시글 목록의 끝 행(전체 게시글 기준)
	 * */
	
	private List<ArticleDTO> articleList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;
	private int endRow;
	private boolean rowCheck;
	public ArticleListModel() {
		this(Collections.<ArticleDTO>emptyList(), 0, 0, 0, 0,false);
	}

	public ArticleListModel(List<ArticleDTO> articleList, int requestPage, int totalPageCount, int startRow, int endRow,boolean rowCheck) {
		this.articleList = articleList;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
		this.rowCheck = !articleList.isEmpty();
	}

	public List<ArticleDTO> getArticleList() {
		return articleList;
	}
	
	public boolean isHasArticle(){
		this.rowCheck = !articleList.isEmpty();
		return rowCheck;
		
	}
	public int getRequestPage() {
		return requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}



}
