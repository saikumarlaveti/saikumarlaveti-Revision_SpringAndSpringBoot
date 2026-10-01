package com.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStudentFormPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String showResult(Map<String,Object> map,@ModelAttribute("stud") Student st) {
		System.out.println(st);
		return "show_result";
	}
	

}
