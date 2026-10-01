package com.Controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageApi")
public class WishController {
	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		LocalDateTime ldt = LocalDateTime.now();
		String message = null;
		
		int hour = ldt.getHour();
		if(hour<12)
			message = "Good Morning";
		else if(hour<16)
			message = "Good AfterNoon";
		
		else if(hour<20)
			message = "Good Evening";
		else
			message = "Good Night";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(message,HttpStatus.OK);
		return entity;
	}
	

}
