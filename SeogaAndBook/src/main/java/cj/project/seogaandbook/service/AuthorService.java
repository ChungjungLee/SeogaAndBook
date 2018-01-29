package cj.project.seogaandbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.project.seogaandbook.dao.AuthorDAO;

@Service
public class AuthorService {
	@Autowired
	AuthorDAO authorDAO;
	
	
}
