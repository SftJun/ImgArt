package com.outlook.sftjun.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.outlook.sftjun.domain.Img;

@Repository
public class ImgDao extends BaseDao<Img> {
	@SuppressWarnings("unchecked")
	public List<Img> findListForPage(final int firstResult, final int maxResults) {
		final String hql = "from Img";
		List<Img> list = null;
		list = (List<Img>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return query.list();
			}
		});
		return list;
	}
}
