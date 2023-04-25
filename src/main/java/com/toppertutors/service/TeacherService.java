package com.toppertutors.service;

import java.util.List;

import com.toppertutors.entity.Students;
import com.toppertutors.entity.Teachers;

public interface TeacherService {
void save(Teachers teacher);
	List<Teachers> findAll();
	
	void delete(long id);
	
	List<Teachers> listAll(String keyword);

	void get(long id);

	List<Teachers> listAll();
     
	List<Students>students(Long Id);
}
