package cj.project.seogaandbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.project.seogaandbook.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	
	@RequestMapping (value = "", method = RequestMethod.GET)
	public String authorEnterPage() {
		return "";
	}
}
