package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.Entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
