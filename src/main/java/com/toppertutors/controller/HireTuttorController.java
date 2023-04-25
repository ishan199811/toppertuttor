package com.toppertutors.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.HireTuttorRepository;
import com.toppertutors.service.HireTuttorService;


@Controller
public class HireTuttorController {
	
	@Autowired
	HireTuttorService hireTuttorService;
	
	@Autowired
	HireTuttorRepository hireTuttorRepository;
	
	  @RequestMapping(value = "/hire", method = RequestMethod.GET)
	    public String initView(Model model) {
	       
	        model.addAttribute("hire", new HireTuttor());
	  
	        return "hireatutor";
	    }
	  
	  
	  @GetMapping("/student")
		public String topicList(Model model)
		{
			  List<HireTuttor> hire = hireTuttorService.findByHireTuttorId();
			 model.addAttribute("hire", hire);
	        System.out.println(hire);
	    
			return "tuttorHr";
			}
	 
	  
	  
	  @PostMapping("/sav")
		public String submitFor(@Valid @ModelAttribute("hire") HireTuttor hire,
		        BindingResult bindingResult, Model model) {
		    System.out.println(hire);
		     
		    if (bindingResult.hasErrors()) {       
		         
		        return "hireatutor";
		    } else {
		        return  hireTuttorService.save(hire);
		    }

		   
		}

	  @GetMapping("/delet/{id}")
		public String deleteUser(@PathVariable("id") long id, Model model) {
		    HireTuttor ht = hireTuttorRepository.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		    hireTuttorRepository.delete(ht);
		    return "redirect:/student";
		}
	  
	  
}
