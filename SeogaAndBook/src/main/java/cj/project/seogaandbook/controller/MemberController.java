package cj.project.seogaandbook.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	 * 
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
