package com.Runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Entity.Employee;
import com.Service.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	public EmployeeService service;
	@Override
	
	public void run(String... args) throws Exception {
		
		//1.Save Employee
		Employee emp1  = new Employee();
		emp1.setId(1);
		emp1.setName("Saikumar Laveti");
		emp1.setAge(23);
		emp1.setPhoneNumber("7995663051");
		String result = service.registerEmployee(emp1);
		
		Employee emp2  = new Employee();
		emp2.setId(2);
		emp2.setName("SantoshKumar Laveti");
		emp2.setAge(26);
		emp2.setPhoneNumber("799566");
		String result1 = service.registerEmployee(emp2);
		
		System.out.println("==================saving Employee===============================");
		System.out.println(result);
		System.out.println(result1);
		
		//retrieve Employee details
		System.out.println("===============getNameUsingId===================================");
		Optional<Employee> details = service.getNameUsingId(1);		
		if(!details.isEmpty()) {
		System.out.println(details.get());
		}
		else {
			System.out.println("Record not found");
		}
		//3.check employee
		System.out.println("===============checkEmployeeExistingOrNot========================");
		boolean res1 = service.checkEmployeeExistingOrnot(1);
		System.out.println("Is Employee Exists : " + res1);
		
		
		//4.retrive all employee
		System.out.println("===============displayAllEmplyees=================================");
		Iterable<Employee> res2 = service.allEmployees();
		System.out.println(res2);
		
		//5.number of employees
		System.out.println("===============NumberOfEmployees===================================");
		long numberOfEmployee = service.numberOfEmployees();
		System.out.println(numberOfEmployee);
		
		System.out.println("===============Saving Multiple Employee===================================");
		String emp = service.registerAllEmployee(List.of(new Employee(5,"Test123",26,"799566"),(new Employee(6,"Test143",28,"850190"))
				));
		System.out.println(emp);
		
		
		
		
	}

}
