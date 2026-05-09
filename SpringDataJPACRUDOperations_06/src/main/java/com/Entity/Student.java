package com.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Student")
public class Student {

	@Id
	@Column(length=10,name="Id")
	public int id;
	
	public String name;
	
	public int age;
	
	public String phoneNumber;
}
