package cj.project.seogaandbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.QuestionMapper;
import cj.project.seogaandbook.vo.Question;

@Repository
public class QuestionDAO {
	@Autowired
	SqlSession session;
	
	/**
	 * 질문 글 저장
	 * @param question
	 * @return
	 */
	public int enter(Question question) {
		int result = 0;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.enter(question);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 질문 글을 읽어온다
	 * @return
	 */
	public ArrayList<Question> getAllQuestions() {
		ArrayList<Question> result = null;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.getAllQuestions();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 질문 게시글 하나를 읽어온다
	 * @param questionNum
	 * @return
	 */
	public Question getQuestionByNum(int questionNum) {
		Question result = null;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.getQuestionByNum(questionNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(Question question) {
		int result = 0;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.update(question);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public int delete(int questionNum) {
		int result = 0;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.delete(questionNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateView(int questionNum) {
		int result = 0;
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			
			result = mapper.updateView(questionNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
