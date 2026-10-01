package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/wish")
	public String wishController(String name) {
		System.out.println("wishController Hitted :: ");
		return "welcome";
	}
}
