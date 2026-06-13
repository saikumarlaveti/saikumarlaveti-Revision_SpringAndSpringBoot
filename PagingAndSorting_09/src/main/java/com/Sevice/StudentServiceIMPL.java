package com.Sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.Repository.StudentRepo;

@Service()
public class StudentServiceIMPL implements StudentService {
	
	@Autowired
	public StudentRepo repo;
	@Override
	public Iterable<Student> displayStudentByOrder(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		return repo.findAll(sort);
	}
	@Override
	public Page<Student> generateReport(int pageNo, int pageSize, boolean asc, String... properties) {
		PageRequest pageable = PageRequest.of(pageNo, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC,properties));
		Page<Student> page = repo.findAll(pageable);
		return page;
	}

}
