package com.xiaoxiang.cabbage.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xiaoxiang.cabbage.web.security.AdminRealm;

@Configuration
public class ShiroConfig {

	@Value("${adminPath}")
	private String adminPath;
	
	
	@Bean
	public AdminRealm AdminRealm() {
		
		AdminRealm adminRealm = new AdminRealm();
		
		return adminRealm;
	}
	
	@Bean
	public SecurityManager securityManager(AdminRealm adminRealm) {
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(adminRealm);
		
		return securityManager;
	}
	
	
	@Bean
	public SessionManager sessionManager() {
		
		DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
		return webSessionManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/test", "anon");
		filterChainDefinitionMap.put(adminPath+"/**", "user");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
	
}
