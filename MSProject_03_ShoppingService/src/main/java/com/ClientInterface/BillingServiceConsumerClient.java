package com.ClientInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BillingService")
public interface BillingServiceConsumerClient {
	@GetMapping("/Billing/api/info")
	public ResponseEntity<String> fetchBill();
}
