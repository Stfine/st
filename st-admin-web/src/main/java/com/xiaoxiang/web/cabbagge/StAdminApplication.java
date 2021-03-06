package com.xiaoxiang.web.cabbagge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.xiaoxiang.**")
@MapperScan(basePackages="com.xiaoxiang.**.mapper")
public class StAdminApplication {

	public static void main(String args[]) {
		SpringApplication.run(StAdminApplication.class, args);
	}
}	
