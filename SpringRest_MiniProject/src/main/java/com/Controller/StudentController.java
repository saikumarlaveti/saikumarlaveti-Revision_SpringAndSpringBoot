package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Model.Student;
import com.Service.StudentService;


@RestController
@RequestMapping("/StudentApi")
public class StudentController {
	
	@Autowired
	public StudentService studentController;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerStudent(@RequestBody Student s) {
		System.out.println("Reached registerStudent Controller()");
		try {
			System.out.println("ID       : " + s.getId());
		    System.out.println("Name     : " + s.getName());
		    System.out.println("Course   : " + s.getCourse());
		    System.out.println("MobileNo : " + s.getMoblieNo());
		String result = studentController.saveStudent(s);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
