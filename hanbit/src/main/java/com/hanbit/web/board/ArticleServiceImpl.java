package com.hanbit.web.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired SqlSession session;
	@Override
	public int write(ArticleDTO article) {
		logger.info("=== articleService : write() === ");
		logger.info(" id = {}");
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.insert(article);
	}

	@Override
	public List<ArticleDTO> getList(Command command) {
		 logger.info("=== articleService : getList() === ");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			logger.info("ArticleServiceImpl 페이지 = {}",command.getPageNO());
			logger.info("ArticleServiceImpl startPage = {}",command.getStartPage());
			logger.info("ArticleServiceImpl endPage = {}",command.getEndPage());
			logger.info("ArticleServiceImpl startRow = {}",command.getStartRow());
			logger.info("ArticleServiceImpl endRow = {}",command.getEndRow());
		 return mapper.selectAll(command);
	}

	@Override
	public List<ArticleDTO> getByName(Command command) {
		 logger.info("=== articleService : getByName() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.selectByName(command);
	}

	@Override
	public ArticleDTO getById(ArticleDTO article) {
		 logger.info("=== articleService : getById() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);		
		 return  mapper.selectById(article);
	}

	@Override
	public int count() {
		 logger.info("=== articleService : count() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.count();
	}

	@Override
	public int update(ArticleDTO article) {
		 logger.info("=== articleService : update() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.update(article);
	}

	@Override
	public int delete(ArticleDTO article) {
		 logger.info("=== articleService : delete() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.delete(article);
	}

	@Override
	public ArticleDTO getboardDetail(String id) {
		logger.info("=== articleService : detail() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.boardDetail(id);
	}

	@Override
	public int reply(HashMap param) { 
		logger.info("=== articleService : reply() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.addReplay(param);
	}

	@Override
	public List<ReplyDTO> getReply(String articleId) {
		logger.info("=== articleService : getReply() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.getReply(articleId);
	}
}
