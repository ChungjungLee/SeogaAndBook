package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.AuthorDAO;
import cj.project.seogaandbook.vo.Author;

@Service
public class AuthorService {
	@Autowired
	AuthorDAO authorDAO;
	
	/**
	 * 작가 정보 저장하기
	 * @param author
	 * @return
	 */
	public boolean enter(Author author) {
		if (authorDAO.enter(author) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 모든 작가 정보 가져오기
	 * @return
	 */
	public ArrayList<Author> getAllAuthors() {
		return authorDAO.getAllAuthors();
	}
}
