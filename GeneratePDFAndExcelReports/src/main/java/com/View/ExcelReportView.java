package com.View;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.Model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excel_report")
public class ExcelReportView extends AbstractXlsView {

    private int i = 1;

    @Override
    public void buildExcelDocument(Map<String, Object> map,
                                   Workbook workbook,
                                   HttpServletRequest req,
                                   HttpServletResponse res) throws Exception {

        // Get model attributes data
        List<Employee> list = (List<Employee>) map.get("empsList");

        // Create Excel sheet
        Sheet sheet1 = workbook.createSheet("Employee");

        // Create header row
        Row row1 = sheet1.createRow(0);
        row1.createCell(0).setCellValue("EMPNO");
        row1.createCell(1).setCellValue("EAGE");
        row1.createCell(2).setCellValue("ENAME");
        row1.createCell(3).setCellValue("PHONENUMBER");
        row1.createCell(4).setCellValue("EMAIL");

        // Add employee data
        list.forEach(emp -> {

            // Create a new row
            Row row = sheet1.createRow(i);

            // Add employee details
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getAge());
            row.createCell(2).setCellValue(emp.getName());
            row.createCell(3).setCellValue(emp.getPhoneNumber());
            row.createCell(4).setCellValue(emp.getEmail());
            

            

            i++;
        });
    }
}
