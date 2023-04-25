package com.toppertutors.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.ContactRepository;
import com.toppertutors.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactRepository contactRepository;

	@Override
public String save(Contact contact) {
		
		
	 contactRepository.save(contact);
	return "index";
	}
	

	public List<Contact> findByContactId() {
		return contactRepository.findAll();
	}
	
	
	 public Contact get(long id) {
	        return contactRepository.findById(id).get();
	    }

	 public void delete(long id) {
		 contactRepository.deleteById(id);
	    }


	
}
