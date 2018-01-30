package cj.project.seogaandbook.mapper;

import java.util.ArrayList;

import cj.project.seogaandbook.vo.Book;

public interface BookMapper {
	int enter(Book book);
	
	ArrayList<Book> getAllBooks();
	
	Book getBookByIsbn13(long isbn13);
}
