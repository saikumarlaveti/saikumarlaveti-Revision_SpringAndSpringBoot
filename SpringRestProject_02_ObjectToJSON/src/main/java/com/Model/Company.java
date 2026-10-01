package com.Model;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Company {
	public int id;
	public String companyName;
	public String location;
}
