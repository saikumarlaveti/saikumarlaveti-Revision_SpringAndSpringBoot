package com.Service;

import java.util.List;
import java.util.Optional;

import com.Entity.Student;

public interface StudentService {
	
	public String registerStudent(Student s);
	
	public List<Student> findAllStudent();
	
	public Student findById(int no);
	
	public String editByStudent(Student std);
	
	public String deleteStudent(int id);

}
