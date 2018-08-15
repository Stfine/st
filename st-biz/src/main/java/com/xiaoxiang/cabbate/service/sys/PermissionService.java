package com.xiaoxiang.cabbate.service.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.dao.PermissionDao;
import com.xiaoxiang.cabbage.sys.dao.RolePermissionDao;
import com.xiaoxiang.cabbage.sys.model.Permission;

@Service
@Transactional
public class PermissionService {

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
		
		if(smList.isEmpty()) {
			return ;
		}
		
		
		List<String> listVlues = new ArrayList<String>();
		
		for (Permission p : smList) {
			
			p.setCreateTime(new Date());
			permissionDao.save(p);
			
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
}
