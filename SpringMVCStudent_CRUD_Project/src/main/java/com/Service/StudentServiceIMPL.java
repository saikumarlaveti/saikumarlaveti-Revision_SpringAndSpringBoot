package com.Service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Student findById(int no) {
		Student s = student.findById(no).get();
		return s;
	}

	@Override
	public String editByStudent(Student std) {
		int id = student.save(std).getId();
		return id +"Student Updated";
	}

	@Override
	public String deleteStudent(int id) {
		student.deleteById(id);
		return "delete Successfully";
	}

}
