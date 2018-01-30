package cj.project.seogaandbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.project.seogaandbook.service.AuthorService;
import cj.project.seogaandbook.vo.Author;

@Controller
@RequestMapping("author")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@RequestMapping (value = "enter", method = RequestMethod.GET)
	public String authorEnterPage() {
		return "bookPages/authorEnter";
	}
	
	@RequestMapping (value = "enter", method = RequestMethod.POST)
	public String authorEnter(Author author) {
		logger.info("작가정보: {}", author);
		
		if (authorService.enter(author)) {
			return "redirect:../book/enter";
		} else {
			return "redirect:enter";
		}
	}
}
