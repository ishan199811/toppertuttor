package com.toppertutors.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.User;
import com.toppertutors.repository.RoleRepository;
import com.toppertutors.repository.UserRepository;
import com.toppertutors.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	  @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RoleRepository roleRepository;
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Override
	    public void save(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(new HashSet<>(roleRepository.findAll()));
	        userRepository.save(user);
	    }

	    @Override
	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	}