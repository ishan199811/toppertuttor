package com.toppertutors.service;

import java.util.List;

import com.toppertutors.entity.ApplyTuttor;
import com.toppertutors.entity.Contact;
import com.toppertutors.entity.HireTuttor;
import com.toppertutors.entity.playload.ResponseMessage;

public interface ApplyTuttorService {

	
String save(ApplyTuttor tuttorApply);



List<ApplyTuttor> findByApplyTuttorId();



void delete(Long id);









	
}

