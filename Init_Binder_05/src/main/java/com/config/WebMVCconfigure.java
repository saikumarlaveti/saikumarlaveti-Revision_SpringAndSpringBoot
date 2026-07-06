package com.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Interceptor.TimeCheckInterceptor;

@Component
public class WebMVCconfigure implements WebMvcConfigurer {
	
	public void addInterceptors(InterceptorRegistry registry) {
	System.out.println("WebMVC configures");
	registry.addInterceptor(new TimeCheckInterceptor());
	}
}
