package cj.project.seogaandbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("member")
public class MemberController {
	
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
	 * @return
	 */
	@RequestMapping (value = "join", method = RequestMethod.POST)
	public String join() {
		
		return "home";
	}
	
	@RequestMapping (value = "checkIdDuplicate", method = RequestMethod.POST)
	@ResponseBody
	public String checkIdDuplicate(String candidateId) {
		
		
		return "";
	}
}
