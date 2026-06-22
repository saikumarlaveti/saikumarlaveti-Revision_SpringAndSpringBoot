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
	public Integer id;
	
	@Column(length=15)
	public String name;
	
	public String gender;
	
	public Integer age;
	
	public String course;

}
