package com.toppertutors.service;

import java.util.List;

import javax.validation.Valid;

import com.toppertutors.entity.Students;

public interface StudentService {

	List<Students> findAll();

	void save(@Valid Students student);

	void get(long id);

	void delete(long id);

	List<Students> listAll(String keyword);

	List<Students> listAll();

}
