package cj.project.seogaandbook.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import cj.project.seogaandbook.vo.Question;

public interface QuestionMapper {
	int enter(Question question);
	
	ArrayList<Question> getAllQuestions();
	
	Question getQuestionByNum(int questionNum);
	
	int update(Question question);
	
	int delete(int questionNum);
	
	ArrayList<Question> searchList(RowBounds rb, HashMap<String, Object> map);
	
	ArrayList<Question> searchListOld(RowBounds rb, HashMap<String, Object> map);
	
	int searchListCount(HashMap<String, Object> map);
	
	int updateView(int questionNum);
}
