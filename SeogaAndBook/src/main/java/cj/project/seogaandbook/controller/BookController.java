package cj.project.seogaandbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.project.seogaandbook.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping (value = "bookHome", method = RequestMethod.GET)
	public String bookHomePage() {
		logger.info("called bookHome");
		return "bookPages/bookHome";
	}
	
	
	@RequestMapping (value = "bookEnter", method = RequestMethod.GET)
	public String bookEnterPage() {
		logger.info("called bookEnter");
		return "bookPages/bookEnter";
	}
}
