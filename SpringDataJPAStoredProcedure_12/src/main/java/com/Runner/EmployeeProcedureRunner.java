package com.Runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Entity.Employee;
import com.Repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Component
public class EmployeeProcedureRunner implements CommandLineRunner {

	@Autowired
	public EntityManager manager;
	@Override
	public void run(String... args) throws Exception {
		
		StoredProcedureQuery query = manager.createStoredProcedureQuery("insertEmployee",Employee.class);
		
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		
		query.setParameter(1, 3);
		query.setParameter(2, "Saikumar");
		query.setParameter(3, 23);
		query.setParameter(4, "85019051");
		query.setParameter(5, "Saikumar@gmai.com");
		
		query.execute();
		
		
	}

}
