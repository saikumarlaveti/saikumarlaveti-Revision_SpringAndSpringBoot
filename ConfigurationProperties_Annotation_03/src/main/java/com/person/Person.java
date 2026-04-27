package com.person;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.student.StudentDetails;

import lombok.Data;

@Component("per")
@Data
@ConfigurationProperties("per.info")
public class Person {
	
	private int id;
	private String name;
	private String[] favColors;
	private List<String> studies;
	private Set<String> phoneNumbers;
	private Map<String,Integer> idProofs;
	
	private StudentDetails std;
	
	

}
