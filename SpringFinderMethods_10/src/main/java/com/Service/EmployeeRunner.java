package com.Service;

import java.util.List;

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
		
		System.out.println("find by id =========");
		repo.findByNameEquals("Saikumar Laveti").forEach(System.out::println);
		
		System.out.println("find by name and age ::");
		repo.findByNameAndAge("chinna", 18).forEach(System.out::println);
		
		System.out.println("find by name or email ::");
		repo.findByNameOrEmail("Naveen", "saikumarlaveti@gmail.com").forEach(System.out::println);;
		
		System.out.println("find by age between ::");
		repo.findByAgeBetween(15,20).forEach(System.out::println);
		
		System.out.println("findByAgeLessThan ::");
		repo.findByAgeLessThan(20).forEach(System.out::println);
		
		System.out.println("findByAgeLessThanEqual ::");
		repo.findByAgeLessThanEqual(18).forEach(System.out::println);
				
		System.out.println("findByIdGreaterThan ::");
		repo.findByIdGreaterThan(15).forEach(System.out::println);
		
		System.out.println("findByIdGreaterThanEquals ::");
		repo.findByIdGreaterThanEqual(20).forEach(System.out::println);
		
		System.out.println("findByIdAfter :: ");
		repo.findByIdAfter(18).forEach(System.out::println); 
		
		System.out.println("findByIdBefore :: ");
		repo.findByIdBefore(2).forEach(System.out::println);
		
		System.out.println("findByAgeIsNull");
		repo.findByAgeIsNull().forEach(System.out::println);
		
		System.out.println("findByAgeIsNotNull");
		repo.findByAgeIsNotNull().forEach(System.out::println);
		
		System.out.println("findByNameLike");
		repo.findByNameLike("%Sai%").forEach(System.out::println);
		
		System.out.println("findByNamenotLike");
		repo.findByNameNotLike("%Sai%").forEach(System.out::println);
		
		System.out.println("findByNameStartingWith");
		repo.findByNameStartingWith("Naresh").forEach(System.out::println);
		
		System.out.println("findByNameEndingWith");
		repo.findByNameEndingWith("Laveti").forEach(System.out::println);
		
		System.out.println("findAllByOrderByAgeAsc");
		repo.findAllByOrderByAgeAsc().forEach(System.out::println);
			
		System.out.println("findByIdIn");
		repo.findByIdIn(List.of(1,2,3,4)).forEach(System.out::println);
		
	}

}
