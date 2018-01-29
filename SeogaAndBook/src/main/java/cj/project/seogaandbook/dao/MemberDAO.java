package cj.project.seogaandbook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.MemberMapper;
import cj.project.seogaandbook.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession session;
	
	/**
	 * 회원 가입한다.
	 * @param member
	 * @return
	 */
	public int signUp(Member member) {
		int result = 0;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.signUp(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 한 명의 회원 정보를 받아온다.
	 * @param memberNum
	 * @return
	 */
	public Member getMemberInfo(int memberNum) {
		Member result = null;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.getMemberInfo(memberNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 아이디가 일치하는 회원 정보를 받아온다.
	 * @param id
	 * @return
	 */
	public Member getMemberInfoById(String id) {
		Member result = null;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.getMemberInfoById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 이메일이 일치하는 회원 정보를 받아온다.
	 * @param id
	 * @return
	 */
	public Member getMemberInfoByEmail(String email) {
		Member result = null;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.getMemberInfoByEmail(email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return
	 */
	public int update(Member member) {
		int result = 0;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.update(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 회원 정보 삭제
	 * @param memberNum
	 * @return
	 */
	public int delete(String id) {
		int result = 0;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			result = mapper.delete(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}


























