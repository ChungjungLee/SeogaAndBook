package cj.project.seogaandbook.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cj.project.seogaandbook.service.MemberService;
import cj.project.seogaandbook.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * 회원 가입 페이지로 이동
	 * @return
	 */
	@RequestMapping (value = "join", method = RequestMethod.GET)
	public String memberJoinPage() {
		return "memberPages/memberJoin";
	}
	
	/**
	 * 회원 가입 정보를 받아 데이터베이스에 저장
	 * @return 가입 성공시 성공 페이지로, 실패시 실패 페이지로.
	 */
	@RequestMapping (value = "join", method = RequestMethod.POST)
	public String join(Member member) {
		
		logger.info("가입 정보: {}", member);
		
		if (memberService.signUp(member)) {
			return "memberPages/memberJoinComplete";
		} else {
			return "memberPages/memberJoinError";
		}
	}
	
	/**
	 * 해당 아이디가 중복인지 아닌지 확인
	 * @param id
	 * @param response
	 */
	@RequestMapping (value = "checkIdDuplicate", method = RequestMethod.GET)
	@ResponseBody
	public void checkIdDuplicate(String id, HttpServletResponse response) {
		if (memberService.getMemberInfoById(id) == null) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		}
	}
	
	/**
	 * 해당 이메일이 중복인지 아닌지 확인
	 * @param id
	 * @param response
	 */
	@RequestMapping (value = "checkEmailDuplicate", method = RequestMethod.GET)
	@ResponseBody
	public void checkEmailDuplicate(String email, HttpServletResponse response) {
		logger.info("검사 이메일: {}", email);
		
		if (memberService.getMemberInfoByEmail(email) == null) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
		}
	}
	
	/**
	 * 로그인 
	 * @param id
	 * @param password
	 * @return
	 */
	@RequestMapping (value = "login", method = RequestMethod.POST)
	public String login(String id, String password, HttpSession session, Model model) {
		if (memberService.login(id, password)) {
			session.setAttribute("loginId", id);
			
			return "redirect:../home";
			
		} else {
			model.addAttribute("errorMsg", "아이디와 비밀번호가 일치하지 않습니다.");
			
			return "redirect:../";
		}
		
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		
		return "redirect:../";
	}
	
	/**
	 * 회원 정보 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String updatePage(HttpSession session, Model model) {
		if (session.getAttribute("loginId") == null) {
			return "invalidAccess";
		}
		
		String loginId = (String) session.getAttribute("loginId");
		if (loginId == null || loginId.equals("")) {
			return "invalidAccess";
		}
		
		Member member = memberService.getMemberInfoById(loginId);
		
		model.addAttribute("member", member);
		
		return "memberPages/memberUpdate";
	}
	
	/**
	 * 회원 정보 수정
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String update(Member member, Model model) {
		logger.info("수정 정보: {}", member);
		
		if (memberService.update(member)) {
			return "memberPages/memberUpdateComplete";
		} else {
			return "memberPages/memberUpdateError";
		}
		
	}
	
	/**
	 * 회원 정보 삭제
	 * @param member
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "delete", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		logger.info("삭제 정보: {}", session.getAttribute("loginId"));
		
		String loginId = (String) session.getAttribute("loginId");
		
		session.removeAttribute("loginId");
		
		if (memberService.delete(loginId)) {
			return "memberPages/memberDeleteComplete";
		} else {
			return "memberPages/memberDeleteError";
		}
		
	}
	
	
	
	@RequestMapping (value = "checkIdDuplicateOther", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Boolean> checkIdDuplicateOther(String id) {
		
		logger.info("아이디 중복 검사: {}", id);
		
		HashMap<String, Boolean> result = new HashMap<>();
		
		if (memberService.getMemberInfoById(id) == null) {
			result.put("canUse", true);
		} else {
			result.put("canUse", false);
		}
		
		return result;
	}
}
