package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Reference Data
    @ModelAttribute("countriesInfo")
    public List<String> populateCountries() {

        return service.getCountries();
    }

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("emp", new Employee());

        return "employee_register";
    }

    @PostMapping("/register")
    public String registerEmployee(
            @ModelAttribute("emp") Employee emp,
            Model model) {

        model.addAttribute("message", "Registration Successful");

        return "result";
    }
    
    @PostMapping("/statesurl")
    public String showStates(

            @RequestParam String country,

            @ModelAttribute("emp") Employee emp,

            Model model){

        List<String> states =
                service.getStatesByCountry(country);

        model.addAttribute("statesInfo",states);

        return "employee_register";
    }

}