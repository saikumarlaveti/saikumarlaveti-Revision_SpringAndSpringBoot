package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Model.Employee;
import com.Repository.EmployeeRepo;

@Component
public class EmployeeIMPL implements EmployeeService {
	
	@Autowired
	public EmployeeRepo repo;

	@Override
	public List<Employee> getEmployeeDetails() {
		return repo.findAll();
	}

}
