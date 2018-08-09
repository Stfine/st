package com.xiaoxiang.cabbage.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {
	
	@Scheduled(cron="0/5 * * * * ? ")
	public void execute() {
		System.out.println("定时任务，启动成功");
	}
}
