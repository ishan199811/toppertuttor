package com.toppertutors.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.DocumentException;
import com.toppertutors.entity.Students;
import com.toppertutors.pdfExpoter.StudentPDFExpoter;
import com.toppertutors.service.StudentService;


@Controller
public class StudentsController {
private static final String Students = null;
@Autowired
StudentService studentService;
	

@RequestMapping(value = "/addStudent", method = RequestMethod.GET)

public String addStudent(Model model) {
   
    model.addAttribute("students", new Students());

    return "addStudent";
}



@RequestMapping(value = "/students", method = RequestMethod.GET)
 public String initView(Model model) {
   List<Students> student=studentService.findAll();
    model.addAttribute("students", student);

    return "studentInfo";
}	


@PostMapping("/saveS")
public String submitForm(@Valid @ModelAttribute("students") Students student,Model model,
        BindingResult bindingResult) {
      System.out.println(student);
     
    if (bindingResult.hasErrors()) {       
         
        return "addStudent";
    } 
    else {
    	
    
        studentService.save(student);
    }
  
    return "redirect:/students";
}

@RequestMapping("/edis/{id}")
public String showEditProductPage(@PathVariable("id") long id , Model model,Students student) {
	 model.addAttribute("students", student);
	
	
    studentService.get(id);
 
     
    return "editStudent";
}

@RequestMapping("/deleTS/{id}")
public String deleteProduct(@PathVariable(name = "id") long id) {
    studentService.delete(id);
   
    return "redirect:/students";       
} 


@RequestMapping("/searchs")
public String viewHomePage(Model model, @Param("keyword") String keyword) {
  System.out.println("..............................................");
    List<Students> student = studentService.listAll(keyword);
    model.addAttribute("students", student);
    model.addAttribute("keyword", keyword);
     
    return "studentInfo";
}
@GetMapping("/students/export/pdf")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
     
    List<Students> listStudent = studentService.listAll();
     
    StudentPDFExpoter exporter = new StudentPDFExpoter(listStudent);
    exporter.export(response);
     
}
}