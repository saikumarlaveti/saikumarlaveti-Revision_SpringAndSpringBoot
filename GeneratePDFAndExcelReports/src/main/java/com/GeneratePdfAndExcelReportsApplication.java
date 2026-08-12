package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class GeneratePdfAndExcelReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneratePdfAndExcelReportsApplication.class, args);
	}
	
	public ViewResolver createBNVResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}

}
