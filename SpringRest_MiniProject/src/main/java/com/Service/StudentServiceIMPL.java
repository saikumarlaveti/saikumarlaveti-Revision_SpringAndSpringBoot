package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Model.Student;
import com.Repository.StudentRepository;

@Service("studentService")
public class StudentServiceIMPL implements StudentService {

	@Autowired
	public  StudentRepository service;
	
	@Override
	public String saveStudent(Student s) {
		System.out.println("Reached Save Student Method()");
		Student std = service.save(s);
		return "Student Details saved successfully with Id value "+std.id;
	}

	@Override
	public Optional<Student> getStudent(int id) {
		System.out.println("Reached getStudent  Method()");
		Optional<Student> s = service.findById(id);
		return s;
	}

}
