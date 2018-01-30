package cj.project.seogaandbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.CategoryMapper;
import cj.project.seogaandbook.vo.Category;

@Repository
public class CategoryDAO {
	
	@Autowired
	SqlSession session;
	
	/**
	 * 모든 카테고리 정보를 받아온다
	 * @return
	 */
	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> result = null;
		
		try {
			CategoryMapper mapper = session.getMapper(CategoryMapper.class);
			
			result = mapper.getAllCategories();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
