package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDAO;
import com.model.Employee;

@Service("empservice")
public class EmployeeServiceIMPL implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;
	@Override
	public List<Employee> fetchEmployeeDetailsbyId(int id) throws Exception {
		List<Employee> employee = dao.getEmpsbyId(id);
		return employee;
	}
}
