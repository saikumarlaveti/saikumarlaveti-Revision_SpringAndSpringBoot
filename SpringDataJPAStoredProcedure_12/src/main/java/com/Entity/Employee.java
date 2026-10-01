package com.Entity;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employee")
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert()
public class Employee {
	@Id
	@Column(name="Id",length=20)
	public Integer id;
	public String name;
	public Integer age;
	public Long phoneNumber;
	public String email;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "]";
	}
}
