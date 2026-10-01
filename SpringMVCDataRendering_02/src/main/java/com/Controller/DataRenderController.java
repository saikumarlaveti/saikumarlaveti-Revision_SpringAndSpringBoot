package com.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Entity.Employee;
import com.Service.Student;

@Controller
public class DataRenderController {
	
	@Autowired
	public Student std;

	//a.passing simple values from controll class to view comps
	@RequestMapping("/wish")  // http://localhost:5051/wish
	public String wishMessage(Map<String,Object> map) {
		String result = std.getStudentName("Saikumar Laveti");
		map.put("name", result);
		map.put("age", 26);
		return "StudentName";
	}
	
	//b.passing arrays,collections values from controll class to view comps
	
	@RequestMapping("/student")  // http://localhost:5051/student
	public String studentDetails(Map<String,Object> map) {
		map.put("favColors",new String[]{ "Black","Green","Orange"});
		map.put("StudentNames",List.of("Saikumar","Santosh Kumar","Naresh"));
		map.put("phoneNumber", Set.of("7995663051","8501905061"));
		map.put("Ids", Map.of("aadhar card",123456789));
		
		return "details";
		
	}
	
	//c.passing model class obj from controll class to view comps
	
	@GetMapping("/Employee")  //http://localhost:5051/Employee
	public String student(Map<String,Object> map) {
		Employee emp = new Employee(1,"Saikumar",26);
		map.put("EmpDetail", emp);
		return "empDetails";
	}
	
	//d.passing collections model class  obj from controll class to view comps
	
	@GetMapping("/Employee2") // http://localhost:5051/Employee2
	public String employee(Map<String,Object> map) {
		List<Employee> emp = List.of(new Employee(1,"Saikumar",26),
				new Employee(2,"Santosh",26));
		map.put("Emps", emp);
		return "Employees";
	}
	

}
