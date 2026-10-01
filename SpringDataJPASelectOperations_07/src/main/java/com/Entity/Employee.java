package com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="Employee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	public int id;
	@Column(length=20)
	public String name;
	public int age;
	public String phoneNumber;
}
