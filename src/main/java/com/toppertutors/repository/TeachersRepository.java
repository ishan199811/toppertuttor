package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toppertutors.entity.Teachers;


public interface TeachersRepository extends JpaRepository<Teachers , Long> {
	List<Teachers> findAll();
	
	@Query("SELECT t FROM Teachers t WHERE CONCAT(t.name, t.address, t.phoneNo, t.subject , t.area ,t.student) LIKE %?1%")
	public List<Teachers> search(String keyword);
}