package com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.Entity.Student;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Form Validation");
		
		Student student = (Student)target;
		if(student.getId() == null) {
		    errors.rejectValue("id", "stdId.required");
		}

		if(student.getName() == null || student.getName().isBlank()) {
		    errors.rejectValue("name", "stdname.required");
		}

		if(student.getName() != null && student.getName().length() > 10) {
		    errors.rejectValue("name", "stdname.maxlength");
		}

		if(student.getAge() < 24 || student.getAge() > 35) {
		    errors.rejectValue("age", "stdAge.range");
		}
		
	}

}
