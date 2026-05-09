package com.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.Repository.StudentRepo;

@Service("StudentService")
public class StudentServiceIMPL implements StudentService {
	
	@Autowired
	private StudentRepo repo;

	@Override
	public String registerStudent(Student student) {
		System.out.println("InMemory Proxy class Name ::" + repo.getClass()+"------------"
				+ Arrays.toString(repo.getClass().getInterfaces()));
		
		System.out.println("Before Saving " +repo);
		Student std = repo.save(student);
		System.out.println("After Saving "+ std);
		return "Student registered successfully " + std.id;
	}

	@Override
	public long countNumberOfStudent() {
		return repo.count();
	}
	

}
