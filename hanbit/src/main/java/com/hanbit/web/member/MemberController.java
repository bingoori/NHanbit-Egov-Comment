package com.hanbit.web.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


import com.hanbit.web.global.Constants;
import com.hanbit.web.util.FileUpload;
 

@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberDTO member; // MemberDTO 메모리를 잡아먹지 않는다, new 와 다른 방식
	@Autowired
	MemberService memberService; 

	@RequestMapping("/login")
	public String login() {
		return "member/login.user";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session,
			Model model) { // @RequestParam("id") 는 String id =
							// request.getParameter("id");
		logger.info("로그인 컨트롤러 파라미터 ID : {}", id);
		logger.info("로그인 컨트롤러 파라미터 PW : {}", password);
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		member = memberService.login(param);
		logger.info(member.toString() + "@MemberController");
		String view = "";

		if (member != null) {
			logger.info("로그인 성공");
			// 복수의 세션값 저장시 사용
			model.addAttribute("user", member);
			//세션 값 삭제 시 아래 메소드 사용
			// 현재 model 현재의 객체만 status.setComplete();
			/* === [비고] ===
			 * 단수의 세션값 저장시 사용
			 * session.setAttribute("user",member);
			 * 세션값 삭제 시 아래 메소드 사용
			 * session.invalidate();
			 * */
			//session.setAttribute("user", member);
			//model.addAttribute("member", member);
			view = "redirect:/member/content/"+id;
		} else {
			logger.info("로그인 실패");
			view = "member/login_form";
		}
		return view;
	}

	@RequestMapping("/update")
	public String update(HttpSession session,Model model,@RequestParam("id")String id) {
		logger.info("Update(수정) 페이지 이동 ",id);
		logger.info("----Update(수정) {}---",session.getAttribute("user").toString());
		model.addAttribute("member", session.getAttribute("user"));
		return "auth/member/update.user";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody MemberDTO update(
			@RequestParam("password")String password,
			@RequestParam("addr") String addr,
			@RequestParam(value="file",required=false)MultipartFile file,
			HttpSession session,
			Model model) {
		logger.info("Update(수정) 하는 경우 전달받은 값{}{}",password,addr);
		String view ="";
		MemberDTO newSession = (MemberDTO) session.getAttribute("user");
		MemberDTO oldSession = (MemberDTO) session.getAttribute("user");
		FileUpload fileUpload = new FileUpload();
		String fileName = file.getOriginalFilename();
		logger.info(" === fileName ==={}",fileName);
		 
		String fullPath = fileUpload.uploadFile(file, Constants.IMAGE_PROFILE, fileName);
		logger.info(" === UploadfilePath ==={}",fullPath);
		logger.info(" === newSession ==={}",newSession.getId());
		
		newSession.setProfileImg(fileName);
		newSession.setPassword(password);
		newSession.setAddr(addr);
		int result =memberService.update(newSession);
		if(result == 1){
			logger.info("수정 업데이트 완료");
			session.setAttribute("user", newSession);
			model.addAttribute("member", newSession);
			view = "auth/member/detail.user";
		}else{
			logger.info("수정 업데이트 실패");
			session.setAttribute("user", oldSession);
			view = "auth/member/update.user";
		}
		logger.info("수정 후 비번 : {}",newSession.getProfileImg());
		return newSession;

	}
	@RequestMapping("/join")
	public String join(){
		logger.info("회원가입  이동");
		return "member/join_form";
	}	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public @ResponseBody MemberDTO join(@RequestBody MemberDTO param){
		member.setId(param.getId());
		logger.info("=== password {} ===",param.getPassword());
		
		member.setPassword(param.getPassword());
		member.setName(param.getName());
		member.setAddr(param.getAddr());
		member.setBirth(param.getBirth());
		member.setCate(param.getCate());
		memberService.join(member);
		return member;
	}

	@RequestMapping("/list")
	public @ResponseBody Model list(Model model){
		logger.info("==== Member-list() ====");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list = memberService.getList();
 
		model.addAttribute("list", list);
		return model;
	}
	
	@RequestMapping("/name/{name}")
	public String getMembersByName(@PathVariable("name")String name){
		return "member/login_form";
	}
	@RequestMapping("/content/{id}")
	public String getMemberContent(@PathVariable("id")String id,Model model){
		logger.info("member == getMemberContent()");
		if(memberService.isMember(id)){
			member = memberService.detail(id);
			member.setRole(User.valueOf(member.getCate()).toString());		
			model.addAttribute("member",member);
			logger.info(" 파일 업로드 전 파일 경로 {}",member.getProfileImg());	
		}else{
			model.addAttribute("member","");
		}
		logger.info(" 파일 업로드 후 파일 경로 {}",member.getProfileImg());
		
		return "auth/member/content.user";
	}
	@RequestMapping("/detail")
	public @ResponseBody MemberDTO getMemberById(Model model,HttpSession session){
		logger.info("member == getMemberById");
		member = (MemberDTO) session.getAttribute("user");
		String id = member.getId();
	logger.info("=== getMemberById() @@ 세션에 담겨있는 유저의 아이디 @@ {} @@",member.getId());
		if(memberService.isMember(id)){
			member = memberService.detail(id);
			member.setRole(User.valueOf(member.getCate()).toString());		
			model.addAttribute("info",member);
		}else{
			model.addAttribute("member","");
		}
		return member;
	}	
	
	@RequestMapping("/count")
	public String count(Model model){
		int count = memberService.count();
		return "member/login_form";
	}
	@RequestMapping("/delete")
	public String delete(Model model,HttpSession session){
		logger.info("=== member-delete() ===");
	 
		int result = memberService.remove((MemberDTO) session.getAttribute("user"));
		if(result ==1){
			logger.info("삭제 성공");
		}else{
			logger.info("삭제 실패");
		}
			
			
		return "member/update_form";
	}	
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		logger.info("=== member-logout() ===");
		status.setComplete();
		return "redirect:/";
	}
	

}
