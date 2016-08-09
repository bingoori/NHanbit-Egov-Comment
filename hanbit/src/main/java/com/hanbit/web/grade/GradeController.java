package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.mapper.MemberMapper;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
@Autowired GradeService service;
@Autowired GradeDTO grade;

	@RequestMapping("/{id}/score")
	public String add(@PathVariable("id") String id, Model model) {
		logger.info("grade-add(GET)");
		logger.info("grade-add(GET) 의 아이디 {}",id);
		model.addAttribute("id",id);
		return "grade/grade_add";
	}

	@RequestMapping(value ="/{id}/score", method = RequestMethod.POST)
	public String add(@PathVariable("id") String id,@RequestParam("java")int java,@RequestParam("jsp")int jsp,@RequestParam("sql")int sql,@RequestParam("spring")int spring) {
		logger.info("grade-add(POST)"); 
		logger.info("grade-add(POST) 의 아이디{}",id); 
		grade.setId(id);
		logger.info("Grade Update Info === grade.toString()>>{}",grade.toString());
		int result =service.input(grade);
		return "grade/myGrade";
	}

}
