package cj.project.seogaandbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.MemberDAO;
import cj.project.seogaandbook.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	/**
	 * 회원 가입
	 * @param member
	 * @return boolean 가입 성공 여부를 반환
	 */
	public boolean signUp(Member member) {
		boolean result = false;
		
		if (memberDAO.signUp(member) == 1) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 한 명의 회원 정보를 받아온다.
	 * @return 있다면 Member를 반환, 없다면 null을 반환
	 */
	public Member getMemberInfo(int memberNum) {
		return memberDAO.getMemberInfo(memberNum);
	}
	
	/**
	 * 아이디가 일치하는 회원 정보를 받아온다.
	 * @return 있다면 Member를 반환, 없다면 null을 반환
	 */
	public Member getMemberInfoById(String id) {
		return memberDAO.getMemberInfoById(id);
	}
	
	/**
	 * 이메일이 일치하는 회원 정보를 받아온다.
	 * @return 있다면 Member를 반환, 없다면 null을 반환
	 */
	public Member getMemberInfoByEmail(String email) {
		return memberDAO.getMemberInfoByEmail(email);
	}
}
