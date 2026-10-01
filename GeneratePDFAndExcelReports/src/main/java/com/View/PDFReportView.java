package com.View;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.Model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_report")
public class PDFReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document doc,
                                    PdfWriter writer,
                                    HttpServletRequest req,
                                    HttpServletResponse res) throws Exception {

        // Set PDF file name
        res.setHeader("Content-Disposition", "attachment; filename=employees.pdf");

        // Get employee list from model
        List<Employee> list = (List<Employee>) map.get("empsList");

        // Title
        Paragraph para = new Paragraph(
                "Employee Report",
                new Font(Font.TIMES_ROMAN, 16, Font.BOLD)
        );

        doc.add(para);
        doc.add(new Paragraph(" "));

        // Table with 5 columns
        Table table = new Table(5);

        // Header row
        table.addCell("ID");
        table.addCell("AGE");
        table.addCell("NAME");
        table.addCell("PHONE");
        table.addCell("EMAIL");

        // Employee data
        for (Employee emp : list) {

            table.addCell(String.valueOf(emp.getId()));
            table.addCell(String.valueOf(emp.getAge()));
            table.addCell(emp.getName());
            table.addCell(emp.getPhoneNumber());
            table.addCell(emp.getEmail());
        }

        // Add table to document
        doc.add(table);
    }
}