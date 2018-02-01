package cj.project.seogaandbook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cj.project.seogaandbook.service.AuthorService;
import cj.project.seogaandbook.service.BookService;
import cj.project.seogaandbook.service.CategoryService;
import cj.project.seogaandbook.service.PublisherService;
import cj.project.seogaandbook.vo.Author;
import cj.project.seogaandbook.vo.Book;
import cj.project.seogaandbook.vo.Category;
import cj.project.seogaandbook.vo.Publisher;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	PublisherService publisherService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AuthorService authorService;
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	/**
	 * 도서 홈페이지로 이동한다.
	 * @return
	 */
	@RequestMapping (value = "home", method = RequestMethod.GET)
	public String bookHomePage(
			Model model,
			@RequestParam(value="searchOption", defaultValue="") String option,
			@RequestParam(value="cateNum", defaultValue="") String cateNum) {
		
		ArrayList<Book> books = bookService.searchList(option, cateNum);
		
		model.addAttribute("books", books);
		
		return "bookPages/bookHome";
	}
	
	/**
	 * 도서 등록 페이지로 이동한다.
	 * @param model
	 * @return
	 */
	@RequestMapping (value = "enter", method = RequestMethod.GET)
	public String bookEnterPage(Model model) {
		ArrayList<Category> categories = categoryService.getAllCategories();
		ArrayList<Publisher> publishers = publisherService.getAllPubs();
		ArrayList<Author> authors = authorService.getAllAuthors();
		
		model.addAttribute("categories", categories);
		model.addAttribute("publishers", publishers);
		model.addAttribute("authors", authors);
		return "bookPages/bookEnter";
	}
	
	/**
	 * 실제 도서 등록
	 * @return
	 */
	@RequestMapping (value = "enter", method = RequestMethod.POST)
	public String bookEnter(Book book) {
		
		if (bookService.enter(book)) {
			return "redirect:home";
		} else {
			return "redirect:enter";
		}
		
	}
	
	/**
	 * 해당 ISBN 코드가 이미 사용중인지 판별 
	 * @param isbn13
	 * @param response
	 */
	@RequestMapping (value = "checkIsbn13Duplicate", method = RequestMethod.GET)
	@ResponseBody
	public void checkIsbn13Duplicate(long isbn13, HttpServletResponse response) {
		logger.info("검사 isbn: {}", isbn13);
		if (bookService.getBookByIsbn13(isbn13) == null) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
	
}
