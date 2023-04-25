package com.toppertutors.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.toppertutors.entity.MyService;
import com.toppertutors.entity.Teachers;
import com.toppertutors.service.Service1;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ServiceController {
	@Autowired
	private Service1 service1; 
	
	@GetMapping("/my_services")
	public String socialService(Model model) {
		
		List<MyService> myService = service1.getAllService();
		log.info("+++++++++++++++++++");
		//List<MyService> myService = service1.findAll();
		model.addAttribute("service",myService);
		System.out.println(myService);
		return "service";
		}

	
	
//	@GetMapping("/sonam")
//	public String getService(Model model) {
//		log.info("+++++++++++++++++++");
//		
//		List<MyService> myService = service1.getAllService();
//		model.addAttribute("listService",myService);
//		return "service";
//		
//	}
}
