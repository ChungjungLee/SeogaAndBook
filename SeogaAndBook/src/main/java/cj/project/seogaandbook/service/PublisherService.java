package cj.project.seogaandbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.PublisherDAO;

@Service
public class PublisherService {
	@Autowired
	PublisherDAO publisherDAO;
}
