package com.Service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("Task1")
public class Task1 {
	
//	@Scheduled(initialDelay = 10000,fixedDelay = 3000)
//	public void Todo() {
//		System.out.println("Hi Saikumar Laveti : " + new Date());
//	}

	@Scheduled(cron="10 * * * * *")
	public void Todo() {
		System.out.println("Hi Saikumar Laveti : " + new Date());
	}
}
