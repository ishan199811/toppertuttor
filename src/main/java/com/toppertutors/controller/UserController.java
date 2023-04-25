package com.toppertutors.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.User;
import com.toppertutors.repository.UserRepository;
import com.toppertutors.service.SecurityService;
import com.toppertutors.service.UserService;
import com.toppertutors.service.impl.UserValidator;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    
    @GetMapping("/test")
    public void test() {
    	System.out.println("this is test");
    }
    
    @GetMapping("/registerwithtt")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

       
        return "index";
    }

    
    
    
    
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
    	if (securityService.isAuthenticated()) {
            return "allinquiry";
        }
    	
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

  
}