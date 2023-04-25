package com.toppertutors.controller;

import java.io.IOException;
import java.security.Principal;
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
import com.toppertutors.entity.Teachers;
import com.toppertutors.pdfExpoter.UserPDFExporter;
import com.toppertutors.repository.TeachersRepository;
import com.toppertutors.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TeachersController {
	
	@Autowired
	private TeachersRepository TeachersRepository;
	
	@Autowired
	TeacherService teacherService;
	
	
	
	@RequestMapping(value="/addTeacher", method = RequestMethod.GET)

    public String initView(Model model) {
       
        model.addAttribute("teacher", new Teachers());
  System.out.println(TeachersRepository.findAll());
        return "addTeacher";
	}	
	
	@GetMapping("/teachers")
	public String contactList(Model model)
	
	
{
		List<Teachers> teachers = teacherService.findAll();
		 model.addAttribute("teacher", teachers);
        System.out.println(teachers);
    
		return "teacherInfo";
		
	}
	
	
	@PostMapping("/students/saveT-teachers")
	public String submitForm(@Valid @ModelAttribute("teacher") Teachers teacher,Model model, Principal principal
	        ,BindingResult bindingResult) {
		Teachers uo=new Teachers();
		uo.setStudent(teacher.getStudent());

		TeachersRepository.save(uo);
	    System.out.println(teacher);
	    
	     String name=principal.getName();
	    
	    if (bindingResult.hasErrors()) {       
	         
	        return "addTeacher";
	    } 
	    else {
	    	
	    
	        teacherService.save(teacher);
	    }
	  
	    return "redirect:/teachers";
	}
	@RequestMapping("/deleT/{id}")
	public String deleteProduct(@PathVariable(name = "id") long id) {
	    teacherService.delete(id);
	    return "redirect:/teachers";       
	} 
	  @RequestMapping("/search")
	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
		  System.out.println("..............................................");
	        List<Teachers> teachers = teacherService.listAll(keyword);
	        model.addAttribute("teacher", teachers);
	        model.addAttribute("keyword", keyword);
	        model.addAttribute("teachers", teachers);

	   
	        
	         
	        return "teacherInfo";
	    }
	  @RequestMapping("/edi/{id}")
		public String showEditProductPage(@PathVariable("id") long id , Model model,Teachers teacher) {
			 model.addAttribute("teacher", teacher);
		    teacherService.get(id);
		 
		     
		    return "editTeacher";
		}

	  
	  @GetMapping("/teachers/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Teachers> listTeachers = teacherService.listAll();
	         
	        UserPDFExporter exporter = new UserPDFExporter(listTeachers);
	        exporter.export(response);
	         
	    }
	}
	  

