package com.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	@Query("from Student where course in(:course1,:course2) order by course desc")
	public List<Student> getByCourses(@Param("course1") String course1,@Param("course2") String course2);

}
