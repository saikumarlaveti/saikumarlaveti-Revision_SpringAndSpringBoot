package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	 @Autowired
	    private Environment env;
    @Override
    public List<String> getCountries() {

        return Arrays.asList(
                "India",
                "USA",
                "Canada",
                "Australia",
                "Japan");
    }

    @Override
    public List<String> getStatesByCountry(String country) {

        String value = env.getProperty(country);

        return Arrays.asList(value.split(","));
    }
}