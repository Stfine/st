package com.xiaoxiang.cabbate.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiang.cabbage.sys.bo.UserAccountBO;
import com.xiaoxiang.cabbage.sys.dao.UserAccountDao;

@Service
@Transactional
public class UserAccountService {

	@Autowired
	private UserAccountDao userAccountDao;

	/**
	 * 根据登录名查询账户
	 * @param loginName
	 * @return
	 */
	public UserAccountBO findByLoginName(String loginName) {
		return userAccountDao.findByLoginName(loginName);
	}
	
	
}
