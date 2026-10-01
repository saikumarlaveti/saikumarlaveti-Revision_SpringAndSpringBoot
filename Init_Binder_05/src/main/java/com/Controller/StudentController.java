package com.Controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.Entity.Student;

@Controller
public class StudentController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String showForm(@ModelAttribute("student") Student student) {
    	System.out.println("Register Clicked in the frontend::");
        return "register";
    }
// 
    @PostMapping("/register")
    public String register(@ModelAttribute("student") Student student) {
    	System.out.println("Automatically call post method..");

        System.out.println(student);

        return "result";
    }

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {

        System.out.println("InitBinder Executed");

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy");

        binder.registerCustomEditor(
                java.util.Date.class,
                new CustomDateEditor(sdf, true));
    }

}
