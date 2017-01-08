package com.outlook.sftjun.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.outlook.sftjun.dao.UserDao;
import com.outlook.sftjun.domain.User;

/**
 * @Title:Service
 * @Description:用户服务
 * @author YinJun
 * @version V1.0
 */
@Service
@Transactional
public class UserService extends BaseService<User> {
	@Autowired
	private UserDao userDao;

	/**
	 * 调用DAO,利用用户名查询
	 * 
	 * @param userName
	 * @return User
	 */
	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

	/**
	 * 通过ID查询对象
	 * 
	 * @param userId
	 * @return
	 */
	public User findById(String userId) {
		return userDao.findById(new User(), userId);
	}

	/**
	 * 判断当前用户名是否存在 false:用户名可用，可以注册 true:用户名不可用，不可注册
	 * 
	 * @param userName
	 * @return boolean
	 */
	public boolean isExistsUser(String userName) {
		if (findUserByName(userName) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 注册用户，若成功则返回true，否则返回false
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean saveUser(User user) {
		if (isExistsUser(user.getUserName())) {
			return false;
		} else {
			if (isLegalOfUser(user)) {
				userDao.save(user);
				return true;
			} else {
				return true;
			}
		}
	}

	/**
	 * 更新用户信息，若成功则返回true，否则返回false
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean updateUser(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (DataAccessException DAE) {
			return false;
		}
	}

	/**
	 * 判断用户的输入是否合法，目前只单纯判断用户的输入是否为空
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean isLegalOfUser(User user) {
		if (StringUtils.isEmpty(user.getUserName())) {
			return false;
		} else if (StringUtils.isEmpty(user.getPassword())) {
			return false;
		} else if (StringUtils.isEmpty(user.getGender())) {
			return false;
		} else if (StringUtils.isEmpty(user.getTel())) {
			return false;
		} else if (StringUtils.isEmpty(user.getAge().toString())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 查询所有对象记录
	 */
	public List<User> findAll() {
		return userDao.findAll(new User());
	}

	/**
	 * 根据ID删除对象
	 * 
	 * @param userid
	 * @return
	 */
	public boolean delById(String userid) {
		return userDao.delById(new User(), userid);
	}

}
