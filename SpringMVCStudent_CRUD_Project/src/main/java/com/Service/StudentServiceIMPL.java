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
	public String saveStudent(Student s) {
		student.save(s);
		return "Student successfully registered";
		
	}

	@Override
	public List<Student> findAllStudent() {
		return student.findAll();
	}

}
