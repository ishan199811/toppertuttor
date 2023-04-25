package com.toppertutors.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.toppertutors.entity.ApplyTuttor;
import com.toppertutors.entity.Contact;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.ApplyTuttorRepository;

import com.toppertutors.service.ApplyTuttorService;



@Controller

public class ApplyTutorController {
	
	
	
	@Autowired
	ApplyTuttorRepository applyTuttorRepository;
	
	@Autowired
	ApplyTuttorService applytuttorservice;
	
	 @RequestMapping(value = "/apply", method = RequestMethod.GET)
	    public String initView(Model model) {
	       
	        model.addAttribute("apply", new ApplyTuttor());
	  
	        return "applyastutor";
	    }
	
	 @PostMapping("/savee")
		public  String addTuttor(@Valid @ModelAttribute("apply") ApplyTuttor apply 
				,BindingResult  bindingResult, Model model
				,@RequestParam("profileImage") MultipartFile file) {
		
		
		   try {
			    System.out.println(apply);
			     
			    if (bindingResult.hasErrors()) {       
			         
			        return "applyastutor";
			        
			    } else {
			    	
			    	//processing and uploading file
			    	
			    	if(file.isEmpty()) {
			    		
			    		//if the file is empty 
			    		System.out.println("File is empty");
			    		
			    	}
			    	else {
			    		
			    		//upload the file folder and update
			    		apply.setImage(file.getOriginalFilename());
			    	File saveFile=	new ClassPathResource("static/images").getFile();
			    		
			    	Path path =	Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			    		
			    		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			    		System.out.println("Image is uploaded");
			    	}
			    	
			        
			    }
		   }
		   
			    catch(Exception e) {
			    	System.out.println("ERROR" +e.getMessage());
			    e.printStackTrace();
			    }
		   return applytuttorservice.save(apply);
		   }
	 
	 
	 
	 @GetMapping("/teacher")
		public String topicList(Model model)
		{
			  List<ApplyTuttor> apply = applytuttorservice.findByApplyTuttorId();
			 model.addAttribute("apply", apply);
	        System.out.println(apply);
	    
			return "ApTutor";
			}
	 @RequestMapping("/dele/{id}")
		public String deleteProduct(@PathVariable(name = "id") Long id) {
		 applytuttorservice.delete(id);
		    return "redirect:/teacher";       
		}
}
