package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClientInterface.BillingServiceConsumerClient;

@RequestMapping("/shopping")
@RestController
public class ShoppingController {
	
	@Autowired
	public BillingServiceConsumerClient client;
	
	@GetMapping("/cart")
	public ResponseEntity<String> ShoppingWithCustomer() {
		System.out.println("ShoppingWithCustomer");
		ResponseEntity<String> result=client.fetchBill();
		return new ResponseEntity<String>("Shopping Service items Hard Disk :: "+result,HttpStatus.OK);
	}

}
