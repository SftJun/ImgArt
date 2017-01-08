package com.outlook.sftjun.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDao<T> implements IBaseDao<T> {// 提供DAO类的级别的泛型支持

	@Autowired
	private HibernateTemplate hibernateTemplate;// 注入Hibernate模板类
	// DAO的泛型类，即子类所指定的T所对应的类型
	private Class entityClass;

	public BaseDao() {// 通过反射方式获取子类Dao对应的泛型实体类
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.outlook.sftjun.dao.IBaseDao#get(java.io.Serializable)
	 */
	public T get(Serializable id) {
		return (T) hibernateTemplate.get(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.outlook.sftjun.dao.IBaseDao#save(T)
	 */
	public void save(T entity) {
		// hibernateTemplate.save(entity);
		hibernateTemplate.persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.outlook.sftjun.dao.IBaseDao#update(T)
	 */
	public void update(T entity) {
		// hibernateTemplate.update(entity);
		hibernateTemplate.merge(entity);
	}

	/**
	 * 删除实体
	 */
	public void remove(T entity) {
		hibernateTemplate.delete(entity);
	}

	/**
	 * 取到HibernateTemplate模板
	 * 
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate() {
		// 将当前session的FlushMode设置成自动，防止当执行查询语句之后再执行插入或者更新语句时，
		// FlushMode变为read-only，不能执行插入与更新
		hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return hibernateTemplate;
	}

	/**
	 * 设置HibernateTemplate Spring自动注入
	 * 
	 * @param hibernateTemplate
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.outlook.sftjun.dao.IBaseDao#findAll(T)
	 */
	public List<T> findAll(T entity) {
		String hql = "from " + entity.getClass().getSimpleName();
		List<T> lists = (List<T>) hibernateTemplate.find(hql);
		if (lists.size() > 0 && !lists.isEmpty()) {
			return lists;
		} else {
			return null;
		}
	}

	/**
	 * 通过ID 查询对象记录
	 * 
	 * @param entity
	 * @param oid
	 * @return
	 */
	public T findById(T entity, String oid) {
		String hql = "from " + entity.getClass().getCanonicalName() + " where id =?";
		List<T> lists = (List<T>) hibernateTemplate.find(hql, oid);
		if (lists.size() > 0 && !lists.isEmpty()) {
			return lists.get(0);
		}
		return null;
	}
	
	/**
	 * 通过对象ID删除对象记录
	 */
	public boolean delById(T entity,String oid) {
		T obj = findById(entity, oid);
		if(obj != null){
			remove(obj);
			return true;
		}
		return false;
	}

}
