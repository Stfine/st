package com.xiaoxiang.cabbage.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

import com.xiaoxiang.cabbate.service.sys.SecurityInitHandle;

@SpringBootApplication
@ComponentScan(basePackages="com.xiaoxiang.**")
@MapperScan(basePackages="com.xiaoxiang.**.mapper")
public class StAdminApplication {

	public static void main(String args[]) {
		SpringApplication.run(StAdminApplication.class, args);
	}
	
	
	@Bean(initMethod="init")
	@Lazy(false)
	public SecurityInitHandle securityInitHandle() {
		
		SecurityInitHandle securityInitHandle = new SecurityInitHandle();
		securityInitHandle.setPack("com.xiaoxiang.cabbage.web.action");
		securityInitHandle.setUserType(1);
		securityInitHandle.setRunInit(true);
		
		return securityInitHandle;
	}
}	
