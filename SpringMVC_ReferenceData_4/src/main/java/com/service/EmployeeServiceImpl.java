package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<String> getCountries() {

        return Arrays.asList(
                "India",
                "USA",
                "Canada",
                "Australia",
                "Japan");
    }

}