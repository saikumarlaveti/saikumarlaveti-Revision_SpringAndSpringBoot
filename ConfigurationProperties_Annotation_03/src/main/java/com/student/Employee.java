package com.student;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("EmployeeObj")
@Setter
@ConfigurationProperties("emp.info")
public class Employee {

	private int id;
	private String name;
	@Override
	public String toString() {
		return "Employee [empId=" + id + ", name=" + name + "]";
	}
	
}
