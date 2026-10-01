package com.Sevice;



import org.springframework.data.domain.Page;

import com.Entity.Student;

public interface StudentService {

	public Iterable<Student> displayStudentByOrder(boolean asc,String... properties);
	
	public Page<Student> generateReport(int pageNo,int pageSize,boolean asc,String... properties);
}
