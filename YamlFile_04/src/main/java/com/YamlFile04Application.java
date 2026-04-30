package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.Model.Student;

@SpringBootApplication
public class YamlFile04Application {

	public static void main(String[] args) {
		ApplicationContext con =  SpringApplication.run(YamlFile04Application.class, args);
		Student std = con.getBean(Student.class);
		System.out.println(std);
	}

}
