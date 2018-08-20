package com.xiaoxiang.cabbate.service.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.dao.PermissionDao;
import com.xiaoxiang.cabbage.sys.dao.RolePermissionDao;
import com.xiaoxiang.cabbage.sys.model.Permission;
import com.xiaoxiang.cabbate.service.sys.exception.ServiceException;

@Service
@Transactional(rollbackFor= { ServiceException.class })
public class PermissionService {

	private static final Logger logger = LoggerFactory.getLogger(PermissionService.class);
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	public List<PermissionBO> findAll(){
		return permissionDao.findAll();
	}

	/**
	 * 批量插入权限
	 * @param list
	 */
	public void insertPermissions(List<Permission> smList,int userType) {
		
		List<String> listVlues = new ArrayList<String>();
		
		for (Permission p : smList) {
			
			PermissionBO bo = 
					permissionDao.findByValueAndUserType(p.getValue(),userType);
			if(bo == null) {
				p.setCreateTime(new Date());
				permissionDao.save(p);
			}
			
			listVlues.add(p.getValue());
			
		}
		
		List<PermissionBO> permisses = permissionDao.findNotInValues(listVlues,userType);
		if(!permisses.isEmpty()) {
			deleteNotInValues(listVlues,userType);
			for (PermissionBO p : permisses) {
				rolePermissionDao.deleteByPermissionId(p.getId());
			}
		}
		
	}
	
	/**
	 * 批量删除
	 * @param list
	 */
	public void deleteNotInValues(List<String> list,int userType) {
		permissionDao.deleteNotInValues(list,userType);
	}

	public List<PermissionBO> findByUid(Long uid, int userType) {
		return permissionDao.findByUid(uid,userType);
	}
}
