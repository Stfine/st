package com.xiaoxiang.cabbage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages= {"com.xiaoxiang.**"})
@MapperScan(basePackages="com.xiaoxiang.**.mapper")
@EnableScheduling
@EnableTransactionManagement
public class JobStart {

	public static void main(String args[]) {
		SpringApplication.run(JobStart.class, args);
	}
}
