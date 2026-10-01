package com.Repository;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Employee;

import jakarta.persistence.Id;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//select *from Employee where name='Saikumar Laveti';
	public List<Employee> findByNameEquals(String name);
	
	//select *from Employee where name='Chinna' and age = 18;
	public List<Employee> findByNameAndAge(String name,int age);
	
	//select *From employee where name='naveen' or email='naveenlaveti@gmail.com';
	public List<Employee> findByNameOrEmail(String name,String email);
	
	//select *From Employee where age between 15 and 20;
	public List<Employee> findByAgeBetween(int age,int age_01);
	
	//select *from Employee where age<18;
	public List<Employee> findByAgeLessThan(int age);
	
	//select *from Employee where age<=18;
	public List<Employee> findByAgeLessThanEqual(int age);
	
	//select *from Employee where id>15;
	public List<Employee> findByIdGreaterThan(int id);
	
	//select *from Employee where id>=20;
	public List<Employee> findByIdGreaterThanEqual(int id);
	
	//select *from Employee where id>=18;
	public List<Employee> findByIdAfter(int id);
	
	//select *from Employee where id<2;
	public List<Employee> findByIdBefore(int id);
	
	//select *from Employee where age is null
	public List<Employee> findByAgeIsNull();
	
	//select *from Employee where  age is notnull
	public List<Employee> findByAgeIsNotNull();
	
//	public List<Employee> findByAgeNotNull();
	
	//select *From employee where name like "%Sai%";
	public List<Employee> findByNameLike(String name);
	
	//select *From employee where name not like "%Sai%";
	public List<Employee> findByNameNotLike(String name);
	
	public List<Employee> findByNameStartingWith(String name);
	//SELECT * FROM employee WHERE name LIKE '%kumar';
	public List<Employee> findByNameEndingWith(String name);
//	same like operator
//	public List<Employee> findByNameContaining(String name);
//	
	public List<Employee> findAllByOrderByAgeAsc();
//	
//	public List<Employee> findByNameNot(String name);
//	
	public List<Employee> findByIdIn(List<Integer> ids);
//	
//	public List<Employee> findByIdNotIn(ArrayList<Id> ids);
//	
//	public List<Employee> findByActiveTrue();
//	
//	public List<Employee> findByActiveFalse();
//	
//	public List<Employee> findByNameIgnoreCase();

}
