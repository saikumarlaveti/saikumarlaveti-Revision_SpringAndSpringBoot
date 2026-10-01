package com.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	
	RestTemplate template = new RestTemplate();
	String serviceUrl =
            "http://localhost:8080/SpringRestTemplate_Provider_PathVariables_JsonData_02/api/greet/delete/{id}";


    HttpHeaders headers = new HttpHeaders();
    // Tell Provider that request body is JSON
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    ResponseEntity<String> response = template.exchange(serviceUrl,HttpMethod.DELETE,null,String.class,3);
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());
    System.out.println(response.getStatusCode());
	
}
}