package com.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationController {

	@Value("${Name}")
	public String username;
	@Value("${PhoneNo}")
	public String dbpassword;
	@Value("${Email}")
	public String email;
	
	@GetMapping("/show")
	public ResponseEntity<String> showDetails(){
		return new ResponseEntity<String> ("/nUser name :" + username + " " + "/nEmail :" + email + "/nPassword :" + dbpassword,HttpStatus.OK);
	}
	
}
