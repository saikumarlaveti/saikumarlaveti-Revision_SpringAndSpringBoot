package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.person.Person;
import com.student.Employee;
import com.student.StudentDetails;

@SpringBootApplication
public class ConfigurationPropertiesAnnotation03Application {

	public static void main(String[] args) {
		ApplicationContext con=  SpringApplication.run(ConfigurationPropertiesAnnotation03Application.class, args);
		StudentDetails std = con.getBean("stdOBJ", StudentDetails.class);
		System.out.println("Student INFO " + std);
		
		Employee emp = con.getBean("EmployeeObj", Employee.class);
		System.out.println("Employee INFO " + emp);
		
		Person per = con.getBean("per",Person.class);
		System.out.println("Person INFO " + per);
	}

}
