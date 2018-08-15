package com.xiaoxiang.cabbage.web;

import java.util.LinkedHashMap;
import java.util.Map;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Value("${adminPath}")
	private String adminPath;
	
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/test", "anon");
		filterChainDefinitionMap.put(adminPath+"/**", "kickoutFilter,user");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
	
}
