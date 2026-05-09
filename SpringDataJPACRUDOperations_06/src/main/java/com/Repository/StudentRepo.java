package com.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{

}
