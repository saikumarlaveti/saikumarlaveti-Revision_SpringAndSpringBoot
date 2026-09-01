package com.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp/api")
public class AnnotationsControllers {

	@GetMapping("/getEmployee")
	public ResponseEntity<String> getStudent(){
		System.out.println("Employee Operations Controller : @GetMapping()");
		return new ResponseEntity<String>("Get Mapping - Fetching all Employee",HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(){
		System.out.println("Employee Operations Controller : @PostMapping()");
		return new ResponseEntity<String>("Post Mapping - Save Employees",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(){
		System.out.println("Employee Operations Controller : @PutMapping()");
		return new ResponseEntity<String>("Put Mapping - Update Employees",HttpStatus.OK);
	}
	
	@PatchMapping("/updateName")
	public ResponseEntity<String> UpdateStudentName(){
		System.out.println("Employee Operations Controller : @PatchMapping()");
		return new ResponseEntity<String>("Patch Mapping - Parial Employees",HttpStatus.OK);
	}
	
	@DeleteMapping("/Delete")
	public ResponseEntity<String> DeleteStudent(){
		System.out.println("Employee Operations Controller : @DeleteMapping()");
		return new ResponseEntity<String>("Delete Mapping - Delete Employees",HttpStatus.OK);
	}
	
}
