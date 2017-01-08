package com.outlook.sftjun.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.outlook.sftjun.domain.User;

@Repository
public class UserDao extends BaseDao<User> {
	/**
	 * 利用用户名查询用户 若存在此用户，则返回该用户，若不存在则返回NULL
	 * 
	 * @param userName
	 * @return User
	 */
	public User findUserByName(String userName) {
		String queryStringByName = "from User where userName =?";
		List<User> users = (List<User>) getHibernateTemplate().find(queryStringByName, userName);
		if (users.size() > 0 && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

}
