package com.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        RestTemplate template = new RestTemplate();

        String serviceUrl =
            "http://localhost:8080/SpringRestTemplate_Provider_PathVariables_JsonData_02/api/greet/register";

        HttpHeaders headers = new HttpHeaders();

        // Tell Provider that request body is JSON
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json_body =
            "{ \"id\":1001,\"name\":\"Saikumar\",\"course\":\"SpringBoot\" }";

        HttpEntity<String> request =
            new HttpEntity<String>(json_body, headers);

        ResponseEntity<String> response =template.postForEntity(serviceUrl,request,String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }
}