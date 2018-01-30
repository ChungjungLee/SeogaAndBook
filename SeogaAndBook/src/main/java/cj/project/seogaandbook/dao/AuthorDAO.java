package cj.project.seogaandbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.AuthorMapper;
import cj.project.seogaandbook.vo.Author;

@Repository
public class AuthorDAO {
	@Autowired
	SqlSession session;
	
	/**
	 * 작가 정보 저장
	 * @param author
	 * @return
	 */
	public int enter(Author author) {
		int result = 0;
		
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			
			result = mapper.enter(author);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 작가 정보 가져오기
	 * @return
	 */
	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> result = null;
		
		try {
			AuthorMapper mapper = session.getMapper(AuthorMapper.class);
			
			result = mapper.getAllAuthors();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
