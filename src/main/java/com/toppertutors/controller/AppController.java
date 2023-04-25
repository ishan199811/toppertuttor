package com.toppertutors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.toppertutors.entity.Contact;




@Controller
public class AppController {
	
	
	
     
	
	@RequestMapping("/index")                           
	public String viewHomePage() {
	 
	     
	    return "index";
	}
	


	@RequestMapping("/detail")                           
	public String viewClientDetail() {
	 
	     
	    return "allinquiry";
	}
	
	
	
	
	
	
	@RequestMapping("/about")
	public String showNewProductPag() {
	   
	     return "about";
	}
	
	@RequestMapping("/service")
	public String showNewProductPage() {
	   
	     return "service";
	}
	
	@RequestMapping("/courses")                           
	public String couses() {
	 
	     
	    return "courses";
	}
	
	
	@RequestMapping("/join")                           
	public String joinUs() {
	 
	     
	    return "join";
	}
	
	@RequestMapping("/codes")                           
	public String codesUs() {
	 
	     
	    return "codes";
	}


	@RequestMapping("/icon")                           
	public String iconUs() {
	 
	     
	    return "allinquiry";
	}

	@RequestMapping("/con")                           
	public String iconUss() {
	 
	     
	    return "allinquiry";
	}
}
