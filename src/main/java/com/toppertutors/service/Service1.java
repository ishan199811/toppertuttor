package com.toppertutors.service;

import java.util.List;

import com.toppertutors.entity.MyService;

public interface Service1 {
	List<MyService> getAllService();
	//List<MyService> findAll();
void saveMyService(MyService myService);
}
