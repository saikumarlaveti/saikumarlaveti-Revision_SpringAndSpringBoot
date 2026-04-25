package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.Employee;
import com.service.EmployeeService;

@Controller("controller")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	public List<Employee> showempDetails(int id) throws Exception{
	
	List<Employee> listemp = service.fetchEmployeeDetailsbyId(id);
		return listemp;
	}
	
	
	
	
}
