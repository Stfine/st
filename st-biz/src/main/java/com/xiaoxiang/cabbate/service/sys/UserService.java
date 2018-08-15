package com.xiaoxiang.cabbate.service.sys;

import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiang.cabbage.sys.bo.UserBO;
import com.xiaoxiang.cabbage.sys.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 主键查询
	 * @param uid
	 * @return
	 */
	public UserBO findOne(Long uid) {
		return userDao.findOne(uid);
	}
}
