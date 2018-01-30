package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.AnswerDAO;
import cj.project.seogaandbook.vo.Answer;

@Service
public class AnswerService {
	
	@Autowired
	AnswerDAO answerDAO;
	
	/**
	 * 질문에 대한 답변 저장
	 * @param answer
	 * @return
	 */
	public boolean enter(Answer answer) {
		if (answerDAO.enter(answer) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 질문에 대한 답변을 가져오기
	 * @param questionNum
	 * @return
	 */
	public ArrayList<Answer> getAllAnswers(int questionNum) {
		return answerDAO.getAllAnswers(questionNum);
	}
	
	/**
	 * 특정 답변 가져오기
	 * @param answerNum
	 * @return
	 */
	public Answer getAnswerByNum(int answerNum) {
		return answerDAO.getAnswerByNum(answerNum);
	}
	
	/**
	 * 답변 수정
	 * @param answer
	 * @return
	 */
	public boolean update(Answer answer) {
		if (answerDAO.update(answer) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 답변 삭제
	 * @param answerNum
	 * @return
	 */
	public boolean delete(int answerNum) {
		if (answerDAO.delete(answerNum) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
