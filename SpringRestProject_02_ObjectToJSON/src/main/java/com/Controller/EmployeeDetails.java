package com.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeDetails {

	@GetMapping("/showDetailsInJSON")
	public ResponseEntity<Employee> showDetailsInJSON(){
		System.out.println("showDetailsInJSON()");
		List<String> favcolors = Arrays.asList("Black","Green","Red");
		Map<String,String> familyDetail = new HashMap<String,String>();
		familyDetail.put("Father", "AppalaNaidu Laveti");
		familyDetail.put("Mother", "Rajeswari Laveti");
		familyDetail.put("Brother", "Santoshkumar Laveti");
		familyDetail.put("SisterInLaw","Hema");
		familyDetail.put("Me","Saikumar Laveti");
		int[] phonenumbers = new int[2];
		phonenumbers[0] = 850190;
		phonenumbers[1] = 799566;
		
		Employee emp = new Employee(1,"Saikumar Laveti","02-07-2025",
				"Software Engineer",favcolors,familyDetail,phonenumbers);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/showDetailsInXML")
	public ResponseEntity<Employee> showDetailsInXML(){
		System.out.println("showDetailsInXML()");
		List<String> favcolors = Arrays.asList("Black","Green","Red");
		Map<String,String> familyDetail = new HashMap<String,String>();
		familyDetail.put("Father", "AppalaNaidu Laveti");
		familyDetail.put("Mother", "Rajeswari Laveti");
		familyDetail.put("Brother", "Santoshkumar Laveti");
		familyDetail.put("SisterInLaw","Hema");
		familyDetail.put("Me","Saikumar Laveti");
		int[] phonenumbers = new int[2];
		phonenumbers[0] = 850190;
		phonenumbers[1] = 799566;
		
		Employee emp = new Employee(1,"Saikumar Laveti","02-07-2025",
				"Software Engineer",favcolors,familyDetail,phonenumbers);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	//http://localhost:8081/RestApp/emp/inpubXMLAndOutputJSON
	@GetMapping("/inpubXMLAndOutputJSON")
	public ResponseEntity<Employee> inpubXMLAndOutputJSON(@RequestBody Employee emp){
		System.out.println("inpubXMLAndOutputJSON()");
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	//http://localhost:8081/RestApp/emp/report?id=1&name=saikumar
	@GetMapping("/report")
	public ResponseEntity<String> report(@RequestParam("id") int id,
										 @RequestParam("name") String name){
		System.out.println("Requestt Params");
		System.out.println("Employee Id : " + id);
		System.out.println("Employee Name : +" + name);
		return new ResponseEntity<String>("Student Id :" +  id +
				 ",\n Student Name : "+ name,HttpStatus.OK);
	}
	
	//http://localhost:8081/RestApp/emp/pathVariablesReport/3/SaikumarLaveti
	@GetMapping("/pathVariablesReport/{id}/{name}")
	public ResponseEntity<String> pathVariablesReport(@PathVariable int id,
										 @PathVariable String name){
		System.out.println("Path Variables");
		System.out.println("Employee Id : " + id);
		System.out.println("Employee Name : +" + name);
		return new ResponseEntity<String>("Student Id :" +  id +
				 ",\n Student Name : "+ name,HttpStatus.OK);
	}
}
