package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Employee;
import com.repository.EmployeeRepo;

@Service()
public class EmployeeServiceIMPL implements EmployeeService{

	@Autowired
	public EmployeeRepo repo;
	@Override
	public String registerEmployee(Employee emp) {
		try {
		repo.save(emp);
		return "register successfully";
		}
		catch(Exception e) {
			return "Employee registeration failed";
		}
		
	}
	@Override
	public Optional<Employee> getNameUsingId(int id) {
		Optional<Employee> details= repo.findById(id);
		return details.isEmpty()?Optional.empty():details;
	}
	@Override
	public boolean checkEmployeeExistingOrnot(int id) {
		boolean result = repo.existsById(id);
		return result;
	}
	@Override
	public Iterable<Employee> allEmployees() {
		Iterable<Employee> result = repo.findAll();
		return result;
	}
	@Override
	public long numberOfEmployees() {
		long result = repo.count();
		return result;
	}
	@Override
	public String registerAllEmployee(List<Employee> emplist) {
		Iterable<Employee> emp = repo.saveAll(emplist);
		return "All employees saved Successfully";
	}
	

}
