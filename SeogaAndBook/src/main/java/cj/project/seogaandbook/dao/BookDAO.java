package cj.project.seogaandbook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.BookMapper;
import cj.project.seogaandbook.vo.Book;

@Repository
public class BookDAO {
	
	@Autowired
	SqlSession session;
	
	/**
	 * 책 정보를 저장
	 * @param book
	 * @return
	 */
	public int enter(Book book) {
		int result = 0;
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			result = mapper.enter(book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 책 정보를 가져온다
	 * @return
	 */
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> result = null;
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			result = mapper.getAllBooks();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 최근 추가된 책 정보 4개
	 * @return
	 */
	public ArrayList<Book> getRecentlyAdded() {
		ArrayList<Book> result = null;
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			result = mapper.getRecentlyAdded();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ISBN 코드로 책 정보를 가져온다
	 * @param isbn13
	 * @return
	 */
	public Book getBookByIsbn13(long isbn13) {
		Book result = null;
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			result = mapper.getBookByIsbn13(isbn13);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Book> searchList(String option, String cateNum) {
		ArrayList<Book> result = null;
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("option", option);
		map.put("cateNum", cateNum);
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			result = mapper.searchList(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
