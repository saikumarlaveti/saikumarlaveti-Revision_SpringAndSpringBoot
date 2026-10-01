package com.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@GetMapping("/payment")
	public String doBilling() {
		logger.info("welcome to the payment module");
		return "payment is done";
	}

}
