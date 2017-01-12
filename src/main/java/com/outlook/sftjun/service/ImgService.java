package com.outlook.sftjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.outlook.sftjun.dao.ImgDao;
import com.outlook.sftjun.domain.Img;

@Service
@Transactional
public class ImgService extends BaseService<Img>{
	
	@Autowired
	private ImgDao imgDao;
	
	public List<Img> findAll() {
		return imgDao.findAll(new Img());
	}

	public void save(Img img) {
		imgDao.save(img);
	}

}
