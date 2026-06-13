package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Entity.Employee;

import jakarta.transaction.Transactional;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	/*Selecting all columns*/
	//select *From Employee;
	@Query("from Employee")
	public List<Employee> listOfEmployees();
	
	@Query(value = "select * from Employee",nativeQuery=true)
	public List<Employee> listOfEmployeesusingSQLQuery();
	
	//using named parameters
	@Query("from Employee where name in(:name1,:name2)")
	public List<Employee> searchByNames(String name1,String name2);
	
	@Query("from Employee where name in(?1,?2)")
	public List<Employee> searchByNamesPositionalParameters(String name1,String name2);
	
	
	/*Selecting all specific columns*/
	@Query("select name,age from Employee")
	public List<Object[]> listofNamesAndAge();
	
	@Query("select count(*),min(age),max(age),avg(age),sum(age) from Employee")
	public Object fetchAggregateDataOnEmp();
	
	@Query("from Employee where age=(select max(age) from Employee)")
	public List<Employee> findBymaxage();
	
	@Modifying
	@Query("update Employee set name='testing' where id=?1")
	public int updateName(int id);
	
	
	@Query(value="insert into Employee   (id,name,age,phone_number,email) values(?,?,?,?,?)",nativeQuery=true)
	@Modifying
	public int insertValues(int id,String name,int age ,String phoneNumber,String email);
	
	

}
