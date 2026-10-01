package com.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Model.Company;

@RestController
@RequestMapping("/company/details")
public class CompanyController {

	@GetMapping("/showCompanyDetails")
	public ResponseEntity<Company> showCompanyDetails(){
		Company com = new Company(1,"Google","Hyderabad");
		return new ResponseEntity<Company>(com,HttpStatus.OK);
	}
}
