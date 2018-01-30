package cj.project.seogaandbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.project.seogaandbook.service.PublisherService;
import cj.project.seogaandbook.vo.Publisher;

@Controller
@RequestMapping("publish")
public class PublisherController {
	
	@Autowired
	PublisherService publisherService;
	
	Logger logger = LoggerFactory.getLogger(PublisherController.class);
	
	/**
	 * 출판사 등록 페이지로 이동
	 * @return
	 */
	@RequestMapping (value = "enter", method = RequestMethod.GET)
	public String pubEnterPage() {
		return "bookPages/publisherEnter";
	}
	
	/**
	 * 출판사 등록
	 * @return
	 */
	@RequestMapping (value = "enter", method = RequestMethod.POST)
	public String pubEnter(Publisher publisher) {
		
		logger.info("출판사정보: {}", publisher);
		
		if (publisherService.enter(publisher)) {
			return "redirect:../book/enter";
		} else {
			return "redirect:enter";
		}
		
	}
	
	
}






















