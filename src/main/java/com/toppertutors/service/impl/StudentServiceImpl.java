package com.toppertutors.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.Students;

import com.toppertutors.repository.StudentRepository;
import com.toppertutors.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentrepossitory;

	@Override
	public List<Students> findAll() {
		
		return studentrepossitory.findAll();
	}

	@Override
	public void save(@Valid Students student) {
		
		 studentrepossitory.save(student);
	}

	@Override
	public void get(long id) {
		studentrepossitory.findById(id).get();;
		
	}

	@Override
	public void delete(long id) {
		studentrepossitory.deleteById(id);
	}

	@Override
	public List<Students> listAll(String keyword) {
		if (keyword != null) {
	        return studentrepossitory.search(keyword);
	    }
	    return studentrepossitory.findAll();
	}
	
	
	

	@Override
	public List<Students> listAll() {
		return studentrepossitory.findAll(Sort.by("name").ascending());
	}

	}
	
	
	
	
	


