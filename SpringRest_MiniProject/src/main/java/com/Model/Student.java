package com.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="Student")
@Entity
public class Student {
	
	@Id
	public int id;
	@Column(name="name",length=20)
	public String name;
	public String course;
	public Long moblieNo;

}
