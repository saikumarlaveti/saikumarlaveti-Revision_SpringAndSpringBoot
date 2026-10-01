package com.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Billing/api")
public class BillingController {
	
	@Value("${server.port}")
	public int port;
	
	@Value("${spring.application.name}:${random.value}")
	public String instanceId;

	@GetMapping("/info")
	public ResponseEntity<String> fetchBill(){
		System.out.println("BillingService" + port);
		return new ResponseEntity<String>("Final Bill Amount-5000" + 
		instanceId+"@Port - " + port,HttpStatus.OK);
				
		
	}
}
