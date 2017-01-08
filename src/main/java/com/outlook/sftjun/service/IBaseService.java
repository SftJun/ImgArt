package com.outlook.sftjun.service;

import java.util.List;

public interface IBaseService<T> {
	/**
	 * 查询对象的所有记录
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findAll();
}
