package com.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.Repository.StudentRepository;

@Service
public class StudentServiceIMPL implements StudentServices {

	@Autowired
	private StudentRepository repo;
	@Override
	public String saveStudent(Student std) {
		Student student = repo.save(std);
		return "Student Registeration Successfully " + student.getId();
	}

	@Override
	public String saveAllStudent(List<Student> std) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> findById(int id) {
		Optional<Student>std = repo.findById(id);
		return std;
	}

	@Override
	public List<Student> findByAllStudent(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countNumberOfStudent() {
		long result  =  repo.count();
		return result;
	}

	@Override
	public boolean isStudentExists(int id) {		
		return repo.existsById(id);
	}

	@Override
	public boolean deleteStudentById(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);}
		else {
			System.out.println("Student is not found");
		}
		return false;
	}

	@Override
	public boolean deleteAllStudentsByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllStudents() {
		 repo.deleteAll();
		 return true;
		
	}

	@Override
	public String updateStudent(int id,String name) {
		Optional<Student> std = repo.findById(id);
		if(std.isPresent()) {
			Student std1 = std.get();
			std1.setName(name);
			repo.save(std1);
			return "Student name updated successfully";
		}
		else {
			return "Student not updated";
		}
		
	}

}
