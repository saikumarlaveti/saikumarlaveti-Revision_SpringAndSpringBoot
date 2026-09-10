package com.Service;

import java.util.List;
import java.util.Optional;



import com.Model.Student;

public interface StudentService {
	
	public String saveStudent(Student s);
	public Student getStudent(int id);
	public Iterable<Student> getAllStudents();
	public Student getStudentById(int id);
	public List<Student> getBycourses(String Course1,String Course2);
	public String updateStudentName(Student std);
	public String deleteStudent(Student std);
	public String studentPhoneNumberUpdate(int id,Long phoneNumber);
}
