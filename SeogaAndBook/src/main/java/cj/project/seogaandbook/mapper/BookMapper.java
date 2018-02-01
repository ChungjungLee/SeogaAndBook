package cj.project.seogaandbook.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import cj.project.seogaandbook.vo.Book;

public interface BookMapper {
	int enter(Book book);
	
	ArrayList<Book> getAllBooks();
	
	ArrayList<Book> getRecentlyAdded();
	
	Book getBookByIsbn13(long isbn13);

	ArrayList<Book> searchList(HashMap<String, String> map);

}
