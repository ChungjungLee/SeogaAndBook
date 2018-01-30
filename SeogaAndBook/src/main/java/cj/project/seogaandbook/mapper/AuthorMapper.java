package cj.project.seogaandbook.mapper;

import java.util.ArrayList;

import cj.project.seogaandbook.vo.Author;

public interface AuthorMapper {
	int enter(Author author);
	
	ArrayList<Author> getAllAuthors();
}
