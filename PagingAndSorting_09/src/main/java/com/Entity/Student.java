package com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Student")
@Data
public class Student {

	@Id
	@Column(name="Id",length=10)
	public int id;
	
	public String name ;
	
	public int age;
	
	public String email;
}
