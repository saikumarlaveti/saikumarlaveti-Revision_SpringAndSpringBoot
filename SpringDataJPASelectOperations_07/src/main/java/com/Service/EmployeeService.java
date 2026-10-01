package com.Service;


import java.util.List;
import java.util.Optional;

import com.Entity.Employee;

public interface EmployeeService {

	public String registerEmployee(Employee emp);
	public Optional<Employee> getNameUsingId(int id);
	public boolean checkEmployeeExistingOrnot(int id);
	public Iterable<Employee> allEmployees();
	public long numberOfEmployees();
	public String registerAllEmployee(List<Employee> emplist);
}
