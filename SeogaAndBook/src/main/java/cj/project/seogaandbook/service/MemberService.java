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
		if (memberDAO.signUp(member) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 로그인
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean login(String id, String password) {
		Member member = getMemberInfoById(id);
		
		if (member == null || !password.equals(member.getPassword())) {
			return false;
		} else {
			return true;
		}
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
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return
	 */
	public boolean update(Member member) {
		if (memberDAO.update(member) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 회원 정보 삭제
	 * @param memberNum
	 * @return
	 */
	public boolean delete(String id) {
		if (memberDAO.delete(id) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
