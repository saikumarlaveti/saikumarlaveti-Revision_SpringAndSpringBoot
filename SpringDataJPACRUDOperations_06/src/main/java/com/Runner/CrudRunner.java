package com.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Entity.Student;
import com.Service.StudentService;

@Component
public class CrudRunner implements CommandLineRunner {

	@Autowired
	private StudentService service;

	@Override
	public void run(String... args) throws Exception {
		Student std = new Student();
		std.setId(1);
		std.setName("Saikumar");
		std.setAge(26);
		std.setPhoneNumber("7995663051");
		
		try {
			System.out.println(service.registerStudent(std));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Count number of the Studnets :: ");
		System.out.println(service.countNumberOfStudent());
	}
	
}
