package com.Service;

import java.util.List;
import java.util.Optional;

import com.Entity.Student;

public interface StudentServices {

	public String saveStudent(Student std);
	
	public String saveAllStudent(List<Student> std);
	
	public Optional<Student> findById(int id);
	
	public List<Student> findByAllStudent(List<Integer> ids);
	
	public long countNumberOfStudent();
	
	public boolean isStudentExists(int id);
	
	public boolean deleteStudentById(int id);
	
	public boolean deleteAllStudentsByIds(List<Integer> ids);

	public boolean deleteAllStudents();
	
	public String updateStudent(int id,String name);
}

