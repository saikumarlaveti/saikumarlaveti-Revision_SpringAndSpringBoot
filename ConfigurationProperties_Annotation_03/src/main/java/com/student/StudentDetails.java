package com.student;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("stdOBJ")
@Setter
@ConfigurationProperties("student.info")
public class StudentDetails {

	private int id;
	private String name;
	private String gender;
	
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
	
}
