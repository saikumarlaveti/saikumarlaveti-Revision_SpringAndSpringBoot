package com.Service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.Model.Student;

public interface StudentService {
	
	public String saveStudent(Student s);
	public Optional<Student> getStudent(int id);

}
