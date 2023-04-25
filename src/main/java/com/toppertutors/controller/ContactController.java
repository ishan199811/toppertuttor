package com.toppertutors.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.ContactRepository;
import com.toppertutors.repository.HireTuttorRepository;
import com.toppertutors.service.ContactService;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;
	
	Logger logger=LoggerFactory.getLogger(ContactController.class);

	@RequestMapping(value = "/contact", method = RequestMethod.GET)

    public String initView(Model model) {
       
      model.addAttribute("contact", new Contact());
  
        return "contact";
	}	
	
	
	@GetMapping("/contactdetail")
	public String contactList(Model model)
	
	
{
		List<Contact> contact = contactService.findByContactId();
		 model.addAttribute("contact", contact);
        System.out.println(contact);
    
		return "simplecontact";
		
	}
	
	
	
	@PostMapping("/save")
	public String submitForm(@Valid @ModelAttribute("contact") Contact contact,
	        BindingResult bindingResult) {
	    System.out.println(contact);
	     
	    if (bindingResult.hasErrors()) {       
	         
	        return "contact";
	    } 
	    else {
	    	
	    
	        return contactService.save(contact);
	    }
	}
	@PostMapping("/sssave")
	public@ResponseBody  String infoContact( @RequestBody String contact) {
	  
		
		log.info("-------------"+contact);
	    
		return null;
	    
	}
	

	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    contactService.delete(id);
	    return "redirect:/contactdetail";       
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditProductPage(@PathVariable("id") long id , Model model,Contact contact) {
		 model.addAttribute("contact", contact);
	    contactService.get(id);
	 
	     
	    return "editcontact";
	}
}

