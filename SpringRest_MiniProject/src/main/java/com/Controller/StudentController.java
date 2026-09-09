package com.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/GetAllStudents")
	public ResponseEntity<?> getAllStudent(){
		System.out.println("Reached GetAllStudents Controller");
		try {
			Iterable<Student> list = studentController.getAllStudents();
			return new ResponseEntity<>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStudent(@PathVariable int id){
		System.out.println("Reached GetAllStudent Controller");
		try {
			Optional<Student> list = studentController.getStudentById(id);
			return new ResponseEntity<>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/StudentInfo/{course1}/{course2}")
	public ResponseEntity<?> fetchByCourses(@PathVariable String course1,@PathVariable String course2){
		System.out.println("Reached fetchByCourses Controller");
		try {
			List<Student> list = studentController.getBycourses(course1, course2);
			return new ResponseEntity<>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyStudent(@RequestBody Student std) {

	    try {
	        // use service
	        String msg = studentController.updateStudentName(std);

	        return new ResponseEntity<String>(msg, HttpStatus.OK);
	    }
	    catch(Exception e) {
	        e.printStackTrace();

	        return new ResponseEntity<String>(
	            e.getMessage(),
	            HttpStatus.INTERNAL_SERVER_ERROR
	        );
	    }
	} // method
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestBody Student std){
		try {
			String msg  = studentController.deleteStudent(std);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		 catch(Exception e) {
		        e.printStackTrace();

		        return new ResponseEntity<String>(
		            e.getMessage(),
		            HttpStatus.INTERNAL_SERVER_ERROR
		        );
		    }
	}
	
	@PatchMapping("/updatePhoneNumber/{id}/{newNumber}")
	public ResponseEntity<String> updatePhoneNumber(@PathVariable("id") int id,
			@PathVariable("newNumber") long phoneNumber){
		try {
			String msg  = studentController.studentPhoneNumberUpdate(id, phoneNumber);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		 catch(Exception e) {
		        e.printStackTrace();

		        return new ResponseEntity<String>(
		            e.getMessage(),
		            HttpStatus.INTERNAL_SERVER_ERROR
		        );
		    }
		
	}
	
}
