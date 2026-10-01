package com.Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Entity.Student;
import com.Service.StudentServices;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	public StudentServices std;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("==================================Register Student====================================");
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Saikumar Laveti");
		s1.setAge(26);
		s1.setEmail("saikuamrlaveti@gmail.com");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Saikumar Laveti");
		s2.setAge(26);
		s2.setEmail("saikuamrlaveti@gmail.com");
		System.out.println(std.saveStudent(s2));
		
		
		System.out.println("================================== saveAllStudent ====================================");
		System.out.println("================================== findById ====================================");
		Optional<Student> student = std.findById(1);
		if(student.isPresent()) {
			System.out.println(student);
		}
		else {
			System.out.println("No student available for this id :");
		}
		System.out.println("================================== findByAllStudent ====================================");
		System.out.println("================================== countNumberOfStudent ====================================");
		long count = std.countNumberOfStudent();
		System.out.println("Number of Students :: " + count);
		System.out.println("================================== isStudentExists ====================================");
		boolean result = std.isStudentExists(1);
		System.out.println("is Student Exists :: " + result );
/*
		System.out.println("================================== deleteStudentById ====================================");		
		boolean result1 = std.deleteStudentById(1);
		if(!result1) {
			System.out.println("Student deleted Successfully");
		}
		else {
			System.out.println("Student not deleted");
		}
		
		System.out.println("================================== deleteAllStudents ====================================");
		std.deleteAllStudents();
		System.out.println("All Students removed from the database");
*/
		
		System.out.println("==================================Student update ====================================");
		String result2 = std.updateStudent(2,"Sai");
		System.out.println(result2);
		

	}

}
