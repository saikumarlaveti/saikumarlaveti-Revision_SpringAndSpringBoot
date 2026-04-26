package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.student.Employee;
import com.student.StudentDetails;

@SpringBootApplication
public class ConfigurationPropertiesAnnotation03Application {

	public static void main(String[] args) {
		ApplicationContext con=  SpringApplication.run(ConfigurationPropertiesAnnotation03Application.class, args);
		StudentDetails std = con.getBean("stdOBJ", StudentDetails.class);
		System.out.println("Student INFO " + std);
		
		
//		ApplicationContext con1=  SpringApplication.run(ConfigurationPropertiesAnnotation03Application.class, args);
		Employee emp = con.getBean("EmployeeObj", Employee.class);
		System.out.println("Employee INFO " + emp);
	}

}
