package com.outlook.sftjun.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

	/**
	 * 查询得到结果
	 * 
	 * @param id
	 * @return
	 */
	T get(Serializable id);

	/**
	 * 持久化实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	void remove(T entity);
	
	/**
	 * 通过ID进行查询
	 * @param entity
	 * @return
	 */
	T findById(T entity,String stringId);

	/**
	 * 查询该对象的所有信息
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findAll(T entity);
	/**
	 * 利用ID删除对象
	 */
	boolean delById(T entity,String oid);
}