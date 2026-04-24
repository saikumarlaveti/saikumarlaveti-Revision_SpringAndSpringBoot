package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Employee;



@Repository
public class EmployeeDAOImpL implements EmployeeDAO {

    // SQL Query
    private static final String Emp_Query =
            "SELECT id,name FROM employee WHERE id IN (?) ORDER BY id";

    @Autowired
    private DataSource ds; // Auto-configured DataSource

    @Override
    public List<Employee> getEmpsbyId(int id) throws Exception {

        List<Employee> list = new ArrayList<>();

        // try-with-resources (auto closes resources)
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(Emp_Query)) {

            // set values
            ps.setInt(1, id);
         
            // execute query
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));

                    list.add(emp);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return list;
    }
}