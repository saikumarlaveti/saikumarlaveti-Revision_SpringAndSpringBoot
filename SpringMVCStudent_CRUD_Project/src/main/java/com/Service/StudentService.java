package com.Service;

import java.util.List;

import com.Entity.Student;

public interface StudentService {
	
	public String saveStudent(Student s);
	
	public List<Student> findAllStudent();

}
