package com.xiaoxiang.cabbage.web.security;


import com.xiaoxiang.cabbage.sys.model.User;

public class AdminPrincipal {

	private static final long serialVersionUID = -7780221186114180916L;
	
	/**
	 * user 的基本信息
	 */
	private User user;
	
	/**
	 * loginName 登录名
	 */
	public String loginName;
	
	/**
	 * 注册id host 
	 */
	public String host;
	
	public  AdminPrincipal(User user,String loginName,String host) {
		this.user = user;
		this.loginName = loginName;
		this.host = host;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public Long getId() {
		return user.getId();
	}
	
	
}
