package com.toppertutors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.Contact;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.HireTuttorRepository;
import com.toppertutors.service.HireTuttorService;


@Service
public class HireTuttorServiceImpl implements HireTuttorService {

	@Autowired
	HireTuttorRepository hireTuttorRepository;
	
	
	@Override
	public String save(HireTuttor hire) {
		hireTuttorRepository.save(hire);
		return "index";
		
	}
	@Override
	public List<HireTuttor> findByHireTuttorId() {
		return hireTuttorRepository.findAll();
	}
	@Override
	public void delete(long id) {
		 hireTuttorRepository.deleteById(id);
		
	}
	
}
