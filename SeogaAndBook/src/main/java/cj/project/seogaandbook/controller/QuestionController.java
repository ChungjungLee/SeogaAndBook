package cj.project.seogaandbook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cj.project.seogaandbook.service.AnswerService;
import cj.project.seogaandbook.service.MemberService;
import cj.project.seogaandbook.service.QuestionService;
import cj.project.seogaandbook.util.PageNavigator;
import cj.project.seogaandbook.vo.Answer;
import cj.project.seogaandbook.vo.Question;

@Controller
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AnswerService answerService;
	
	private final int LIMIT = 10;	// 페이지 당 보여줄 게시글 수
	private final int PAGES = 5;	// 그룹 당 보여줄 페이지 수
	
	Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	/**
	 * 질문 게시판 홈으로 이동한다.
	 * @return
	 */
	@RequestMapping (value = "home", method = RequestMethod.GET)
	public String questionHomePage(
			Model model,
			@RequestParam(value="pageNum", defaultValue="1") int currentPage, 
			@RequestParam(value="searchOption", defaultValue="") String select,
			@RequestParam(value="searchText", defaultValue="") String text) {
		
		ArrayList<Question> questions = questionService.search(LIMIT, currentPage, select, text);
		
		int totalCount = questionService.selectTotalCount(select, text);
		
		// 네비게이터 표시를 위한 객체 생성
		PageNavigator navi = new PageNavigator(LIMIT, PAGES, currentPage, totalCount);
		
		model.addAttribute("questions", questions);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("navi", navi);
		
		return "questionPages/questionHome";
	}
	
	/**
	 * 질문 글 작성 페이지로 이동한다.
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.GET)
	public String questionWritePage() {
		return "questionPages/questionWrite";
	}
	
	/**
	 * 질문 글 작성
	 * @param question
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.POST)
	public String questionWrite(Question question, HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "redirect:home";
		}
		
		String loginId = (String) session.getAttribute("loginId");
		
		question.setMemberNum(memberService.getMemberInfoById(loginId).getMemberNum());
		
		if (questionService.enter(question)) {
			return "redirect:home";
		} else {
			return "redirect:write";
		}
	}
	
	/**
	 * 질문 글 수정 페이지로 이동
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String questionUpdatePage(int questionNum) {
		return "questionPages/questionUpdate";
	}
	
	/**
	 * 질문 글 수정
	 * @param question
	 * @param session
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String questionUpdate(Question question, HttpSession session) {
		
		if (session.getAttribute("loginId") == null) {
			return "redirect:home";
		}
		
		String loginId = (String) session.getAttribute("loginId");
		
		question.setMemberNum(memberService.getMemberInfoById(loginId).getMemberNum());
		
		if (questionService.enter(question)) {
			return "redirect:home";
		} else {
			return "redirect:write";
		}
	}
	
	/**
	 * 질문 글 삭제
	 * @param questionNum
	 * @return
	 */
	@RequestMapping (value = "delete", method = RequestMethod.GET)
	public String delete(int questionNum) {
		if (questionService.delete(questionNum)) {
			return "redirect:home";
		} else {
			return "redirect:read?questionNum=" + questionNum;
		}
	}
	
	/**
	 * 질문 게시물을 읽어 온다.
	 * @param questionNum
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "read", method = RequestMethod.GET)
	public String questionRead(Integer questionNum, Model model) {
		Question question = questionService.getQuestionByNum(questionNum);
		ArrayList<Answer> answers = answerService.getAllAnswers(questionNum);
		
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		return "questionPages/questionRead";
	}
	
	/**
	 * 질문에 대한 답변을 다는 페이지로 이동
	 * @param questionNum
	 * @return
	 */
	@RequestMapping (value = "enterAnswer", method = RequestMethod.GET)
	public String enterAnswerPage(Integer questionNum, Model model) {
		Question question = questionService.getQuestionByNum(questionNum);
		model.addAttribute("question", question);
		return "questionPages/answerWrite";
	}
	
	/**
	 * 질문에 대한 답변을 단다.
	 * @return
	 */
	@RequestMapping (value = "enterAnswer", method = RequestMethod.POST)
	public String enterAnswer(Answer answer, HttpSession session) {
		logger.info("답변 내용: {}", answer);
		
		if (session.getAttribute("loginId") == null) {
			return "redirect:home";
		}
		
		String loginId = (String) session.getAttribute("loginId");
		
		answer.setMemberNum(memberService.getMemberInfoById(loginId).getMemberNum());
		
		if (answerService.enter(answer)) {
			return "redirect:read?questionNum=" + answer.getQuestionNum();
		} else {
			return "redirect:read?questionNum=" + answer.getQuestionNum();
		}
		
	}
	
	/**
	 * 답변 수정 페이지로 이동한다
	 * @param answerNum
	 * @return
	 */
	@RequestMapping (value = "updateAnswer", method = RequestMethod.GET)
	public String updateAnswerPage(Integer questionNum, Integer answerNum, Model model) {
		Question question = questionService.getQuestionByNum(questionNum);
		Answer answer = answerService.getAnswerByNum(answerNum);
		
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		
		return "questionPages/answerUpdate";
	}
	
	/**
	 * 답변 수정
	 * @return
	 */
	@RequestMapping (value = "updateAnswer", method = RequestMethod.POST) 
	public String updateAnswer(Answer answer) {
		if (answerService.update(answer)) {
			logger.info("수정 완료");
			return "redirect:read?questionNum=" + answer.getQuestionNum();
		} else {
			logger.info("수정 실패");
			return "redirect:read?questionNum=" + answer.getQuestionNum();
		}
	}
	
	/**
	 * 답변 삭제
	 * @param answerNum
	 * @param questionNum
	 * @return
	 */
	@RequestMapping (value = "deleteAnswer", method = RequestMethod.GET)
	public String deleteAnswer(Integer questionNum, Integer answerNum) {
		if (answerService.delete(answerNum)) {
			return "redirect:read?questionNum=" + questionNum;
		} else {
			return "redirect:read?questionNum=" + questionNum;
		}
	}
}

























