package com.outlook.sftjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.outlook.sftjun.dao.CommentDao;
import com.outlook.sftjun.domain.Comment;

@Service
@Transactional
public class CommentService extends BaseService<Comment>{

	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
