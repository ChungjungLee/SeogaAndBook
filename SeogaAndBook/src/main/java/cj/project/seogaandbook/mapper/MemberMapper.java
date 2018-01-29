package cj.project.seogaandbook.mapper;

import cj.project.seogaandbook.vo.Member;

public interface MemberMapper {
	
	int signUp(Member member);
	
	Member getMemberInfo(int memberNum);
	
	Member getMemberInfoById(String id);
	
	Member getMemberInfoByEmail(String email);
	
	int update(Member member);
	
	int delete(String id);
}
