package com.toppertutors.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.toppertutors.entity.Students;
import com.toppertutors.entity.Teachers;
import com.toppertutors.repository.TeachersRepository;
import com.toppertutors.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
@Autowired
TeachersRepository teacherRepo;


@Override
public void save( Teachers teacher) {
	
	 teacherRepo.save(teacher);
	 
}
	
@Override
public List<Teachers> findAll() {
	return teacherRepo.findAll();
}

@Override
public void delete(long id) {
	 teacherRepo.deleteById(id);
	
}
public List<Teachers> listAll(String keyword) {
    if (keyword != null) {
        return teacherRepo.search(keyword);
    }
    return teacherRepo.findAll();
}

@Override
public void get(long id) {
	teacherRepo.findById(id).get();
	
} 

public List<Teachers> listAll() {
    return teacherRepo.findAll(Sort.by("name").ascending());
}

@Override
public List<Students> students(Long Id) {
	
	return listAll(Id);
}
 
 
}
