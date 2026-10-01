package com.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BillingController {
	@Autowired
	private RestTemplate template;
	Logger logger = LoggerFactory.getLogger(BillingController.class);
	
	@GetMapping("/billing")
	public String Billing() {
		logger.info("welcome to billing module");
		String resp = template.getForObject("http://localhost:9093/payment", String.class);
		logger.info("Back to Billing module");
		return resp;
	}
}
