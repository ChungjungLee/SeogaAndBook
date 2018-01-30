package cj.project.seogaandbook.mapper;

import java.util.ArrayList;

import cj.project.seogaandbook.vo.Question;

public interface QuestionMapper {
	int enter(Question question);
	
	ArrayList<Question> getAllQuestions();
	
	Question getQuestionByNum(int questionNum);
	
	int update(Question question);
	
	int delete(int questionNum);
	
	int updateView(int questionNum);
}
