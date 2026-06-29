package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="com/validator/Validation.properties")
public class SpringMvcDataBinding03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDataBinding03Application.class, args);
	}

}
