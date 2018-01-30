package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.BookDAO;
import cj.project.seogaandbook.vo.Book;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDAO;
	
	/**
	 * 책 정보를 입력한다
	 * @param book
	 * @return
	 */
	public boolean enter(Book book) {
		if (bookDAO.enter(book) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 모든 책 정보를 가져온다
	 * @return
	 */
	public ArrayList<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}
	
	/**
	 * ISBN코드로 책 정보 가져온다
	 * @param isbn13
	 * @return
	 */
	public Book getBookByIsbn13(long isbn13) {
		return bookDAO.getBookByIsbn13(isbn13);
	}
}
