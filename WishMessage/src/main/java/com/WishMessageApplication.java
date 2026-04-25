package com;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sl.WishMessageGenerator;
@SpringBootApplication
public class WishMessageApplication {

	@Bean(name="cal")
	public Calendar calendar() {
		return Calendar.getInstance();
	}
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context= SpringApplication.run(WishMessageApplication.class, args);
		WishMessageGenerator generator = context.getBean("wishObject",WishMessageGenerator.class);
		String Result = generator.GenerateWishMessage("Saikumar");
		System.out.println(Result);
		
	//	(ConfigurableApplicationContext) ctx).close();
				
				
				
				
				
				
	}
}
