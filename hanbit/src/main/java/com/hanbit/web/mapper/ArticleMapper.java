package com.hanbit.web.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.board.ArticleDTO;
import com.hanbit.web.board.ReplyDTO;
import com.hanbit.web.global.Command;

@Repository
public interface ArticleMapper {
	
	public int insert(ArticleDTO article);
	
	public List<ArticleDTO> selectAll(Command command);
	
	public List<ArticleDTO> selectByName(Command command);
	
	public ArticleDTO selectById(ArticleDTO article);
	
	public ArticleDTO boardDetail(String id); 
	
	public int count();
	
	public int update(ArticleDTO article);
		
	public int delete(ArticleDTO article);
	
	public int addReplay(HashMap param);
	
	public List<ReplyDTO> getReply(String articleId);
}
