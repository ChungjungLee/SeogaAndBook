package cj.project.seogaandbook.mapper;

import java.util.ArrayList;

import cj.project.seogaandbook.vo.Publisher;

public interface PublisherMapper {
	public int enter(Publisher publisher);
	
	public ArrayList<Publisher> getAllPubs();
}
