package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.CategoryDAO;
import cj.project.seogaandbook.vo.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	/**
	 * 모든 카테고리 정보를 반환
	 * @return
	 */
	public ArrayList<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
}
