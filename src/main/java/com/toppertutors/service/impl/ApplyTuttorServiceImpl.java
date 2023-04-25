package com.toppertutors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.ApplyTuttor;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;
import com.toppertutors.repository.ApplyTuttorRepository;
import com.toppertutors.service.ApplyTuttorService;

@Service
public class ApplyTuttorServiceImpl implements ApplyTuttorService{

	@Autowired
	ApplyTuttorRepository applyTuttorRepository;
	
	@Override
	public String save(ApplyTuttor  tuttorApply) {

		applyTuttorRepository.save(tuttorApply);
	return "index";
	}

	@Override
	public List<ApplyTuttor> findByApplyTuttorId() {
		return applyTuttorRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		applyTuttorRepository.deleteById(id);
	}
	}

	


