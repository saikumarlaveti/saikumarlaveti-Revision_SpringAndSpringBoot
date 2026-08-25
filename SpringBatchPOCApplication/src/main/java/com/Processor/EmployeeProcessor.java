package com.Processor;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.Model.Employee;

@Component
	public class EmployeeProcessor
	        implements ItemProcessor<Employee, Employee> {

	    @Override
	    public Employee process(Employee employee) {

	        System.out.println("Processing: " + employee);

	        // Convert name to uppercase
	        employee.setName(employee.getName().toUpperCase());

	        // Increase salary by 10%
	        employee.setSalary(employee.getSalary() * 1.10);

	        return employee;
	    }
}

