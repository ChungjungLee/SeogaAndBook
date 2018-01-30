package cj.project.seogaandbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.AnswerMapper;
import cj.project.seogaandbook.vo.Answer;

@Repository
public class AnswerDAO {
	@Autowired
	SqlSession session;
	
	/**
	 * 답변 작성
	 * @param answer
	 * @return
	 */
	public int enter(Answer answer) {
		int result = 0;
		
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			
			result = mapper.enter(answer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 질문에 달려 있는 모든 답변 읽어오기
	 * @param questionNum
	 * @return
	 */
	public ArrayList<Answer> getAllAnswers(int questionNum) {
		ArrayList<Answer> result = null;
		
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			
			result = mapper.getAllAnswers(questionNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 답변 하나 가져오기
	 * @param answerNum
	 * @return
	 */
	public Answer getAnswerByNum (int answerNum) {
		Answer result = null;
		
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			
			result = mapper.getAnswerByNum(answerNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 답변 수정
	 * @return
	 */
	public int update(Answer answer) {
		int result = 0;
		System.out.println(answer);
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			
			result = mapper.update(answer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 답변 삭제
	 * @return
	 */
	public int delete(int answerNum) {
		int result = 0;
		
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			
			result = mapper.delete(answerNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
