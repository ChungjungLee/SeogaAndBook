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

import cj.project.seogaandbook.service.BookService;
import cj.project.seogaandbook.service.MemberService;
import cj.project.seogaandbook.service.ReviewService;
import cj.project.seogaandbook.util.PageNavigator;
import cj.project.seogaandbook.vo.Book;
import cj.project.seogaandbook.vo.Review;
import cj.project.seogaandbook.vo.ReviewBoard;

@Controller
@RequestMapping("review")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	MemberService memberService;
	
	private final int LIMIT = 5;	// 페이지 당 보여줄 게시글 수
	private final int PAGES = 5;	// 그룹 당 보여줄 페이지 수
	
	Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	/**
	 * 서평 게시판 홈으로 이동한다.
	 * @return
	 */
	@RequestMapping (value = "home", method = RequestMethod.GET)
	public String reviewHomePage(
			Model model,
			@RequestParam(value="pageNum", defaultValue="1") int currentPage, 
			@RequestParam(value="searchOption", defaultValue="") String select,
			@RequestParam(value="searchText", defaultValue="") String text) {
		
		ArrayList<ReviewBoard> reviewBoards = null;
		
		if (select.equals("book")) {
			reviewBoards = reviewService.search(LIMIT, currentPage, select, text);
		} else {
			reviewBoards = reviewService.search(LIMIT, currentPage, select, text);
		}
		
		int totalCount = reviewService.selectTotalCount(select, text);
		
		// 네비게이터 표시를 위한 객체 생성
		PageNavigator navi = new PageNavigator(LIMIT, PAGES, currentPage, totalCount);
		
		model.addAttribute("reviews", reviewBoards);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("navi", navi);
		
		return "reviewPages/reviewHome";
	}
	
	/**
	 * 서평 작성 페이지로 이동
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.GET)
	public String reviewWritePage(Model model) {
		ArrayList<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "reviewPages/reviewWrite";
	}
	
	/**
	 * 서평 작성
	 * @return
	 */
	@RequestMapping (value = "write", method = RequestMethod.POST)
	public String reviewWrite(Review review, HttpSession session) {
		String longinId = (String) session.getAttribute("loginId");
		
		review.setMemberNum(memberService.getMemberInfoById(longinId).getMemberNum());
		review.setContent(review.getContent().replace("\r\n", "<br>"));
		
		if (reviewService.enter(review)) {
			return "redirect:home";
		} else {
			return "redirect:write";
		}
	}
	
	/**
	 * 서평 읽기
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "read", method = RequestMethod.GET)
	public String reviewReadPage(int reviewNum, Model model) {
		ReviewBoard review = reviewService.getReviewByNum(reviewNum);
		
		model.addAttribute("review", review);
		
		return "reviewPages/reviewRead";
	}
	
	/**
	 * 서평 수정 페이지로 이동한다.
	 * @param reviewNum
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String updateReviewPage(Integer reviewNum, Model model) {
		ReviewBoard review = reviewService.getReviewByNum(reviewNum);
		model.addAttribute("review", review);
		return "reviewPages/reviewUpdate";
	}
	
	/**
	 * 서평 수정
	 * @param reviewBoard
	 * @return
	 */
	@RequestMapping (value = "update", method = RequestMethod.POST)
	public String updateReview(ReviewBoard reviewBoard) {
		logger.info("수정된 서평:{}", reviewBoard);
		
		if (reviewService.update(reviewBoard)) {
			return "redirect:read?reviewNum=" + reviewBoard.getReviewNum();
		} else {
			return "redirect:update?reviewNum=" + reviewBoard.getReviewNum();
		}
		
	}
	
	/**
	 * 서평 삭제
	 * @param reviewNum
	 * @return
	 */
	@RequestMapping (value = "delete", method = RequestMethod.GET)
	public String deleteReview(int reviewNum) {
		if (reviewService.delete(reviewNum)) {
			return "redirect:home";
		} else {
			return "redirect:read?reviewNum=" + reviewNum;
		}
	}
}























