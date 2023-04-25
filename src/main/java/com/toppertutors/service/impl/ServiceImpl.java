package com.toppertutors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.MyService;
import com.toppertutors.repository.ServiceRepository;
import com.toppertutors.service.Service1;
@Service
public class ServiceImpl implements Service1{
@Autowired
private ServiceRepository serviceRepository;
@Override
public List<MyService> getAllService() {
	
	return serviceRepository.findAll();
	
}
@Override
public void saveMyService(MyService myService) {
	this.serviceRepository.save(myService);
	
}
	

}
