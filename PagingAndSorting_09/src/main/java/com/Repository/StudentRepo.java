package com.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.Entity.Student;

public interface StudentRepo extends PagingAndSortingRepository<Student, Integer> {

}
