package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.PublisherDAO;
import cj.project.seogaandbook.vo.Publisher;

@Service
public class PublisherService {
	@Autowired
	PublisherDAO publisherDAO;
	
	/**
	 * 출판사 정보 저장
	 * @param publisher
	 * @return
	 */
	public boolean enter(Publisher publisher) {
		if (publisherDAO.enter(publisher) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 모든 출판사 정보 가져오기
	 * @return
	 */
	public ArrayList<Publisher> getAllPubs() {
		return publisherDAO.getAllPubs();
	}
}





















