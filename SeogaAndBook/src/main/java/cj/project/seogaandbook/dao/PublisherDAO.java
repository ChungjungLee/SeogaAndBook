package cj.project.seogaandbook.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cj.project.seogaandbook.mapper.PublisherMapper;
import cj.project.seogaandbook.vo.Publisher;

@Repository
public class PublisherDAO {
	@Autowired
	SqlSession session;
	
	/**
	 * 출판사 정보 저장
	 * @param publisher
	 * @return
	 */
	public int enter(Publisher publisher) {
		int result = 0;
		
		try {
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			
			result = mapper.enter(publisher);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 모든 출판사 정보를 읽어오기
	 * @return
	 */
	public ArrayList<Publisher> getAllPubs() {
		ArrayList<Publisher> result = null;
		
		try {
			PublisherMapper mapper = session.getMapper(PublisherMapper.class);
			
			result = mapper.getAllPubs();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
