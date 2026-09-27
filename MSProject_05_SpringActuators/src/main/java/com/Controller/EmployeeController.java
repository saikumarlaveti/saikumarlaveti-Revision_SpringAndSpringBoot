package com.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("/show")
	public ResponseEntity<String> showDetails(){
		return new ResponseEntity<String> ("This is Spring Actuator :: ",HttpStatus.OK);
	}
	
}

