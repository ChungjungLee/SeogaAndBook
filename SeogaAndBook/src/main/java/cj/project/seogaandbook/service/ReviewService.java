package cj.project.seogaandbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.ReviewDAO;
import cj.project.seogaandbook.vo.Review;
import cj.project.seogaandbook.vo.ReviewBoard;

@Service
public class ReviewService {

	@Autowired
	ReviewDAO reviewDAO;
	
	/**
	 * 서평 저장
	 * @param review
	 * @return
	 */
	public boolean enter(Review review) {
		if (reviewDAO.enter(review) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 서평 검색 결과를 반환
	 * @param limit 페이지 당 보여줄 질문 글 수
	 * @param page 현재 페이지
	 * @param select 검색 조건
	 * @param text 검색어
	 * @return
	 */
	public ArrayList<ReviewBoard> search(int limit, int page, String select, String text) {
		return reviewDAO.search(limit, page, select, text);
	}
	
	/**
	 * 서평 검색 결과의 총 개수를 반환
	 * @param text
	 * @return
	 */
	public int selectTotalCount(String select, String text) {
		return reviewDAO.selectTotalCount(select, text);
	}
	
	/**
	 * 모든 서평 읽어오기
	 * @return
	 */
	public ArrayList<Review> getAllReviews() {
		return reviewDAO.getAllReviews();
	}
	
	/**
	 * 특정 서평 읽어오기
	 * @param reviewNum
	 * @return
	 */
	public ReviewBoard getReviewByNum(int reviewNum) {
		return reviewDAO.getReviewByNum(reviewNum);
	}
	
	/**
	 * 서평 수정
	 * @param review
	 * @return
	 */
	public boolean update(ReviewBoard review) {
		if (reviewDAO.update(review) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 서평 삭제
	 * @param reviewNum
	 * @return
	 */
	public boolean delete(int reviewNum) {
		if (reviewDAO.delete(reviewNum) == 1) {
			return true;
		} else {
			return false;
		}
	}
}





























