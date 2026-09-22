package com.Client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerClient {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		ServiceInstance instance = client.choose("BillingService");
		URI uri  = instance.getUri();
		System.out.println("URI" + uri);
		String url = uri.toString()+"/billing/api/info";
		System.out.println("URL " + url);
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		String responseContent = response.getBody();
		System.out.println("responeContent " +responseContent);
		return responseContent;
	}
}
