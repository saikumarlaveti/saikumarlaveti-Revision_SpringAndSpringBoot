package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestTemplateConsumer01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestTemplateConsumer01Application.class, args);
	}

	@Bean(name="template")
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}
