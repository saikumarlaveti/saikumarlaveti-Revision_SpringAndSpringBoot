package com.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.Entity.Student;
import com.Sevice.StudentService;

@Component
public class StudentRunner implements CommandLineRunner {
	@Autowired
	public StudentService stdservice;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("====================Display Student by order =========================================");
		try {
			Iterable<Student> std = stdservice.displayStudentByOrder(true, "name");
			std.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("=====================Generate Report====================================");
		try {
		Page<Student> page = stdservice.generateReport(1, 1, false, "name");
		System.out.println("page number::" + page.getNumber());
		System.out.println("pages count::" + page.getTotalPages());
		System.out.println("is it first page::" + page.isFirst());
		System.out.println("is it last page::" + page.isLast());
		System.out.println("page Size::" + page.getSize());
		System.out.println("page Elements count::" + page.getNumberOfElements());

		if (!page.isEmpty()) {

		    List<Student> list = page.getContent();
		    list.forEach(System.out::println);

		} else {
		    System.out.println("no page found");
		}
		}

		// try
		catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

	
	
}
