package cj.project.seogaandbook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.ReviewMapper;
import cj.project.seogaandbook.vo.Review;
import cj.project.seogaandbook.vo.ReviewBoard;

@Repository
public class ReviewDAO {
	
	@Autowired
	SqlSession session;
	
	/**
	 * 서평 작성
	 * @return
	 */
	public int enter(Review review) {
		int result = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.enter(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 서평 검색 결과를 반환
	 * @param limit 페이지 당 보여줄 서평 수
	 * @param page 현재 페이지
	 * @param select 검색 조건
	 * @param text 검색어
	 * @return
	 */
	public ArrayList<ReviewBoard> search(int limit, int page, String select, String text) {
		ArrayList<ReviewBoard> result = null;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("select", select);
		map.put("text", text);
		
		// RowBounds(int offset, int limit)
		RowBounds rb = new RowBounds((page - 1) * limit, limit);
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			result = mapper.searchList(rb, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 검색 결과의 총 개수를 반환
	 * @param text
	 * @return
	 */
	public int selectTotalCount(String select, String text) {
		int result = 0;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("select", select);
		map.put("text", text);
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			result = mapper.searchListCount(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 서평 가져오기
	 * @return
	 */
	public ArrayList<Review> getAllReviews() {
		ArrayList<Review> result = null;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.getAllReviews();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 특정 서평 하나 읽어오기
	 * @param reviewNum
	 * @return
	 */
	public ReviewBoard getReviewByNum(int reviewNum) {
		ReviewBoard result = null;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.getReviewByNum(reviewNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 서평 수정
	 * @return
	 */
	public int update(ReviewBoard review) {
		int result = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.update(review);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 서평 삭제
	 * @return
	 */
	public int delete(int reviewNum) {
		int result = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.delete(reviewNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 조회수 증가
	 * @param questionNum
	 * @return
	 */
	public int updateView(int reviewNum) {
		int result = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			
			result = mapper.updateView(reviewNum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
