package com.Service;

import java.util.List;

import com.Entity.Student;

public interface StudentService {
	
	public String registerStudent(Student s);
	
	public List<Student> findAllStudent();

}
