package com.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student;

@RestController
@RequestMapping("/api/greet")
public class WishMessageContoller {
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> wishMessage(@PathVariable("id")int id,@PathVariable("name")String name){
		return new ResponseEntity<String>(id + " Good Morning " + name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String>StudentDetails(@RequestBody Student std){
		System.out.println("StudentDetails Method ::");
		return new ResponseEntity<String>("Student Details"+std.toString(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		System.out.println("delete student method ::");
		return new ResponseEntity<String>("delete student "+ id ,HttpStatus.OK);
	}
}
