package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.Entity.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Form Validation");
		
		Student std = (Student)target;
		if(std.getId() == null) {
			errors.rejectValue("stdid", "stdId.required");
		}
		
	}

}
