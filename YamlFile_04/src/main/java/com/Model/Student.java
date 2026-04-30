package com.Model;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource(value="classpath:studentdetails.yml", factory=YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix="std.info")
@Data
public class Student {
	
	private int id;
	private String name;
	private String gender;
	private String[] favColors;
	private List<String> books;
	private Map<String,String> familyDetails;
	
}
