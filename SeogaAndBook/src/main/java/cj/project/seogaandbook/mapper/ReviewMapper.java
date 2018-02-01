package cj.project.seogaandbook.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import cj.project.seogaandbook.vo.Review;
import cj.project.seogaandbook.vo.ReviewBoard;

public interface ReviewMapper {
	int enter(Review review);
	
	ArrayList<ReviewBoard> searchList(RowBounds rb, HashMap<String, Object> map);
	
	int searchListCount(HashMap<String, Object> map);
	
	ArrayList<Review> getAllReviews();
	
	ReviewBoard getReviewByNum(int reviewNum);
	
	int update(ReviewBoard review);
	
	int delete(int reviewNum);
	
	int updateView(int reviewNum);
}
