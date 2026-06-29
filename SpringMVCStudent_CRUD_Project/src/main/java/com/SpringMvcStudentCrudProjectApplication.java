package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:Validation.properties")
public class SpringMvcStudentCrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcStudentCrudProjectApplication.class, args);
	}

}
