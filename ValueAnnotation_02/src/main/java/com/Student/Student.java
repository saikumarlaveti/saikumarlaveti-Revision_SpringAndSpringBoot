package com.Student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component("Std")
@Data
@PropertySource("classpath:user.properties")
public class Student {

	//Taking inputs from the Application.properties file
	@Value("${Student.id}")
	private int id;
	@Value("${Student.name}")
	private String name;
	@Value("${Student.Gender}")
	private String Gender;
	
	//hard coding
	@Value("1234567890") 
	private String Number;
	
	@Value("${user.Course}")
	private String Stdcourse;
	
	
}
