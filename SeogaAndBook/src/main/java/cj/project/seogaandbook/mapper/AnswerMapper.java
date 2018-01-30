package cj.project.seogaandbook.mapper;

import java.util.ArrayList;

import cj.project.seogaandbook.vo.Answer;

public interface AnswerMapper {
	int enter(Answer answer);
	
	ArrayList<Answer> getAllAnswers(int questionNum);
	
	Answer getAnswerByNum(int answerNum);
	
	int update(Answer answer);
	
	int delete(int answerNum);
}
