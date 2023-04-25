package com.toppertutors.pdfExpoter;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.toppertutors.entity.Students;

public class StudentPDFExpoter {
	 private List<Students> liststudents;
	 
	 
     
	    public StudentPDFExpoter(List<Students> listStudents) {
	        this.liststudents= listStudents;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("ID", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Name", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Address", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Number", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Teacher Name", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("GaurdianName", font));
	        table.addCell(cell); 
	       
	        cell.setPhrase(new Phrase("Subject", font));
	        table.addCell(cell); 
	        cell.setPhrase(new Phrase("teachersId", font));
	        table.addCell(cell); 
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (Students student : liststudents) {
	            table.addCell(String.valueOf(student.getId()));
	            table.addCell(student.getName());
	            table.addCell(student.getAddress());
	            table.addCell(student.getNum());
	            table.addCell(student.getGaurdianName());
	            table.addCell(student.getSubject());
	            table.addCell(student.getTeacher());
	           
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Students", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(7);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 3.5f,3.5f,3.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
	}


