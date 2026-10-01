package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Exception.StudentNotFoundException;
import com.Model.Student;
import com.Repository.StudentRepository;

@Service("studentService")
public class StudentServiceIMPL implements StudentService {

	@Autowired
	public  StudentRepository service;
	
	@Override
	public String saveStudent(Student s) {
		System.out.println("Reached Save Student Method()");
		Student std = service.save(s);
		return "Student Details saved successfully with Id value "+std.id;
	}

	@Override
	public Student getStudent(int id) {
	    System.out.println("Reached getStudent Method()");

	    Optional<Student> s = service.findById(id);

	    if (s.isPresent()) {
	        return s.get();
	    }

	    throw new StudentNotFoundException("Student Not Found with ID: " + id);
	}

	@Override
	public Iterable<Student> getAllStudents() {
		Iterable<Student> it=service.findAll();
		List<Student> list = (List<Student>)it;
		return list;
	}

	@Override
	public Student getStudentById(int id) {

	    Optional<Student> opt = service.findById(id);

	    if (opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new StudentNotFoundException("Student Not Found with ID: " + id);
	    }
	}

	@Override
	public List<Student> getBycourses(String Course1, String Course2) {
		List<Student> list = service.getByCourses(Course1, Course2);
		return list;
	}

	@Override
	public String updateStudentName(Student std) {
		Optional<Student> opt = service.findById(std.getId());
		if(opt.isPresent()) {
			service.save(std);
			return "Student Name updated";
		}
		else {
			throw new StudentNotFoundException("Student Not Found");
		}
	}

	@Override
	public String deleteStudent(Student std) {
		Optional<Student> opt = service.findById(std.getId());
		if(opt.isPresent()) {
			service.delete(std);
			return "Student deleted";
		}
		else {
		throw new StudentNotFoundException("Student Not Found");
	}
	}

	@Override
	public String studentPhoneNumberUpdate(int id, Long phoneNumber) {
		Optional<Student> opt = service.findById(id);
		if(opt.isPresent()) {
			Student student = opt.get();
			student.setMoblieNo(phoneNumber);
			service.save(student);
			return "Student update successfully";
		}
		else {
		throw new StudentNotFoundException("Student Not Found");
	}
	}

}
