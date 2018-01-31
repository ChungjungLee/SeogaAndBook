package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.QuestionDAO;
import cj.project.seogaandbook.vo.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDAO questionDAO;
	
	/**
	 * 질문 글 저장
	 * @param question
	 * @return
	 */
	public boolean enter(Question question) {
		if (questionDAO.enter(question) == 1) {
			return true;
		} else {
			return false;
		}
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
		return questionDAO.search(limit, page, select, text);
	}
	
	/**
	 * 검색 결과의 총 개수를 반환
	 * @param text
	 * @return
	 */
	public int selectTotalCount(String select, String text) {
		return questionDAO.selectTotalCount(select, text);
	}
	
	/**
	 * 모든 질문 글 가져오기
	 * @return
	 */
	public ArrayList<Question> getAllQuestions() {
		return questionDAO.getAllQuestions();
	}
	
	/**
	 * 질문 글 읽기
	 * @param questionNum
	 * @return
	 */
	public Question getQuestionByNum(int questionNum) {
		return questionDAO.getQuestionByNum(questionNum);
	}
	
	/**
	 * 질문 글 수정
	 * @param question
	 * @return
	 */
	public boolean update(Question question) {
		if (questionDAO.update(question) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 질문 글 삭제
	 * @param questionNum
	 * @return
	 */
	public boolean delete(int questionNum) {
		if (questionDAO.delete(questionNum) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 조회수 증가
	 * @param questionNum
	 * @return
	 */
	public boolean updateView(int questionNum) {
		if (questionDAO.updateView(questionNum) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
























