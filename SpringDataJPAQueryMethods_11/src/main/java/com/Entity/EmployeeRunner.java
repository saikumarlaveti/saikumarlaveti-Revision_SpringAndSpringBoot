package com.Entity;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Repository.EmployeeRepository;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	public EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("=== Display List of Employees ===");
		repo.listOfEmployees().forEach(System.out::println);
		
		System.out.println("=== Display List of Employees using SQL Query ===");
		repo.listOfEmployees().forEach(System.out::println);
		
		System.out.println("=== Search by names ===");
		repo.searchByNames("Santosh","Naresh").forEach(System.out::println);
				
		System.out.println("=== searchByNamesPositionalParameters ===");
		repo.searchByNamesPositionalParameters("Santosh","Naresh").forEach(System.out::println);
		
		System.out.println("=== specific columns of the employee table ===");
		repo.listofNamesAndAge().forEach(row->{
			for(Object val:row)
				System.out.print(val + " ");
				System.out.println();
				});
		
		
		System.out.println("=== Aggregate functions ===");
		Object result1[] = (Object[])repo.fetchAggregateDataOnEmp();
		System.out.println("count " + result1[0]);
		System.out.println("min " + result1[1]);
		System.out.println("max " + result1[2]);
		System.out.println("avg " + result1[3]);
		System.out.println("sum " + result1[4]);
		
		
		System.out.println("=== sub queries ===");
		repo.findBymaxage().forEach(System.out::println);
		
		//updating querings
		System.out.println("=== Updating name ===");
		int count = repo.updateName(1);
		System.out.println("No.of rows affected :" + count);
		
		System.out.println("Inserting values :: ");
		int inserted = repo.insertValues(30, "SAIKUMAR", 99,"799566351", "saikumarlaveti@gmail.com");
		System.out.println("inserted rows " + inserted);
		
	}
	
	


}
