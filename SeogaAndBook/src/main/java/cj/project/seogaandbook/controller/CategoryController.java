package cj.project.seogaandbook.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cj.project.seogaandbook.service.CategoryService;
import cj.project.seogaandbook.vo.Category;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	/**
	 * 모든 카테고리 정보
	 * @return
	 */
	public ArrayList<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
}
