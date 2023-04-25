package com.toppertutors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.toppertutors.entity.Students;


public interface StudentRepository extends JpaRepository<Students , Long> {

	List<Students> findAll();

	@Query("SELECT s FROM Students s WHERE CONCAT(s.name, s.address, s.num, s.subject ) LIKE %?1%")
	List<Students> search(String keyword);
	
	
}
