package com.hanbit.web.board;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.global.Command;
import com.hanbit.web.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	ArticleDTO article;
	@Autowired
	ArticleService service;
 
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public void write(@RequestParam("title") String title, @RequestParam("writerName") String writerName,
			@RequestParam("password") String password, @RequestParam("content") String content) {
		logger.info("=== ArticleController Writer ===");

		logger.info(" title = {}", title);
		logger.info(" writerName = {}", writerName);
		logger.info(" password = {}", password);
		logger.info(" content = {}", content);
		article.setContent(content);
		article.setTitle(title);
		article.setPassword(password);
		article.setWriterName(writerName);
		service.write(article);
	}

	@RequestMapping("/list")
	public Model list(@RequestParam(value = "pageNO", defaultValue = "1") String pageNO,
			@RequestParam(value = "keyField", defaultValue = "none") String keyField,
			@RequestParam(value = "keyWord", defaultValue = "none") String keyWord, Model model) {
		Command command = CommandFactory.createCommand("article", "list", pageNO, keyField, keyWord, service.count());
		logger.info("현재 keyField = {}", keyField);
		logger.info("현재 keyWord = {}", keyWord);

		logger.info("현재 페이지 = {}", command.getPageNO());
		logger.info("현재 startPage = {}", command.getStartPage());
		logger.info("현재 endPage = {}", command.getEndPage());
		logger.info("현재 startRow = {}", command.getStartRow());
		logger.info("현재 endRow = {}", command.getEndRow());
	 
		if (keyField.equals("none")) {
			model.addAttribute("list", service.getList(command));
			logger.info("None{}", command);
		} else {
			model.addAttribute("list", service.getByName(command));
			logger.info("unNone{}", command);
		}
		
		model.addAttribute("command", command);
		return model;
/*
		return "board/list.user";*/
	}

	@RequestMapping("/list/{pageNO}")
	public Model listwithPage(@PathVariable(value = "pageNO") String pageNO,Model model) {
		Command command = CommandFactory.createCommand("article", "list", pageNO, "none", "none", service.count());
	

		logger.info("==== listwithPage ====", command.getPageNO());		
		logger.info("현재 페이지 = {}", command.getPageNO());		
		logger.info("현재 startPage = {}", command.getStartPage());
		logger.info("현재 endPage = {}", command.getEndPage());
		logger.info("현재 startRow = {}", command.getStartRow());
		logger.info("현재 endRow = {}", command.getEndRow());
		
		
		model.addAttribute("command", command);
		model.addAttribute("list", service.getList(command));
		return model;
/*
		return "board/list.user";*/
	}
	@RequestMapping("/detail/{id}")
	public void findById(@PathVariable("id") String id, Model model) {
		logger.info("==== /search/{id} <> findById ====");
		logger.info("==== /search/{id} <> findById @@ {} ====",id);
		
		/*
		logger.info("{}",param.get("reply"));
		logger.info("{}",param.get("articleId"));*/
		
		ArticleDTO article = service.getboardDetail(id);
		List<ReplyDTO> replyList = service.getReply(id);
		model.addAttribute("comment", replyList);
		model.addAttribute("info", article);
	}


	@RequestMapping("/count")
	public String count() {
		return "";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(
			@RequestParam("articleId")int articleId,
			@RequestParam("title")String title,
			@RequestParam("writerName")String writerName,
			@RequestParam("password")String password,
			@RequestParam("content")String content,
			Model model){
		logger.info("=== update() ===");
		logger.info("update() content에 넘어온 컨텐츠 : {}",content);
		logger.info("update() writerName에 넘어온 컨텐츠 : {}",writerName);
		logger.info("update() title에 넘어온 컨텐츠 : {}",title);
		logger.info("update() password에 넘어온 컨텐츠 : {}",password);
		logger.info("update() articleId에 넘어온 컨텐츠 : {}",articleId);
		
		article.setArticleId(articleId);
		article.setContent(content);
		article.setPassword(password);
		article.setTitle(title);
		article.setWriterName(writerName);
		service.update(article);
		logger.info("수정된 결과 {}",service.getById(article).getContent());
		model.addAttribute("id", articleId);
	
	}

	@RequestMapping("/delete")
	public void delete(
			@RequestParam("articleId")int articleId,Model model){
		logger.info(" === delete () ==="); 
		logger.info(" === delete () === {} ====",articleId); 
		article.setArticleId(articleId);
		int result = service.delete(article);
		if (result == 1) {
			model.addAttribute("message","삭제 성공 !!");
		} else {
			model.addAttribute("message","삭제 실패 !!");
		}
	}
	
	@RequestMapping(value="/reply",method=RequestMethod.POST)
	public void reply(@RequestParam("articleId")int articleId,@RequestParam("reply")String reply, Model model){
		HashMap<String,Object> param = new HashMap<String,Object>();
		logger.info(" === reply () ===");
		logger.info(" === {} ===", articleId);
		logger.info(" === {} ===", reply);
		param.put("reply",reply);
		param.put("articleId",articleId);
		
		
		logger.info("{}",param.get("reply"));
		logger.info("{}",param.get("articleId"));
		
		if(service.getReply(Integer.toString(articleId)).get(0).getReplyDate().length() != 0){
			model.addAttribute("comment", service.getReply(Integer.toString(articleId)).get(0).getReplyDate());
		}else{
			model.addAttribute("comment", null);
		}
		
		service.reply(param);
		model.addAttribute("reply", reply);
		//return "redirect:/article/search/"+articleId;
	}
}