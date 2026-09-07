package com.Repository;


import org.springframework.data.repository.CrudRepository;

import com.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	

}
