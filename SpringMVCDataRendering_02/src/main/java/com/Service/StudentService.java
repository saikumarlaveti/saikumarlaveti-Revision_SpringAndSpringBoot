package com.Service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements Student {

	@Override
	public String getStudentName(String name) {
		return "Hi , This is " + name;
		
	}

}
