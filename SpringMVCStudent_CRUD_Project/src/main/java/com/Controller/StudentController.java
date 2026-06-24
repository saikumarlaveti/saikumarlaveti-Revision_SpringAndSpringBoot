package com.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Student;
import com.Service.StudentService;

@Controller
public class StudentController {
	@Autowired
	public StudentService service;
	@GetMapping("/")  // http://localhost:5052/
	public String homePage() {
		return "home";
	}

	@GetMapping("/add")
	public String showregisterStudentform(@ModelAttribute("student") Student s) {
		s.setCourse("MCA");
		return "register";
	}
	
	@PostMapping("/add")  // http://localhost:5052/add
	public String addStudent(Map<String,Object>map,@ModelAttribute("student") Student std) {
		String result = service.registerStudent(std);
		List<Student> list = service.findAllStudent();
		map.put("resultMsg", result);
		map.put("student", list);
		return "report";
	}
	@GetMapping("/getStudentDetails")  // http://localhost:5052/getStudentDetails
	public String getAllStudent(Map<String,Object> map){
		List<Student> stdList = service.findAllStudent();
		map.put("std",stdList);
		return "report";
	}
	
	@GetMapping("/edit")
	public String getByid(@RequestParam("no")int no,@ModelAttribute("student") Student s) {
		
		Student s1 = service.findById(no);
		BeanUtils.copyProperties(s1, s);
		return "edit";
	}
	
	@PostMapping("/edit")
	public String saveAfterEdit(Map<String,Object> map,@ModelAttribute("student") Student std) {
		String result = service.registerStudent(std);
		List<Student> list = service.findAllStudent();
		map.put("resultMsg", result);
		map.put("student", list);
		return "report";
	}
	
	@GetMapping("/delete")
	public String deleteByid(@RequestParam("no")int no,Map<String,Object> map) {
		
		String s1 = service.deleteStudent(no);
		List<Student> list = service.findAllStudent();
		map.put("resultMsg", s1);
		map.put("student", list);
		return "report";
	}
	
	
	
}
