package com.hanbit.web.admin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@SessionAttributes("admin")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService memberService;
	
	
	@RequestMapping("/join")
	public String join(){
		logger.info("=== Admin join form ===");		
		return "admin/join_form";
	}	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@RequestParam("id")String id,@RequestParam("password")String password,@RequestParam("name")String name,@RequestParam("addr")String addr,@RequestParam("birth")int birth,
			@RequestParam("cate")int cate){
		logger.info("=== Member-Join() ===");
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setAddr(addr);
		member.setBirth(birth);
		member.setCate(cate);
		String view ="";
		if(memberService.join(member) == 1){
			view= "admin/admin_login_form";
		}else
		{
			view= "admin/join_form";
		}
		return view;
	}
	
	
	@RequestMapping("/login")
	public String login() {
		logger.info("Admin-Form 으로 이동");
		return "admin/login.admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session,
			Model model) { // @RequestParam("id") 는 String id =
							// request.getParameter("id");
		logger.info("관리자 로그인 컨트롤러 파라미터 ID : {}", id);
		logger.info("관리자 로그인 컨트롤러 파라미터 PW : {}", password);
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		member = memberService.login(param);
		logger.info(member.toString() + "@AdminController");
		String view = "";

		if (member != null) {
			logger.info("로그인 성공");
			session.setAttribute("admin", member);
			view = "auth/admin/content.admin";
		} else {
			logger.info("로그인 실패");
			view = "admin/login.admin";
		}
		return view;
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		logger.info("Admin-Form 으로 이동");
		status.setComplete();
		return "redirect:/admin/login.admin";
	}
	
	@RequestMapping("/member/profile/{id}")
	public @ResponseBody MemberDTO getMemberProfile(
			@PathVariable("id")String id){
		logger.info("=== member-getMemberProfile() ===");
		return memberService.detail(id);
	}
}
