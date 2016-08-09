package com.hanbit.web.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.web.global.Command;

public interface ArticleService {

	public int write(ArticleDTO article);
	
	public List<ArticleDTO> getList(Command command);
	
	public List<ArticleDTO> getByName(Command command);
	
	public ArticleDTO getById(ArticleDTO article);
	
	public ArticleDTO getboardDetail(String id);
	
	public int count();
	
	public int update(ArticleDTO article);
	
	public int delete(ArticleDTO article);
	
	public int reply(HashMap param);
	
	public List<ReplyDTO> getReply(String articleId);
	
}
