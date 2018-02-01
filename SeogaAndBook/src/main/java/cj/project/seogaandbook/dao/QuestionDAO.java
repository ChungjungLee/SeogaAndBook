package cj.project.seogaandbook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
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
	 * 질문 글 검색 결과를 반환
	 * @param limit 페이지 당 보여줄 질문 글 수
	 * @param page 현재 페이지
	 * @param select 검색 조건
	 * @param text 검색어
	 * @return
	 */
	public ArrayList<Question> search(int limit, int page, String select, String text) {
		ArrayList<Question> result = null;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("select", select);
		map.put("text", text);
		
		// RowBounds(int offset, int limit)
		RowBounds rb = new RowBounds((page - 1) * limit, limit);
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			result = mapper.searchList(rb, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 게시물의 총 개수를 반환. 검색 결과의 총 개수를 반환
	 * @param text
	 * @return
	 */
	public int selectTotalCount(String select, String text) {
		int result = 0;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("select", select);
		map.put("text", text);
		
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			result = mapper.searchListCount(map);
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
	
	/**
	 * 질문 글 수정
	 * @param question
	 * @return
	 */
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
	
	/**
	 * 질문 글 삭제
	 * @param questionNum
	 * @return
	 */
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
	
	/**
	 * 조회수 증가
	 * @param questionNum
	 * @return
	 */
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
