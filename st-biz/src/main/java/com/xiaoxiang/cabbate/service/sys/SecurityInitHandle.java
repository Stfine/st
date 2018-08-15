package com.xiaoxiang.cabbate.service.sys;


import java.lang.annotation.Annotation;
import java.lang.module.ModuleDescriptor.Requires;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.openmbean.TabularType;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiBasedExporter;
import org.springframework.stereotype.Controller;

import com.xiaoxiang.cabbage.sys.model.Permission;
import com.xiaoxiang.cabbate.service.sys.sccurity.SecurityMapping;
import com.xiaoxiang.cabbate.service.sys.utils.StClassUrils;

import vc.thinker.sys.contants.SysUserContant;

/**
 * 权限初始化相关
 * @author zhanggaoxiang
 *
 */
public class SecurityInitHandle {

	public static final Logger LOGGER = LoggerFactory.getLogger(SecurityInitHandle.class);
	
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 扫描包
	 */
	public String pack;
	
	/**
	 * 是否启动初始化
	 */
	public boolean runInit = false;
	
	/**
	 * 用户类型
	 */
	public int userType;
	
	/**
	 * 初始化方法
	 */
	private void init() {
		
		if(this.isRunInit()) {
			handler();
		}
	}
	
	/**
	 * 具体的执行方法
	 */
	public void handler() {
		
		List<Permission> list = findAllPermission();
		
		permissionService.insertPermissions(list,userType);
	}
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Permission> findAllPermission(){
		
		List<Permission> resp = new ArrayList<Permission>();
		
		Set<Class<?>>  classes = StClassUrils.getClasses(pack, Controller.class);
		
		for (Class<?> class1 : classes) {
			Method[] ms = class1.getMethods();
			for (Method m : ms) {
				Annotation[] annotation = m.getAnnotations();
				SecurityMapping sm = null;
				RequiresPermissions rp = null;
				
				for (Annotation tag : annotation) {
					if(SecurityMapping.class.isAssignableFrom(tag.annotationType())) {
						sm = (SecurityMapping)tag;
					}
					if(RequiresPermissions.class.isAssignableFrom(tag.annotationType())) {
						rp = (RequiresPermissions)tag;
					}
				}
				
				if(null != sm && null != rp) {
					Permission permission = new Permission();
					permission.setName(sm.name());
					permission.setValue(rp.value()[0]);
					permission.setGroupName(sm.permGroup());
					permission.setUserType(sm.userType());
					resp.add(permission);
				}
			}
		}
		return resp;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public boolean isRunInit() {
		return runInit;
	}

	public void setRunInit(boolean runInit) {
		this.runInit = runInit;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
}
