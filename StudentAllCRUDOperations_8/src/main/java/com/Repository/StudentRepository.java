package com.Repository;

import org.springframework.data.repository.CrudRepository;


import com.Entity.Student;


public interface StudentRepository extends  CrudRepository<Student, Integer> {

}
