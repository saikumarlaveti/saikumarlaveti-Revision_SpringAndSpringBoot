package com.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class WishMessageController {
	//http://localhost:8080/SpringRestTemplate_Provider_01/api/greet/wish  on run server
	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage(){
		return new ResponseEntity<String>("Good Morning Saikumar Laveti",HttpStatus.OK);
	}

	
	
}
