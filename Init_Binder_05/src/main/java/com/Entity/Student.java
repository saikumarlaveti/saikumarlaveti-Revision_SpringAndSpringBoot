package com.Entity;

import java.util.Date;

import lombok.Data;

@Data
public class Student {
	public int id;
	public String name;
	public Date dob = new Date(100,0,01);
}
