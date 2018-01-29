package cj.project.seogaandbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cj.project.seogaandbook.service.PublisherService;

@Controller
public class PublisherController {
	@Autowired
	PublisherService publisherDAO;
	
}
