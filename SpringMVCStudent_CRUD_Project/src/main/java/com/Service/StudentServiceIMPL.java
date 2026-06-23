package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.Repository.StudentRepository;

@Service("StudentService")
public class StudentServiceIMPL implements StudentService {
	
	@Autowired
	public StudentRepository student;

	@Override
	public String registerStudent(Student s) {
		int id = student.save(s).getId();
		return "Student successfully registered with Id" + id;
		
	}

	@Override
	public List<Student> findAllStudent() {
		return student.findAll();
	}

}
