package cj.project.seogaandbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.project.seogaandbook.service.BookService;
import cj.project.seogaandbook.service.QuestionService;
import cj.project.seogaandbook.service.ReviewService;
import cj.project.seogaandbook.vo.Book;
import cj.project.seogaandbook.vo.Question;
import cj.project.seogaandbook.vo.Review;

@Controller
public class HomeController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpSession session) {
		System.out.println("called");
		if (session.getAttribute("loginId") == null) {
			return "welcome";
		}
		
		return "redirect:home";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		List<Book> books = bookService.getAllBooks();
		if (books.size() >= 4) {
			books = books.subList(0, 4);
		}
		
		List<Review> reviews = reviewService.getAllReviews();
		if (reviews.size() >= 4) {
			reviews = reviews.subList(0, 4);
		}
		
		List<Question> questions = questionService.getAllQuestions();
		if (questions.size() >= 4) {
			questions = questions.subList(0, 4);
		}
		
		model.addAttribute("books", books);
		model.addAttribute("reviews", reviews);
		model.addAttribute("questions", questions);
		
		return "home";
	}
	
}
