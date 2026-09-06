package com.Model;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	public int id;
	public String name;
	public String dataOfJoining;
	public String role;
	public List<String> favColors;
	public Map<String,String> familyDetails;
	public int[] phoneNumbers;
	
	
}
