package com.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WishMessageConsumerRunner implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;

	@Value("${service.url}")
	private String serviceurl;

	@Override
	public void run(String... args) throws Exception {
		String serviceurl = "http://localhost:8080/SpringRestTemplate_Provider_01/api/greet/wish";
		ResponseEntity<String> respone = template.getForEntity(serviceurl,String.class);
		System.out.println(respone.getBody());
		System.out.println(respone.getStatusCode());
		System.out.println(respone.getHeaders());
	
	}
}
