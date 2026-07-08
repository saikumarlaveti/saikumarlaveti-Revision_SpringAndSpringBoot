package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerOperatonsController {
//http://localhost:5050/
	 @GetMapping("/")
	    public String showHome() {
	        return "home";
	    }

	    @GetMapping("/register")
	    public String showRegister() {
	        return "customer_register";
	    }
	
	
}
