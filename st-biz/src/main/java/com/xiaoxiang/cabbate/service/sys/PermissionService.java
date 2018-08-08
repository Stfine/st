package com.xiaoxiang.cabbate.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.dao.PermissionDao;

@Service
@Transactional
public class PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	public List<PermissionBO> findAll(){
		return permissionDao.findAll();
	}
}
