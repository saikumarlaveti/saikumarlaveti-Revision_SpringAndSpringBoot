package com.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Model.Employee;
import com.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	@GetMapping("/")
	public String homePage() {
		return "welcome";
	}

	@GetMapping("/report")
	public String report(Map<String,Object> map,@RequestParam("type") String type) {
		
		List<Employee> emplist = service.getEmployeeDetails();
		map.put("emp", emplist);
		
		if(type.equals("excel")) {
			return "excel_report";
		}
		else {
			return "pdf_report";
		}
	}
}
